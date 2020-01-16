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



}
