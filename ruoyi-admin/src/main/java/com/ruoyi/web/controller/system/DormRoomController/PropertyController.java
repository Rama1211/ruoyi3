package com.ruoyi.web.controller.system.DormRoomController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisProperty;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.service.DormRoomService.MisCampusService;
import com.ruoyi.system.service.DormRoomService.MisFloorService;
import com.ruoyi.system.service.DormRoomService.MisPeropertyService;
import com.ruoyi.system.service.DormRoomService.MisRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.introspector.MissingProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 财物信息操作处理
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/property/propertyInfo")
public class PropertyController extends BaseController {
    private String prefix = "dormRoom/property";

    @Autowired
    private MisPeropertyService peropertyService;



    /**
     * 跳转财物信息页面
     */
//    @RequiresPermissions("floor:floorInfo:select")
    @GetMapping("/select/{dormId}")
    public String select(@PathVariable("dormId") Long dormId, ModelMap mmap)
    {
        mmap.put("campusId",dormId);
        mmap.put("user",ShiroUtils.getSysUser());
        return prefix + "/index";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisProperty property) {
        startPage();
        List<MisProperty> list = peropertyService.selectPropertyList(property);
        return getDataTable(list);
    }


}
