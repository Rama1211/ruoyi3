package com.ruoyi.system.service.impl.baseInfo.student;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.mapper.baseInfo.student.MisStudentMapper;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生信息 服务层处理
 * 
 * @author dg
 */
@Service
public class MisStudentServiceImpl implements MisStudentService
{
    private static final Logger log = LoggerFactory.getLogger(MisStudentServiceImpl.class);
    @Autowired
    private MisStudentMapper studentMapper;

    /**
     * 查询学生信息集合
     * 
     * @param student 学生信息
     * @return 学生信息集合
     */
    @Override
    public List<MisStudent> selectStudentList(MisStudent student)
    {

        return studentMapper.selectStudentList(student);
    }

    @Override
    public MisStudent selectStudentById(Long studentId) {
        return studentMapper.selectStudentById(studentId);
    }

    /**
     *  宿舍分配模块查询学生信息集合
     *
     * @param student 学生信息
     * @return 学生信息集合
     */
    @Override
    public List<MisStudent> selectStudentListOnDistributionInfo(MisStudent student)
    {

        return studentMapper.selectStudentListOnDistributionInfo(student);
    }

    @Override
    public List<MisStudent> selectStudentListOnCheck(MisStudent student) {
        return studentMapper.selectStudentListOnCheck(student);
    }

    @Override
    public List<MisStudent> selectStudentListOnCheckOut(MisStudent student) {
        return studentMapper.selectStudentListOnCheckOut(student);
    }


    /**
     * 校验学号是否唯一
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public String checkStudentCodeUnique(MisStudent student)
    {
        Long StudentId = StringUtils.isNull(student.getStudentId()) ? -1L : student.getStudentId();
        MisStudent info = studentMapper.checkStudentCodeUnique(student.getStudentId().toString());
        if (StringUtils.isNotNull(info) && info.getStudentId().longValue() == StudentId.longValue())
        {
            return UserConstants.STUDENT_CODE_NOT_UNIQUE;
        }
        return UserConstants.STUDENT_CODE_UNIQUE;
    }

        /**
     * 新增保存学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    @Override
    public int insertStudent(MisStudent student)
    {
        return studentMapper.insertStudent(student);
    }


    @Override
    public String importStudent(List<MisStudent> studentList, Boolean isUpdateSupport, String operName) {
        if (StringUtils.isNull(studentList) || studentList.size() == 0)
        {
            throw new BusinessException("导入学生数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MisStudent student : studentList)
        {
            try
            {
                // 验证是否存在这个用户
                MisStudent stu= studentMapper.checkStudentCodeUnique(student.getStudentId().toString());
                if (StringUtils.isNull(stu))
                {
                    student.setCreateBy(operName);
                    this.insertStudent(student);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + student.getStudentName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    stu.setUpdateBy(operName);
                    this.updateStudent(student);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + student.getStudentName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + student.getStudentName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + student.getStudentName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public int updateStudent(MisStudent student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int updateApartment(Long stuId,String dormNum, String floorName, String campusName,String updateBy) {
       return studentMapper.updateApartment(stuId,dormNum,floorName,campusName,updateBy);
    }

}
