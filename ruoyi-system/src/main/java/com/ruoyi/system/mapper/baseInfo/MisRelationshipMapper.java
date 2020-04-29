package com.ruoyi.system.mapper.baseInfo;

import com.ruoyi.system.domain.MisRelationship;
import com.ruoyi.system.domain.MisVisitor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *访客信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisRelationshipMapper
{
    /**
     * 查询关系信息集合
     *
     * @return 访客信息集合
     */
    public List<MisRelationship> selectRelationshipList();
}
