package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.MisStudentFacultyService;
import com.ruoyi.system.service.MisStudentProfessionService;
import com.ruoyi.system.service.MisStudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    private String prefix = "/student/studentInfo";

    @Autowired
    private MisStudentFacultyService facultyService;

    @Autowired
    private MisStudentProfessionService professionService;

    @Autowired
    private MisStudentService studentService;

//    @RequiresPermissions("student:studentInfo:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/index";
    }

    //查询学生列表
//    @RequiresPermissions("student:studentInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MisStudent student)
    {
        startPage();
        System.out.println(student);
        List<MisStudent> list = studentService.selectStudentList(student);
        return getDataTable(list);
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
//    @RequiresPermissions("student:studentInfo:add")
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

}
