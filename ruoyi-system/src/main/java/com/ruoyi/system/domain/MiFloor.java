package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息表 student
 * 
 * @author dg
 */
public class MiFloor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 楼栋编号 */
    @Excel(name = "楼栋编号", cellType = ColumnType.NUMERIC)
    private String floorId;

    /** 楼栋编号 */
    @Excel(name = "楼栋编号",cellType = ColumnType.STRING)
    private String floorName;

    @Override
    public String toString() {
        return "MiFloor{" +
                "floorId='" + floorId + '\'' +
                ", floorName='" + floorName + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
}
