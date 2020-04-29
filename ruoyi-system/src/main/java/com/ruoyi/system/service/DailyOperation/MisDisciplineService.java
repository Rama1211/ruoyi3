package com.ruoyi.system.service.DailyOperation;

import com.ruoyi.system.domain.MisDiscipline;
import com.ruoyi.system.domain.MisVisitor;

import java.util.List;

/**
 * 违纪信息 服务层
 */
public interface MisDisciplineService
{
    /**
     * 查询违纪信息集合
     *
     * @return 访客信息集合
     */
    public List<MisDiscipline> selectDisciplineList(MisDiscipline discipline);



}
