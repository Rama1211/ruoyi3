package com.ruoyi.web.controller.system.DailyOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.DailyOperation.MisDisciplineService;
import com.ruoyi.system.service.DailyOperation.MisItemService;
import com.ruoyi.system.service.DailyOperation.MisVusitorService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisCampusService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisFloorService;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 物品出入管理
 *
 */
@Controller
@RequestMapping("/item/itemInfo")
public class ItemController extends BaseController {
    private String prefix = "DailyOperation/item";


    @Autowired
    private MisVusitorService vusitorService;

    @Autowired
    private MisFloorService floorService;

    @Autowired
    private MisStudentService studentService;

    @Autowired
    private MisCampusService scampusService;

    @Autowired
    private MisItemService itemService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/item";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisItem item) {
        startPage();
        List<MisItem> list=itemService.selectItemList(item);
        return getDataTable(list);
    }

    /**
     * 新增违纪记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("user",ShiroUtils.getSysUser());
        mmap.put("campusName",ShiroUtils.getSysUser().getCampus());
        mmap.put("campusId",scampusService.selectMiScampusByName(ShiroUtils.getSysUser().getCampus()).getCampusId());
        mmap.put("floorName",ShiroUtils.getSysUser().getFloor());
        mmap.put("floorId",floorService.selectFloorByCampusId(mmap.get("campusId").toString(),ShiroUtils.getSysUser().getFloor()).get(0).getFloorId());
        return prefix + "/add";
    }

    /**
     * 新增保存物品出入记录
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MisItem item)
    {
        MisVisitor visitor=new MisVisitor();
        visitor.setCampusName(item.getCampusName());
        visitor.setFloorName(item.getFloorName());
        visitor.setRoomNum(Integer.parseInt(item.getRoomNum()));
        visitor.setStudentNum(item.getStudentNum());
        if (vusitorService.selectVisitorInfo(visitor)==0){
            return error("学生与宿舍不符");
        }
        MisStudent student = studentService.selectStudentById(Long.parseLong(item.getStudentNum()));
        if (!(student.getStudentName().equals(item.getStudentName()))){
            return error("学生姓名与学号不符");
        }
        item.setCampusName(scampusService.selectMiScampusById(Long.parseLong(item.getCampusName())).getCampusName());
        item.setFloorName(floorService.selectFloorById(item.getFloorName()).getFloorName());
        return toAjax(itemService.insertItem(item));
    }

    /**
     * 修改物品出入信息
     */
    @GetMapping("/edit/{itemId}")
    public String edit(@PathVariable("itemId") String Id, ModelMap mmap) {
        mmap.put("item", itemService.selecItemById(Id));
        return prefix + "/edit";
    }


    /**
     * 修改保存物品出入信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated  MisItem item) {
        item.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(itemService.updateItem(item));
    }

    /**
     * 删除物品出入信息
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(itemService.deleteItemByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
