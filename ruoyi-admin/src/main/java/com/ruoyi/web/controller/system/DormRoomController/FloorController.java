package com.ruoyi.web.controller.system.DormRoomController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.DormRoomService.MisCampusService;
import com.ruoyi.system.service.DormRoomService.MisFloorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 公寓信息管理
 * 
 * @author dg
 */
@Controller
@RequestMapping("/floor/floorInfo")
public class FloorController extends BaseController
{
    private String prefix = "dormRoom/floor";

    @Autowired
    private MisFloorService floorService;


    //查询校区楼栋信息
    @RequiresPermissions("floor/floorInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Long campusId)
    {
        startPage();
        List<MisFloor> list = floorService.selectFloorByCampusId(campusId);
        return getDataTable(list);
    }


    /**
     * 跳转楼栋信息页面
     */
    @RequiresPermissions("floor/floorInfo:select")
    @GetMapping("/select/{campusId}")
    public String select(@PathVariable("campusId") Long campusId, ModelMap mmap)
    {
        mmap.put("campusId",campusId);
        return prefix + "/index";
    }


}
