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
    @GetMapping("/select/{dormId}")
    public String select(@PathVariable("dormId") Long dormId, ModelMap mmap)
    {
        mmap.put("dormId",dormId);
        mmap.put("user",ShiroUtils.getSysUser());
        return prefix + "/index";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String dormId,String propertyName) {
        startPage();
        List<MisProperty> list = peropertyService.selectPropertyList(dormId,propertyName);
        return getDataTable(list);
    }

    /**
     * 修改财物信息
     */
    @GetMapping("/edit/{propertyId}")
    public String edit(@PathVariable("propertyId") String propertyId,ModelMap mmap)
    {
        mmap.put("dorm", peropertyService.selectPropertyById(propertyId));
        mmap.put("propertyId", propertyId);
        return prefix + "/edit";
    }

    /**
     * 修改保存财物信息
     */
    @Log(title = "财物信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MisProperty property)
    {

        property.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(peropertyService.updateProperty(property));
    }

    /**
     * 删除财物信息
     */
    @Log(title = "财物管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(peropertyService.deletePropertyByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 新增财物
     */
    @GetMapping("/add")
    public String add(String dormId,ModelMap mmap)
    {
        mmap.put("dormId",dormId);
        return prefix + "/add";
    }

    /**
     * 新增保存财物
     */
    @Log(title = "财物管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MisProperty property)
    {
        property.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(peropertyService.insertProperty(property));
    }


}
