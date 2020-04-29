package com.ruoyi.web.controller.system.DailyOperation;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MisDiscipline;
import com.ruoyi.system.domain.MisVisitor;
import com.ruoyi.system.service.DailyOperation.MisDisciplineService;
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
 * 违纪信息操作处理
 *
 */
@Controller
@RequestMapping("/discipline/disciplineInfo")
public class DisciplineController extends BaseController {
    private String prefix = "DailyOperation/discipline";


    @Autowired
    private MisDisciplineService disciplineService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/discipline";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisDiscipline discipline) {
        startPage();
        List<MisDiscipline> list = disciplineService.selectDisciplineList(discipline);
        return getDataTable(list);
    }

}
