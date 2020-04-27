package com.ruoyi.system.service.impl.baseInfo.student;

import com.ruoyi.system.domain.MisProfession;
import com.ruoyi.system.mapper.baseInfo.student.MisStudentProfessionMapper;
import com.ruoyi.system.service.baseInfo.student.MisStudentProfessionService;
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
