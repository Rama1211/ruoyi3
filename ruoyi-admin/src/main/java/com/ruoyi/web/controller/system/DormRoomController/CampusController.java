package com.ruoyi.web.controller.system.DormRoomController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.DormRoomService.MisCampusService;
import com.ruoyi.system.service.DormRoomService.MisFloorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 公寓信息管理
 * 
 * @author dg
 */
@Controller
@RequestMapping("/campus/campusInfo")
public class CampusController extends BaseController
{
    private String prefix = "dormRoom/campus";

    @Autowired
    private MisCampusService scampusService;



    @RequiresPermissions("campus:campusInfo:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/index";
    }

    //查询公寓列表
    @RequiresPermissions("campus:campusInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MiScampus scampus)
    {
        startPage();
        List<MiScampus> list = scampusService.selectScampusList(scampus);
        return getDataTable(list);
    }

    /**
     * 修改校区
     */
    @GetMapping("/edit/{campusId}")
    public String edit(@PathVariable("campusId") Long campusId, ModelMap mmap)
    {
        mmap.put("dorm", scampusService.selectMiScampusById(campusId));
        return prefix + "/edit";
    }


    /**
     * 修改保存校区
     */
    @RequiresPermissions("campus:campusInfo:edit")
    @Log(title = "校区管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MiScampus scampus)
    {

        scampus.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(scampusService.updateScampus(scampus));
    }

    /**
     * 新增校区
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增校区信息保存
     */
    @RequiresPermissions("campus:campusInfo:add")
    @Log(title = "校区信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MiScampus scampus)
    {
        scampus.setFloorNum("0");
        if (UserConstants.CAMPUS_NAME_NOT_UNIQUE.equals(scampusService.checkCampusNameUnique(scampus)))
        {
            return error("新增校区'" + scampus.getCampusName() + "'失败，该校区名称已存在");
        }
        scampus.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(scampusService.insertCampus(scampus));
    }



    /**
     * 删除校区信息
     */
    @RequiresPermissions("campus:campusInfo:remove")
    @Log(title = "校区信息管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(scampusService.deleteCampus(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

}
