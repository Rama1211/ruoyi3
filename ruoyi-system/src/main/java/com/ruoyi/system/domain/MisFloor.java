package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息表 student
 * 
 * @author dg
 */
public class MisFloor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 楼栋编号 */
    @Excel(name = "楼栋编号", cellType = ColumnType.NUMERIC)
    private String floorId;

    /** 楼栋名称 */
    @Excel(name = "楼栋名称",cellType = ColumnType.STRING)
    private String floorName;

    /** 对应校区id */
    @Excel(name = "校区id",cellType = ColumnType.STRING)
    private String campusId;

    /** 楼层数量 */
    @Excel(name = "楼层数量",cellType = ColumnType.NUMERIC)
    private String floorLevel;

    /** 每层宿舍数量 */
    @Excel(name = "每层宿舍数量",cellType = ColumnType.NUMERIC)
    private String everyLevelNum;

    /** 总宿舍数量 */
    @Excel(name = "总宿舍数量",cellType = ColumnType.NUMERIC)
    private String totalNum;

    @Override
    public String toString() {
        return "MisFloor{" +
                "floorId='" + floorId + '\'' +
                ", floorName='" + floorName + '\'' +
                ", campusId='" + campusId + '\'' +
                ", floorLevel='" + floorLevel + '\'' +
                ", everyLevelNum='" + everyLevelNum + '\'' +
                ", totalNum='" + totalNum + '\'' +
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

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public String getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(String floorLevel) {
        this.floorLevel = floorLevel;
    }

    public String getEveryLevelNum() {
        return everyLevelNum;
    }

    public void setEveryLevelNum(String everyLevelNum) {
        this.everyLevelNum = everyLevelNum;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }
}