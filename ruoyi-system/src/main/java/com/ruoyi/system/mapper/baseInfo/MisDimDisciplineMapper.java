package com.ruoyi.system.mapper.baseInfo;

import com.ruoyi.system.domain.DimDiscipline;
import com.ruoyi.system.domain.MisVisitor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *违纪类型信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisDimDisciplineMapper
{
    /**
     * 查询违纪类型信息集合
     *
     * @return 违纪类型信息集合
     */
    public List<DimDiscipline> selectDimDisciplineList();

}
