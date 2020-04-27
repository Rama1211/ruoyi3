package com.ruoyi.web.controller.system.AccommodationController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MisAccommodation;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisAccommodationService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisCampusService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisFloorService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisRoomService;
import com.ruoyi.system.service.baseInfo.student.MisStudentFacultyService;
import com.ruoyi.system.service.baseInfo.student.MisStudentProfessionService;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
import com.ruoyi.web.controller.system.BaseInfoController.RoomController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 学生住宿管理
 *
 * @author dg
 */
@Controller
@RequestMapping("/accommodation/distributionInfo")
public class StudentDistributionController extends BaseController {
    private String prefix = "Accommodation/distribution";

    @Autowired
    private MisFloorService floorService;


    @Autowired
    private MisCampusService campusService;

    @Autowired
    private MisStudentService studentService;

    @Autowired
    private MisRoomService roomService;


    @Autowired
    private MisAccommodationService accommodationService;

    @GetMapping()
    public String operlog() {
        return prefix + "/index";
    }

    //查询学生列表
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisStudent student) {
        startPage();
        List<MisStudent> list = studentService.selectStudentListOnDistributionInfo(student);
        return getDataTable(list);
    }

    /**
     * 分配选择宿舍
     */
    @GetMapping("/distribution")
    public String distribution(String studentId, String gender, ModelMap mmap) {
        mmap.put("studentId", studentId);
        mmap.put("gender", gender);
        return prefix + "/select";
    }

    /**
     * 分配宿舍
     */
    @Log(title = "学生宿舍管理", businessType = BusinessType.INSERT)
    @PostMapping("/distribution")
    @ResponseBody
    public AjaxResult distribution(String campusId, String floorId, String studentId) {
        List<MisFloor> list = floorService.selectFloorByCampusId(campusId, floorId);
        MisFloor floor=list.get(0);
        String[] split = studentId.split(",");
        List<Long> stuId = new ArrayList<>();
        for (String s : split) {
            stuId.add(Long.parseLong(s));
        }
        Collections.sort(stuId);
      for (Long l : stuId) {
          go: for (int i = 1; i <= Integer.parseInt(floor.getFloorLevel()); i++) {
                List<MisRoom> rooms = roomService.selectRoomByFloorId(list.get(0).getFloorId(), i);
                for (MisRoom room : rooms) {
                    if (room.getEarlyCheckIn() == null || room.getEarlyCheckIn() < room.getDormShouldPeople()) {
                        MisAccommodation accommodation=new MisAccommodation();
                        accommodation.setRoomId(Long.parseLong(room.getDormId().toString()));
                        accommodation.setStudentNum(l);
                        accommodation.setCheckInStatus("0");
                        accommodationService.insertAccommodation(accommodation);
                        String fl=floorService.selectFloorById(room.getFloorId().toString()).getFloorName();
                        String ca=campusService.selectMiScampusById(Long.parseLong(room.getCampusId().toString())).getCampusName();
                        studentService.updateApartment(l,room.getDormNum(),fl,ca,ShiroUtils.getLoginName());
                        if (room.getEarlyCheckIn()==null){
                            roomService.updateEarlyCheckIn(1,room.getDormId());
                        }else {
                            roomService.updateEarlyCheckIn(room.getEarlyCheckIn()+1,room.getDormId());
                        }
                        break go;
                    }
                }
            }
        }
        return toAjax(1);
    }
}
