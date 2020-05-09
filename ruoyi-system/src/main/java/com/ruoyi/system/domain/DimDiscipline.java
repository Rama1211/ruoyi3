package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 财产字典表
 * 
 * @author dg
 */
public class DimDiscipline extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 财物id */
    @Excel(name = "财物id", cellType = ColumnType.NUMERIC)
    private Long disciplineId;

    /** 违纪类型 */
    @Excel(name = "违纪类型",cellType = ColumnType.STRING)
    private String dimDisciplineType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getDimDisciplineType() {
        return dimDisciplineType;
    }

    public void setDimDisciplineType(String dimDisciplineType) {
        this.dimDisciplineType = dimDisciplineType;
    }
}
