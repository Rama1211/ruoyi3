package com.ruoyi.web.controller.system.DormRoomController;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.service.DormRoomService.MisCampusService;
import com.ruoyi.system.service.DormRoomService.MisRoomService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 房间信息操作处理
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/room/roomInfo")
public class RoomController extends BaseController {
    private String prefix = "dormRoom/room";

    @Autowired
    private MisCampusService scampusService;

    @Autowired
    private MisRoomService roomService;

//    @RequiresPermissions("room:roomInfo:view")
    @GetMapping()
    public String operlog( ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/room";
    }

//    @RequiresPermissions("room:roomInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String campusId, String floorId) {
        startPage();
        MiScampus miScampus = scampusService.selectMiScampusByName(campusId);
        List<MisRoom> list = roomService.selectRoomList(miScampus.getCampusId(), floorId);
        return getDataTable(list);
    }


//
//    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
//    @RequiresPermissions("system:post:export")
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(SysPost post)
//    {
//        List<SysPost> list = postService.selectPostList(post);
//        ExcelUtil<SysPost> util = new ExcelUtil<SysPost>(SysPost.class);
//        return util.exportExcel(list, "岗位数据");
//    }
//
//    @RequiresPermissions("system:post:remove")
//    @Log(title = "岗位管理", businessType = BusinessType.DELETE)
//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        try
//        {
//            return toAjax(postService.deletePostByIds(ids));
//        }
//        catch (Exception e)
//        {
//            return error(e.getMessage());
//        }
//    }
//
//    /**
//     * 新增岗位
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存岗位
//     */
//    @RequiresPermissions("system:post:add")
//    @Log(title = "岗位管理", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(@Validated SysPost post)
//    {
//        if (UserConstants.POST_NAME_NOT_UNIQUE.equals(postService.checkPostNameUnique(post)))
//        {
//            return error("新增岗位'" + post.getPostName() + "'失败，岗位名称已存在");
//        }
//        else if (UserConstants.POST_CODE_NOT_UNIQUE.equals(postService.checkPostCodeUnique(post)))
//        {
//            return error("新增岗位'" + post.getPostName() + "'失败，岗位编码已存在");
//        }
//        post.setCreateBy(ShiroUtils.getLoginName());
//        return toAjax(postService.insertPost(post));
//    }
//

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{dormId}")
    public String edit(@PathVariable("dormId") long dormId, ModelMap mmap) {
        mmap.put("room", roomService.selectRoomById(dormId));
        return prefix + "/edit";
    }
//
//    /**
//     * 修改保存岗位
//     */
//    @RequiresPermissions("system:post:edit")
//    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(@Validated SysPost post)
//    {
//        if (UserConstants.POST_NAME_NOT_UNIQUE.equals(postService.checkPostNameUnique(post)))
//        {
//            return error("修改岗位'" + post.getPostName() + "'失败，岗位名称已存在");
//        }
//        else if (UserConstants.POST_CODE_NOT_UNIQUE.equals(postService.checkPostCodeUnique(post)))
//        {
//            return error("修改岗位'" + post.getPostName() + "'失败，岗位编码已存在");
//        }
//        post.setUpdateBy(ShiroUtils.getLoginName());
//        return toAjax(postService.updatePost(post));
//    }
//
//    /**
//     * 校验岗位名称
//     */
//    @PostMapping("/checkPostNameUnique")
//    @ResponseBody
//    public String checkPostNameUnique(SysPost post)
//    {
//        return postService.checkPostNameUnique(post);
//    }
//
//    /**
//     * 校验岗位编码
//     */
//    @PostMapping("/checkPostCodeUnique")
//    @ResponseBody
//    public String checkPostCodeUnique(SysPost post)
//    {
//        return postService.checkPostCodeUnique(post);
//    }
}
