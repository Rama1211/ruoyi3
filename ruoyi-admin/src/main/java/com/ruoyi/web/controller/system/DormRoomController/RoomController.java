package com.ruoyi.web.controller.system.DormRoomController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.service.DormRoomService.MisCampusService;
import com.ruoyi.system.service.DormRoomService.MisFloorService;
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

//    @RequiresPermissions("room:roomInfo:view")
    @GetMapping()
    public String operlog( ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/room";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String campusId, String floorId) {
        startPage();
        MiScampus miScampus=new MiScampus();
        List<MisRoom> list=new ArrayList<>();
        if (campusId==null || StringUtils.isEmpty(campusId)){
            list = roomService.selectRoomList(campusId, floorId);
        }else {
            miScampus = scampusService.selectMiScampusByName(campusId);
            list = roomService.selectRoomList(miScampus.getCampusId(), floorId);
        }
        return getDataTable(list);
    }


    /**
     * 新增房间
     */
    @GetMapping("/add")
    public String add(String campusName,String floorName,ModelMap mmap)
    {
        mmap.put("campusName",campusName);
        mmap.put("floorName",floorName);
        mmap.put("user", ShiroUtils.getSysUser());
        if (StringUtils.isNotEmpty(campusName)){
            mmap.put("campusId", scampusService.selectMiScampusByName(campusName).getCampusId());
            mmap.put("floorId",floorService.selectFloorByCampusId(scampusService.selectMiScampusByName(campusName).getCampusId(),floorName));
        }
        return prefix + "/add";
    }

    /**
     * 批量新增房间
     */
    @GetMapping("/batchAdd")
    public String batchAdd(String campusName,String floorName,ModelMap mmap)
    {
        mmap.put("campusName",campusName);
        mmap.put("floorName",floorName);
        mmap.put("user", ShiroUtils.getSysUser());
        if (StringUtils.isNotEmpty(campusName)){
            mmap.put("campusId", scampusService.selectMiScampusByName(campusName).getCampusId());
            mmap.put("floorId",floorService.selectFloorByCampusId(scampusService.selectMiScampusByName(campusName).getCampusId(),floorName));
        }
        return prefix + "/batchAdd";
    }


    @Log(title = "房间管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(roomService.deleteRoomByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 新增保存房间
     */
    @Log(title = "房间管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MisRoom room)
    {
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
    public AjaxResult editSave(@Validated MisRoom room)
    {

        room.setUpdateBy(ShiroUtils.getLoginName());
        String s=room.getStatus();
        room.setStatus(s);
        return toAjax(roomService.updateRoom(room));
    }
//
//    /**
//     * 校验岗位名称
//     */
//    @PostMapping("/checkPostNameUnique")
//    @ResponseBody
//    public String checkPostNameUnique(SysPost post)
//    {
//        return postService.checkPostNameUnique(post);
//    }
//
//    /**
//     * 校验岗位编码
//     */
//    @PostMapping("/checkPostCodeUnique")
//    @ResponseBody
//    public String checkPostCodeUnique(SysPost post)
//    {
//        return postService.checkPostCodeUnique(post);
//    }
}
