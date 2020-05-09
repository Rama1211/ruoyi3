package com.ruoyi.web.controller.system.DailyOperation;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MisDiscipline;
import com.ruoyi.system.domain.MisRepair;
import com.ruoyi.system.service.DailyOperation.MisDisciplineService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisCampusService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 违纪信息操作处理
 *
 */
@Controller
@RequestMapping("/discipline/disciplineInfo")
public class DisciplineController extends BaseController {
    private String prefix = "DailyOperation/discipline";


    @Autowired
    private MisFloorService floorService;

    @Autowired
    private MisCampusService scampusService;

    @Autowired
    private MisDisciplineService disciplineService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/discipline";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisDiscipline discipline,String check) {
        startPage();
        List<MisDiscipline> list=new ArrayList<>();
        if(check==null){
            list= disciplineService.selectDisciplineList(discipline,check);
        }else {
            List<String> list1 = disciplineService.selectDisciplineStuList(check);
            for (String s:list1){
                List<MisDiscipline> misDisciplines = disciplineService.selectDisciplineListByStuNum(s);
                list.addAll(misDisciplines);
            }
        }
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
     * 修改违纪信息
     */
    @GetMapping("/edit/{disciplineId}")
    public String edit(@PathVariable("disciplineId") String disciplineId,ModelMap mmap)
    {
        mmap.put("discipline", disciplineService.selectDisciplineById(disciplineId));
        return prefix + "/edit";
    }

    /**
     * 修改保存维修信息
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MisDiscipline discipline) {
        discipline.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(disciplineService.updateDiscipline(discipline));
    }

    /**
     * 删除违纪信息
     */
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(disciplineService.deleteDisciplineByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

}
