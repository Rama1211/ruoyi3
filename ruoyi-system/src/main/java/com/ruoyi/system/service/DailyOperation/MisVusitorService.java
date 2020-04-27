package com.ruoyi.system.service.DailyOperation;

import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.domain.MisVisitor;

import java.util.List;
import java.util.Map;

/**
 * 访客信息 服务层
 */
public interface MisVusitorService
{
    /**
     * 查询访客信息集合
     *
     * @return 访客信息集合
     */
    public List<MisVisitor> selectVisitorList(MisVisitor visitor);

}
