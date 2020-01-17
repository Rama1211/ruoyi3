package com.ruoyi.system.service;

import com.ruoyi.system.domain.MisFaculty;
import com.ruoyi.system.domain.MisStudent;

import java.util.List;

/**
 * 院系信息查询
 * 
 * @author dg
 */
public interface MisStudentFacultyService
{
    /**
     * 查询院系信息集合
     * 
     * @return 院系信息集合
     */
    public List<MisFaculty> selectFacultyList();

    /**
     * 根据id查询院系名称集合
     */
    public String selectFacultyByid(String FacultyId);



}
