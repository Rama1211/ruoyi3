package com.ruoyi.system.service.DormRoomService;

import com.ruoyi.system.domain.MisProperty;
import org.yaml.snakeyaml.introspector.MissingProperty;

import java.util.List;

/**
 * 财物信息 服务层
 * 
 * @author dg
 */
public interface MisPeropertyService
{
    /**
     * 查询财物信息集合
     * 
     * @return 财物信息集合
     */
    public List<MisProperty> selectPropertyList(MisProperty property);

}
