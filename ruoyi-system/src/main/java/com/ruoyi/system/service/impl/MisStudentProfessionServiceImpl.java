package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.MisFaculty;
import com.ruoyi.system.domain.MisProfession;
import com.ruoyi.system.mapper.MisStudentFacultyMapper;
import com.ruoyi.system.mapper.MisStudentMapper;
import com.ruoyi.system.mapper.MisStudentProfessionMapper;
import com.ruoyi.system.service.MisStudentFacultyService;
import com.ruoyi.system.service.MisStudentProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专业信息 服务层处理
 * 
 * @author dg
 */
@Service
public class MisStudentProfessionServiceImpl implements MisStudentProfessionService
{
    @Autowired
    private MisStudentProfessionMapper professionMapper;


    @Override
    public List<MisProfession> selectProfessionList(String facultyId) {
        return professionMapper.selectProfessionList(facultyId);
    }

    @Override
    public String selectProfessionByid(String ProfessionId) {
        return professionMapper.selectProfessionById(ProfessionId);
    }
}
