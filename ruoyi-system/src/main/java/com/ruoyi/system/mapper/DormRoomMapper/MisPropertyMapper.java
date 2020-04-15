package com.ruoyi.system.mapper.DormRoomMapper;

import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisProperty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 财物信 数据层
 * 
 * @author dg
 */
@Repository
public interface MisPropertyMapper
{
    /**
     * 查询财物信息集合
     *
     * @return 财物数据集合
     */
    public List<MisProperty> selectPropertyList(@Param("dormId")String dormId, @Param("propertyName")String propertyName);

    /**
     * 根据财物id查询财物信息
     *
     * @return 财物数据
     */
    public MisProperty selectPropertyById(String propertyId);


    /**
     * 修改财物信息
     *
     * @param property 财物信息
     * @return 结果
     */
    public int updateProperty(MisProperty property);
}
