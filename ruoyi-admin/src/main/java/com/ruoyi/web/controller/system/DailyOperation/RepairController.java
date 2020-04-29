package com.ruoyi.web.controller.system.DailyOperation;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MisRepair;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.MisVisitor;
import com.ruoyi.system.service.DailyOperation.MisRepairService;
import com.ruoyi.system.service.DailyOperation.MisVusitorService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisCampusService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisFloorService;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 维修信息操作处理
 *
 */
@Controller
@RequestMapping("/repair/repairInfo")
public class RepairController extends BaseController {
    private String prefix = "DailyOperation/repair";


    @Autowired
    private MisVusitorService vusitorService;

    @Autowired
    private MisStudentService studentService;

    @Autowired
    private MisRepairService repairService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/repair";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisRepair repair) {
        startPage();
        List<MisRepair> list = repairService.selectRepairList(repair);
        return getDataTable(list);
    }

    /**
     * 修改维修信息
     */
    @GetMapping("/edit/{repairId}")
    public String edit(@PathVariable("repairId") String repairId,ModelMap mmap)
    {
        mmap.put("repair", repairService.selectRepairById(repairId));
        return prefix + "/edit";
    }

    /**
     * 查看详细维修信息
     */
    @GetMapping("/detail/{repairId}")
    public String detail(@PathVariable("repairId") String repairId,ModelMap mmap)
    {
        mmap.put("repair", repairService.selectRepairById(repairId));
        return prefix + "/detail";
    }

    /**
     * 修改保存维修信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MisRepair repair) {

        repair.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(repairService.updateRepair(repair));
    }

    /**
     * 删除维修信息
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(repairService.deleteRepairByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 新增维修记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存维修记录
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MisRepair repair)
    {
        MisVisitor visitor=new MisVisitor();
        visitor.setCampusName(repair.getRepairCampus());
        visitor.setFloorName(repair.getRepairFloor());
        visitor.setRoomNum(Integer.parseInt(repair.getRepairDormId()));
        visitor.setStudentNum(repair.getRepairStudentNum().toString());
        if (vusitorService.selectVisitorInfo(visitor)==0){
            return error("学生与宿舍不符");
        }
        MisStudent student = studentService.selectStudentById(repair.getRepairStudentNum());
        if (!(student.getStudentName().equals(repair.getRepairStudentName()))){
            return error("学生姓名与学号不符");
        }
        repair.setStatus("0");
        return toAjax(repairService.insertRepair(repair));
    }

}
