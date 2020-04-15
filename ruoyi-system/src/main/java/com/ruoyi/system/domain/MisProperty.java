package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 财产信息表
 * 
 * @author dg
 */
public class MisProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 财物id */
    @Excel(name = "财物id", cellType = ColumnType.NUMERIC)
    private Long propertyId;

    /** 对应宿舍id */
    @Excel(name = "对应宿舍id", cellType = ColumnType.NUMERIC)
    private Long dormRoomId;

    /** 物品名称 */
    @Excel(name = "物品名称",cellType = ColumnType.STRING)
    private String propertyName;

    /** 物品编号 */
    @Excel(name = "物品编号",cellType = ColumnType.STRING)
    private String propertyNum;

    /** 物品数量 */
    @Excel(name = "物品数量",cellType = ColumnType.NUMERIC)
    private String propertyAmount;

    /** 状态 */
    @Excel(name = "状态",cellType = ColumnType.STRING)
    private String propertyStatus;

    public Long getDormRoomId() {
        return dormRoomId;
    }

    public void setDormRoomId(Long dormRoomId) {
        this.dormRoomId = dormRoomId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyNum() {
        return propertyNum;
    }

    public void setPropertyNum(String propertyNum) {
        this.propertyNum = propertyNum;
    }

    public String getPropertyAmount() {
        return propertyAmount;
    }

    public void setPropertyAmount(String propertyAmount) {
        this.propertyAmount = propertyAmount;
    }

    public String getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }
}
