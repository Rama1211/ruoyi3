package com.ruoyi.system.service.DormRoomService;

import com.ruoyi.system.domain.DimProperty;
import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisProperty;

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
    public List<MisProperty> selectPropertyList(String dormId,String propertyName);

    /**
     * 通过财物ID查询财物信息
     *
     * @param propertyId 财物ID
     * @return 财物信息
     */
    public MisProperty selectPropertyById(String propertyId);

    /**
     * 修改保存财物信息
     *
     * @param property 财物信息
     * @return 结果
     */
    public int updateProperty(MisProperty property);

    /**
     * 删除财物信息
     *
     * @param ids 财物
     * @return 结果
     */
    public int deletePropertyByIds(String ids);

    /**
     * 查询财物字典表信息集合
     *
     * @return 财物字典表信息集合
     */
    public List<DimProperty> selectDimPropertyAll();


    /**
     * 新增保存财物信息
     *
     * @param property 财物信息
     * @return 结果
     */
    public int insertProperty(MisProperty property);



}
