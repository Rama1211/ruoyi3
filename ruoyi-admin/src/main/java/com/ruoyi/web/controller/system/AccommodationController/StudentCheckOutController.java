package com.ruoyi.web.controller.system.AccommodationController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisAccommodationService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisPeropertyService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisRoomService;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学生入住
 *
 * @author dg
 */
@Controller
@RequestMapping("/accommodation/checkOutInfo")
public class StudentCheckOutController extends BaseController {
    private String prefix = "Accommodation/checkOut";

    @Autowired
    private MisRoomService roomService;

    @Autowired
    private MisPeropertyService peropertyService;

    @Autowired
    private MisAccommodationService accommodationService;

    @Autowired
    private MisStudentService studentService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/index";
    }

    //查询已入住学生列表
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisStudent student) {
        startPage();
        List<MisStudent> list = studentService.selectStudentListOnCheckOut(student);
        return getDataTable(list);
    }

    //退宿时查看物品
    @PostMapping("/list2")
    @ResponseBody
    public TableDataInfo list2(MisProperty property) {
        startPage();
        List<MisProperty> list = peropertyService.selectPropertyList(property.getDormRoomId().toString(),"");
        return getDataTable(list);
    }


    /**跳转退宿页面
     */
    @GetMapping("/checkOut/{studentId}")
    public String edit(@PathVariable("studentId") long studentId, ModelMap mmap) {
        mmap.put("roomId",accommodationService.selectAccommodationById(studentId).getRoomId().toString());
        mmap.put("studentId",studentId);
        return prefix + "/edit";
    }

    /**
     * 退宿确认
     */
    @PostMapping("/checkOut")
    @ResponseBody
    public AjaxResult addSaveBatch(String roomId, Long studentId) {
        studentService.updateApartment(studentId,"","","",ShiroUtils.getLoginName());
        MisRoom room=roomService.selectRoomById(accommodationService.selectAccommodationById(studentId).getRoomId());
        accommodationService.checnkOut(studentId);
       room.setDormActualPeople(room.getDormActualPeople()-1);
       room.setEarlyCheckIn(room.getEarlyCheckIn()-1);
        return toAjax(roomService.updateRoom(room));
    }
}
