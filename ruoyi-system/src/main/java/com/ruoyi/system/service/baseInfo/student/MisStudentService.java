package com.ruoyi.system.service.baseInfo.student;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.SysUser;

import java.util.List;

/**
 * 学生信息 服务层
 * 
 * @author dg
 */
public interface MisStudentService
{
    /**
     * 查询学生信息集合
     * 
     * @param student 学生信息
     * @return 学生信息息集合
     */
    public List<MisStudent> selectStudentList(MisStudent student);

    /**
     * 通过学号查询学生信息
     *
     * @return 学生信息息集合
     */
    public MisStudent selectStudentById(Long studentId);


    /**
     * 宿舍分配模块查询学生信息集合
     *
     * @param student 学生信息
     * @return 学生信息息集合
     */
    public List<MisStudent> selectStudentListOnDistributionInfo(MisStudent student);



    /**
     * 新生入住查询学生信息集合
     *
     * @param student 学生信息
     * @return 学生信息息集合
     */
    public List<MisStudent> selectStudentListOnCheck(MisStudent student);

    /**
     * 老生退宿查询学生信息集合
     *
     * @param student 学生信息
     * @return 学生信息息集合
     */
    public List<MisStudent> selectStudentListOnCheckOut(MisStudent student);


        /**
     * 校验学生学号是否唯一
     *
     *
     * @param student 学生信息
     * @return 结果
     */
    public String checkStudentCodeUnique(MisStudent student);



        /**
     * 新增保存学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    public int insertStudent(MisStudent student);


    /**
     * 导入学生数据
     *
     * @param studentList 学生数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importStudent(List<MisStudent> studentList, Boolean isUpdateSupport, String operName);


    /**
     * 更新学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    public int updateStudent(MisStudent student);

    /**
     * 分配宿舍后更新学生信息
     *
     * @return 结果
     */
    public int updateApartment(Long stuId,String dormNum,String floorName,String campusName,String updateBy);

}
