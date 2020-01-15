package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 院系表
 * 
 * @author dg
 */
public class MisFaculty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 院系编号 */
    @Excel(name = "院系编号", cellType = ColumnType.NUMERIC)
    private String facultyId;

    /** 院系名称 */
    @Excel(name = "院系名称", cellType = ColumnType.NUMERIC)
    private String facultyName;

    /** 院长 */
    @Excel(name = "院长",cellType = ColumnType.NUMERIC)
    private String facultyHead;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyHead() {
        return facultyHead;
    }

    public void setFacultyHead(String facultyHead) {
        this.facultyHead = facultyHead;
    }

    @Override
    public String toString() {
        return "MisFaculty{" +
                "facultyId='" + facultyId + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", facultyHead='" + facultyHead + '\'' +
                '}';
    }
}
