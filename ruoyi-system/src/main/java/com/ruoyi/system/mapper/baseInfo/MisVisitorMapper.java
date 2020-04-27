package com.ruoyi.system.mapper.baseInfo;

import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.MisVisitor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *访客信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisVisitorMapper
{
    /**
     * 查询访客信息集合
     *
     * @return 访客信息集合
     */
    public List<MisVisitor> selectVisitorList(MisVisitor visitor);

}
