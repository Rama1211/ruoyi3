package com.ruoyi.web.controller.system.BaseInfoController;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MisAccommodation;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.vo.MisStudentVo;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisAccommodationService;
import com.ruoyi.system.service.baseInfo.student.MisStudentFacultyService;
import com.ruoyi.system.service.baseInfo.student.MisStudentProfessionService;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生信息管理
 * 
 * @author dg
 */
@Controller
@RequestMapping("/student/studentInfo")
public class StudentInfoController extends BaseController
{
    private String prefix = "baseInfo//student/studentInfo";

    @Autowired
    private MisStudentFacultyService facultyService;

    @Autowired
    private MisStudentProfessionService professionService;

    @Autowired
    private MisStudentService studentService;

    @Autowired
    private MisAccommodationService accommodationService;

    @GetMapping()
    public String operlog()
    {
        return prefix + "/index";
    }

    //查询学生列表
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisStudent student)
    {
        startPage();
        List<MisStudent> list = studentService.selectStudentList(student);
        List<MisStudentVo> list2 =new ArrayList<>();
        for (MisStudent student1:list){
            MisStudentVo misStudentVo=new MisStudentVo();
            MisAccommodation accommodation = accommodationService.selectAccommodationById(student1.getStudentId());
            if (accommodation!=null){
                misStudentVo.setInTime(accommodation.getCheckInTime());
                misStudentVo.setOutTime(accommodation.getCheckoutTime());
            }
            misStudentVo.setStudentId(student1.getStudentId());
            misStudentVo.setStudentName(student1.getStudentName());
            misStudentVo.setStudentFaculty(student1.getStudentFaculty());
            misStudentVo.setStudentProfession(student1.getStudentProfession());
            misStudentVo.setStudentClass(student1.getStudentClass());
            misStudentVo.setApartmentId(student1.getApartmentId());
            misStudentVo.setStudentYear(student1.getStudentYear());
            misStudentVo.setGender(student1.getGender());
            misStudentVo.setAddress(student1.getAddress());
            misStudentVo.setFloorId(student1.getFloorId());
            misStudentVo.setCampusName(student1.getCampusName());
            list2.add(misStudentVo);
        }
        return getDataTable(list2);
    }

        /**
     * 新增学生
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

        /**
     * 新增学生信息
     */
    @Log(title = "学生信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated MisStudent student)
    {
        if (UserConstants.STUDENT_CODE_NOT_UNIQUE.equals(studentService.checkStudentCodeUnique(student)))
        {
            return error("新增学生'" + student.getStudentId() + "'失败，该学号已存在");
        }
        student.setStudentFaculty(facultyService.selectFacultyByid(student.getStudentFaculty()));
        student.setStudentProfession(professionService.selectProfessionByid(student.getStudentProfession()));
        student.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(studentService.insertStudent(student));
    }

    @Log(title = "学生信息管理", businessType = BusinessType.EXPORT)
//    @RequiresPermissions("student:studentInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MisStudent student)
    {
        List<MisStudent> list = studentService.selectStudentList(student);
        ExcelUtil<MisStudent> util = new ExcelUtil<>(MisStudent.class);
        return util.exportExcel(list, "学生数据");
    }

    //下载导入模板
//    @RequiresPermissions("student:studentInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<MisStudent> util = new ExcelUtil<MisStudent>(MisStudent.class);
        return util.importTemplateExcel("学生数据");
    }

    //导入学生信息
    @Log(title = "学生信息管理", businessType = BusinessType.IMPORT)
//    @RequiresPermissions("student:studentInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<MisStudent> util = new ExcelUtil<MisStudent>(MisStudent.class);
        List<MisStudent> studentList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = studentService.importStudent(studentList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 修改学生信息
     */
    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") long studentId, ModelMap mmap) {
        mmap.put("student", studentService.selectStudentById(studentId));
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息
     */
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MisStudent student) {
        student.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(studentService.updateStudent(student));
    }

}
