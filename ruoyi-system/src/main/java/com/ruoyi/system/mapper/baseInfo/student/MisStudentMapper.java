package com.ruoyi.system.mapper.baseInfo.student;

import com.ruoyi.system.domain.MisStudent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisStudentMapper
{
    /**
     * 查询学生信息集合
     * 
     * @param student 学生信息
     * @return 学生数据集合
     */
    public List<MisStudent> selectStudentList(MisStudent student);

    /**
     *  宿舍分配模块查询学生信息集合
     *
     * @param student 学生信息
     * @return 学生数据集合
     */
    public List<MisStudent> selectStudentListOnDistributionInfo(MisStudent student);

        /**
     * 校验学号唯一
     *
     * @param studentId 学号
     * @return 结果
     */
    public MisStudent checkStudentCodeUnique(String studentId);


        /**
     * 新增学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    public int insertStudent(MisStudent student);

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    public int updateStudent(MisStudent student);

    /**
     * 通过学号查询学生信息
     *
     * @return 学生信息息集合
     */
    public MisStudent selectStudentById(Long studentId);

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
     * 分配宿舍后更新学生信息
     *
     * @return 结果
     */
    public int updateApartment(@Param("stuId") Long stuId,@Param("dormNum") String dormNum,@Param("floorName") String floorName,@Param("campusName") String campusName,@Param("updateBy") String updateBy);
}
