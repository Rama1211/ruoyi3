package com.ruoyi.system.service.DailyOperation;

import com.ruoyi.system.domain.DimDiscipline;
import com.ruoyi.system.domain.DimProperty;
import com.ruoyi.system.domain.MisProperty;
import com.ruoyi.system.domain.MisPropertyTemplate;

import java.util.List;

/**
 * 违纪类型信息 服务层
 * 
 * @author dg
 */
public interface MisDimDisciplineService
{
    /**
     * 查询违纪类型信息集合
     *
     * @return 违纪类型信息集合
     */
    public List<DimDiscipline> selectDimDisciplineList();

}
