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
    public List<MisDiscipline> selectDisciplineList(MisDiscipline discipline) {
        return disciplineMapper.selectDisciplineList(discipline);
    }
}
