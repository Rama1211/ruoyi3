package com.ruoyi.system.service.DailyOperation;

import com.ruoyi.system.domain.MisRelationship;
import com.ruoyi.system.domain.MisVisitor;

import java.util.List;

/**
 * 访客信息 服务层
 */
public interface MisRelationshipService
{
    /**
     * 查询关系信息集合
     *
     * @return 访客信息集合
     */
    public List<MisRelationship> selectRelationshipList();


}
