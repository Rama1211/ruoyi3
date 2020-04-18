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

    @Autowired
    private MisCampusService scampusService;
    //查询校区楼栋信息
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String campusId,@RequestParam(defaultValue = "") String floorId)
    {
        startPage();
        List<MisFloor> list = floorService.selectFloorByCampusId(campusId,floorId);
        return getDataTable(list);
    }


    /**
     * 跳转楼栋信息页面
     */
//    @RequiresPermissions("floor:floorInfo:select")
    @GetMapping("/select/{campusId}")
    public String select(@PathVariable("campusId") Long campusId, ModelMap mmap)
    {
        mmap.put("campusId",campusId);
        mmap.put("user",ShiroUtils.getSysUser());
        return prefix + "/index";
    }

    /**
     * 新增楼栋
     */
//    @RequiresPermissions("floor:floorInfo:add")
    @GetMapping("/add")
    public String add(Long campusId,ModelMap mmap)
    {
        mmap.put("campusId",campusId);
        return prefix + "/add";
    }

    /**
     * 新增楼栋信息保存
     */
//    @RequiresPermissions("floor:floorInfo:add")
    @Log(title = "楼栋信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MisFloor floor)
    {
        floor.setFloorName(floor.getFloorName()+"号楼");
        if (UserConstants.FLOOR_NAME_NOT_UNIQUE.equals(floorService.checkFloorNameUnique(floor)))
        {
            return error("新增楼栋'" + floor.getFloorName() + "'失败，该楼栋已存在");
        }
        floor.setCreateBy(ShiroUtils.getLoginName());
        floor.setCampusName(scampusService.selectMiScampusById(Long.parseLong(floor.getCampusId())).getCampusName());
        return toAjax(floorService.insertFloor(floor,"true"));
    }

    /**
     * 修改楼栋信息
     */
    @GetMapping("/edit/{floorId}")
    public String edit(@PathVariable("floorId") String floorId,ModelMap mmap)
    {
        mmap.put("dorm", floorService.selectFloorById(floorId));
        return prefix + "/edit";
    }

    /**
     * 修改保存楼栋
     */
//    @RequiresPermissions("floor:floorInfo:edit")
    @Log(title = "楼栋信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MisFloor floor)
    {

        floor.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(floorService.updateFloor(floor));
    }

    /**
     * 删除楼栋信息
     */
//    @RequiresPermissions("floor:floorInfo:remove")
    @Log(title = "楼栋信息管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(floorService.deleteFloor(ids,ShiroUtils.getLoginName()));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
