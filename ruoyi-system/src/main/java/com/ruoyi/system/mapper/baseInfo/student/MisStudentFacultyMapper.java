package com.ruoyi.system.mapper.baseInfo.student;

import com.ruoyi.system.domain.MisFaculty;
import com.ruoyi.system.domain.MisStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 院系信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisStudentFacultyMapper
{
    /**
     * 查询院系信息集合
     * 
     * @return 院系数据集合
     */
    public List<MisFaculty> selectFacultyList();

    /**
     * 根据id查询院系名称集合
     */
    public String selectFacultyByid(String FacultyId);

}
