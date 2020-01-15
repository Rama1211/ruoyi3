package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专业表
 * @author dg
 */
public class MisProfession extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专业编号 */
    @Excel(name = "专业编号", cellType = ColumnType.NUMERIC)
    private String professionId;

    /** 专业名称 */
    @Excel(name = "专业名称", cellType = ColumnType.NUMERIC)
    private String professionName;

    /** 所属院系编号 */
    @Excel(name = "所属院系编号",cellType = ColumnType.NUMERIC)
    private String facultyId;

    @Override
    public String toString() {
        return "MisProfession{" +
                "professionId='" + professionId + '\'' +
                ", professionName='" + professionName + '\'' +
                ", facultyId='" + facultyId + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getProfessionId() {
        return professionId;
    }

    public void setProfessionId(String professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
}
