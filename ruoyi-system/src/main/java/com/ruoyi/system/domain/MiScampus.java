package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息表 student
 * 
 * @author dg
 */
public class MiScampus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 校区编号 */
    @Excel(name = "校区编号", cellType = ColumnType.NUMERIC)
    private String campusId;

    /** 校区名称 */
    @Excel(name = "校区名称",cellType = ColumnType.STRING)
    private String campusName;

    @Override
    public String toString() {
        return "MiScampus{" +
                "campusId='" + campusId + '\'' +
                ", campusName='" + campusName + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }
}
