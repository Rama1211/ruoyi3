package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.MisFaculty;
import com.ruoyi.system.mapper.MisStudentFacultyMapper;
import com.ruoyi.system.service.MisStudentFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 院系信息 服务层处理
 * 
 * @author dg
 */
@Service
public class MisStudentFacultyServiceImpl implements MisStudentFacultyService
{
    @Autowired
    private MisStudentFacultyMapper studentFacultyMapper;


    @Override
    public List<MisFaculty> selectFacultyList() {
        return studentFacultyMapper.selectFacultyList();
    }

    @Override
    public String selectFacultyByid(String FacultyId) {
        return studentFacultyMapper.selectFacultyByid(FacultyId);
    }
}
