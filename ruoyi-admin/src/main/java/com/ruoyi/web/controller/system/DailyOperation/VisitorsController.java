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
 * @author ruoyi
 */
@Controller
@RequestMapping("/visitors/visitorsInfo")
public class VisitorsController extends BaseController {
    private String prefix = "DailyOperation/visitor";


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
        return prefix + "/add";
    }
}
