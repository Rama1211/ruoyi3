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

    /** 对应校区id */
    @Excel(name = "校区id",cellType = ColumnType.STRING)
    private String canpusId;

    @Override
    public String toString() {
        return "MiFloor{" +
                "floorId='" + floorId + '\'' +
                ", floorName='" + floorName + '\'' +
                ", canpusId='" + canpusId + '\'' +
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

    public String getCanpusId() {
        return canpusId;
    }

    public void setCanpusId(String canpusId) {
        this.canpusId = canpusId;
    }
}
