package com.ruoyi.web.controller.system.AccommodationController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisAccommodationService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisCampusService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisFloorService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisRoomService;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 学生入住
 *
 * @author dg
 */
@Controller
@RequestMapping("/accommodation/checkInfo")
public class StudentCheckInController extends BaseController {
    private String prefix = "Accommodation/checkIn";

    @Autowired
    private MisRoomService roomService;

    @Autowired
    private MisAccommodationService accommodationService;

    @Autowired
    private MisStudentService studentService;

    @GetMapping()
    public String operlog(ModelMap mmap) {
        mmap.put("user", ShiroUtils.getSysUser());
        return prefix + "/index";
    }

    //查询未入住学生列表
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisStudent student) {
        startPage();
        List<MisStudent> list = studentService.selectStudentListOnCheck(student);
        return getDataTable(list);
    }

    /**
     * 学生入住
     */
    @GetMapping("/checkIn")
    public @ResponseBody MisRoom checkIn(long studentId) {
        //更新入住表中状态
        accommodationService.checnkIn(studentId);
        MisAccommodation accommodation = accommodationService.selectAccommodationById(studentId);
        MisRoom room = roomService.selectRoomById(accommodation.getRoomId());
        room.setDormActualPeople(room.getDormActualPeople()+1);
        roomService.updateRoom(room);
          return room;
    }
}
