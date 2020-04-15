package com.ruoyi.system.mapper.DormRoomMapper;

import com.ruoyi.system.domain.DimProperty;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisProperty;
import com.ruoyi.system.domain.MisRoom;
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

    /**
     * 删除财物信息
     *
     * @param ids 财物id
     * @return 结果
     */
    public int deletePropertyByIds(String ids);

    /**
     * 查询财物字典信息集合
     *
     * @return 财物字典信息集合
     */
    public List<DimProperty> selectDimPropertyAll();

    /**
     * 新增财物信息
     *
     * @param property 财物信息
     * @return 结果
     */
    public int insertProperty(MisProperty property);
}
