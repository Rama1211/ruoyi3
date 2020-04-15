package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 财产字典表
 * 
 * @author dg
 */
public class DimProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 财物id */
    @Excel(name = "财物id", cellType = ColumnType.NUMERIC)
    private Long dimpropertyId;

    /** 物品名称 */
    @Excel(name = "物品名称",cellType = ColumnType.STRING)
    private String dimProName;

    /** 物品编号 */
    @Excel(name = "物品编号",cellType = ColumnType.STRING)
    private String dimProNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Long getDimpropertyId() {
        return dimpropertyId;
    }

    public void setDimpropertyId(Long dimpropertyId) {
        this.dimpropertyId = dimpropertyId;
    }

    public String getDimProName() {
        return dimProName;
    }

    public void setDimProName(String dimProName) {
        this.dimProName = dimProName;
    }

    public String getDimProNum() {
        return dimProNum;
    }

    public void setDimProNum(String dimProNum) {
        this.dimProNum = dimProNum;
    }
}
