package com.ruoyi.web.controller.system.DailyOperation;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.DailyOperation.MisVusitorService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisCampusService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisFloorService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisPeropertyService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisRoomService;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 访客信息操作处理
 *
 */
@Controller
@RequestMapping("/visitors/visitorsInfo")
public class VisitorsController extends BaseController {
    private String prefix = "DailyOperation/visitor";

    @Autowired
    private MisCampusService scampusService;

    @Autowired
    private MisStudentService studentService;

    @Autowired
    private MisFloorService floorService;

    @Autowired
    private MisVusitorService vusitorService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/visitor";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisVisitor visitor) {
        startPage();
        List<MisVisitor> list = vusitorService.selectVisitorList(visitor);
        return getDataTable(list);
    }
    /**
     * 新增访客记录
     */
    @GetMapping("/add")
    public String add(String campusName, String floorName, ModelMap mmap) {
        mmap.put("user",ShiroUtils.getSysUser());
        mmap.put("campusName",campusName);
        mmap.put("campusId",scampusService.selectMiScampusByName(campusName).getCampusId());
        mmap.put("floorName",floorName);
        mmap.put("floorId",floorService.selectFloorByCampusId(mmap.get("campusId").toString(),floorName).get(0).getFloorId());
        return prefix + "/add";
    }

    /**
     * 新增保存访客记录
     */
    @Log(title = "访客信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MisVisitor visitor)
    {
        if (vusitorService.selectVisitorInfo(visitor)==0){
            return error("学生与宿舍不符");
        }
        if (!studentService.selectStudentById(Long.parseLong(visitor.getStudentNum())).getStudentName().equals(visitor.getStudentName())){
            return error("学生姓名与学号不符");
        }
        visitor.setCampusName(scampusService.selectMiScampusById(Long.parseLong(visitor.getCampusName())).getCampusName());
        visitor.setFloorName(floorService.selectFloorById(visitor.getFloorName()).getFloorName());
        return toAjax(vusitorService.insertVisitor(visitor));
    }

    /**
     * 修改访客信息
     */
    @GetMapping("/edit/{Id}")
    public String edit(@PathVariable("Id") String Id, ModelMap mmap) {
        mmap.put("visitor", vusitorService.selectVisitorById(Id));
        return prefix + "/edit";
    }

    /**
     * 修改保存访客信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MisVisitor visitor) {
        return toAjax(vusitorService.updateVisitor(visitor));
    }

    /**
     * 删除访客信息
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(vusitorService.deleteVisitorByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
