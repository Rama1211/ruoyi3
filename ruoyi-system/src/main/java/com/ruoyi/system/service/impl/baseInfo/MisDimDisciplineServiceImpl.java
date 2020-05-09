package com.ruoyi.system.service.impl.baseInfo;

import com.ruoyi.system.domain.DimDiscipline;
import com.ruoyi.system.mapper.baseInfo.MisDimDisciplineMapper;
import com.ruoyi.system.service.DailyOperation.MisDimDisciplineService;
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
public class MisDimDisciplineServiceImpl implements MisDimDisciplineService
{
    private static final Logger log = LoggerFactory.getLogger(MisDimDisciplineServiceImpl.class);

    @Autowired
    private MisDimDisciplineMapper dimDisciplineMapper;


    @Override
    public List<DimDiscipline> selectDimDisciplineList() {
        return dimDisciplineMapper.selectDimDisciplineList();
    }
}
