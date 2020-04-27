package com.ruoyi.web.controller.system.statistics;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MisVisitor;
import com.ruoyi.system.service.DailyOperation.MisVusitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 院系学生分布
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/statistics/distributedInfo")
public class distributedController extends BaseController {
    private String prefix = "statistics/distributed";


    @Autowired
    private MisVusitorService vusitorService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/distributed.html";
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
