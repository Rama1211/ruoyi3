package com.ruoyi.system.service.impl.baseInfo;

import com.ruoyi.system.domain.MisRelationship;
import com.ruoyi.system.domain.MisVisitor;
import com.ruoyi.system.mapper.baseInfo.MisRelationshipMapper;
import com.ruoyi.system.mapper.baseInfo.MisVisitorMapper;
import com.ruoyi.system.service.DailyOperation.MisRelationshipService;
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
public class MisRelationshipServiceImpl implements MisRelationshipService
{

    @Autowired
    private MisRelationshipMapper relationshipMapper;

    @Override
    public List<MisRelationship> selectRelationshipList() {
        return relationshipMapper.selectRelationshipList();
    }
}
