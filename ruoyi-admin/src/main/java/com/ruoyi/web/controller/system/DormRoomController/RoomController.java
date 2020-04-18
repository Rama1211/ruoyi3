package com.ruoyi.web.controller.system.DormRoomController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.DormRoomService.MisCampusService;
import com.ruoyi.system.service.DormRoomService.MisFloorService;
import com.ruoyi.system.service.DormRoomService.MisPeropertyService;
import com.ruoyi.system.service.DormRoomService.MisRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 房间信息操作处理
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/room/roomInfo")
public class RoomController extends BaseController {
    private String prefix = "dormRoom/room";

    @Autowired
    private MisCampusService scampusService;

    @Autowired
    private MisFloorService floorService;

    @Autowired
    private MisRoomService roomService;

    @Autowired
    private MisPeropertyService peropertyService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/room";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String campusId, String floorId) {
        MiScampus miScampus = new MiScampus();
        List<MisRoom> list = new ArrayList<>();
        if (campusId == null || StringUtils.isEmpty(campusId)) {
            startPage();
            list = roomService.selectRoomList(campusId, floorId);
        } else {
            miScampus = scampusService.selectMiScampusByName(campusId);
            startPage();
            list = roomService.selectRoomList(miScampus.getCampusId(), floorId);
        }
        return getDataTable(list);
    }


    /**
     * 新增房间
     */
    @GetMapping("/add")
    public String add(String campusName, String floorName, ModelMap mmap) {
        mmap.put("campusName", campusName);
        mmap.put("floorName", floorName);
        mmap.put("user", ShiroUtils.getSysUser());
        if (StringUtils.isNotEmpty(campusName)) {
            mmap.put("campusId", scampusService.selectMiScampusByName(campusName).getCampusId());
            mmap.put("floorId", floorService.selectFloorByCampusId(scampusService.selectMiScampusByName(campusName).getCampusId(), floorName));
        }
        return prefix + "/add";
    }

    /**
     * 批量新增房间
     */
    @GetMapping("/batchAdd")
    public String batchAdd(String campusName, String floorName, ModelMap mmap) {
        mmap.put("campusName", campusName);
        mmap.put("floorName", floorName);
        mmap.put("user", ShiroUtils.getSysUser());
        if (StringUtils.isNotEmpty(campusName)) {
            mmap.put("campusId", scampusService.selectMiScampusByName(campusName).getCampusId());
            mmap.put("floorId", floorService.selectFloorByCampusId(scampusService.selectMiScampusByName(campusName).getCampusId(), floorName));
        }
        return prefix + "/batchAdd";
    }


    @Log(title = "房间管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(roomService.deleteRoomByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 批量新增保存房间
     */
    @Log(title = "房间管理", businessType = BusinessType.INSERT)
    @PostMapping("/batchAdd")
    @ResponseBody
    public AjaxResult addSaveBatch(@Validated MisRoom room, int AdddormNumber,String propertyName) {
        int a=Integer.parseInt(getdormNum(room.getFloorId(),room.getCampusId(),room.getFloorLevel()));
        for (int i = 1; i <= AdddormNumber; i++) {
            MisRoom room1 = new MisRoom();
            room1.setStatus("0");
            room1.setDormType(room.getDormType());
            room1.setDormShouldPeople(room.getDormShouldPeople());
            room1.setDormActualPeople(room.getDormActualPeople());
            room1.setFloorLevel(room.getFloorLevel());
            room1.setCampusId(room.getCampusId());
            room1.setFloorId(room.getFloorId());
            room1.setDormNum(String.valueOf(a+i));
            room1.setCreateBy(ShiroUtils.getLoginName());
            room1.setUpdateBy(ShiroUtils.getLoginName());
            int i1 = roomService.insertRoom(room1);
            getProperty(propertyName,String.valueOf(room1.getDormId()));
        }
        return toAjax(1);
    }

    /**
     * 新增保存房间
     */
    @Log(title = "房间管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MisRoom room) {
        if (UserConstants.ROOM_CODE_NOT_UNIQUE.equals(roomService.checkDormmNumUnique(room))) {
            return error("新增宿舍'" + room.getDormNum() + "'失败，宿舍号已存在");
        }
        room.setStatus("0");
        room.setCreateBy(ShiroUtils.getLoginName());
        room.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(roomService.insertRoom(room));
    }


    /**
     * 修改房间信息
     */
    @GetMapping("/edit/{dormId}")
    public String edit(@PathVariable("dormId") long dormId, ModelMap mmap) {
        mmap.put("room", roomService.selectRoomById(dormId));
        return prefix + "/edit";
    }

    /**
     * 修改保存房间信息
     */
    @Log(title = "房间管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MisRoom room) {

        room.setUpdateBy(ShiroUtils.getLoginName());
        String s = room.getStatus();
        room.setStatus(s);
        return toAjax(roomService.updateRoom(room));
    }

    public String getdormNum(int floorId,int campusId,int floorLevel) {
        String a=roomService.selectminNum(floorId,campusId,floorLevel);
        if (a==null){
            a=String.valueOf(floorLevel)+"0"+"0";
        }
        return a;
    }

    public void getProperty(String modelName,String dormId) {
        List<MisPropertyTemplate> misPropertyTemplate = peropertyService.selectPropertyTem(modelName);
        for (MisPropertyTemplate propertyTemplate:misPropertyTemplate){
            MisProperty property=new MisProperty();
            property.setPropertyStatus("0");
            property.setDormRoomId(Long.parseLong(dormId));
            property.setPropertyName(propertyTemplate.getProName());
            property.setPropertyAmount(propertyTemplate.getProNum());
            peropertyService.insertProperty(property);
        }
    }

}
