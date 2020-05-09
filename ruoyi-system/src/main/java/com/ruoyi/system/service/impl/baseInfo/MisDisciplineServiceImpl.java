package com.ruoyi.system.service.impl.baseInfo;

import com.ruoyi.system.domain.MisDiscipline;
import com.ruoyi.system.domain.MisVisitor;
import com.ruoyi.system.mapper.baseInfo.MisDisciplineMapper;
import com.ruoyi.system.mapper.baseInfo.MisVisitorMapper;
import com.ruoyi.system.service.DailyOperation.MisDisciplineService;
import com.ruoyi.system.service.DailyOperation.MisVusitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *访客信息 服务层处理
 * 
 * @author dg
 */
@Service
public class MisDisciplineServiceImpl implements MisDisciplineService
{
    private static final Logger log = LoggerFactory.getLogger(MisDisciplineServiceImpl.class);
    @Autowired
    private MisDisciplineMapper disciplineMapper;


    @Override
    public List<MisDiscipline> selectDisciplineList(MisDiscipline discipline,String check) {
        return disciplineMapper.selectDisciplineList(discipline,check);
    }

    @Override
    public List<MisDiscipline> selectDisciplineListByStuNum(String studentNum) {
        return disciplineMapper.selectDisciplineListByStuNum(studentNum);
    }

    @Override
    public List<String> selectDisciplineStuList(String check) {
        return disciplineMapper.selectDisciplineStuList(check);
    }

    @Override
    public MisDiscipline selectDisciplineById(String id) {
        return disciplineMapper.selectDisciplineById(id);
    }

    @Override
    public int updateDiscipline(MisDiscipline discipline) {
        return disciplineMapper.updateDiscipline(discipline);
    }

    @Override
    public int deleteDisciplineByIds(String ids) {
        return disciplineMapper.deleteDisciplineByIds(ids);
    }
}
