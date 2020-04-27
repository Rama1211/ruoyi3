package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 楼栋信息表 student
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

    /** 对应校区名称 */
    @Excel(name = "校区名称",cellType = ColumnType.STRING)
    private String campusName;

    /** 楼层数量 */
    @Excel(name = "楼层数量",cellType = ColumnType.NUMERIC)
    private String floorLevel;

    /** 每层宿舍数量 */
    @Excel(name = "每层宿舍数量",cellType = ColumnType.NUMERIC)
    private String everyLevelNum;

    /** 楼栋类型 */
    @Excel(name = "楼栋类型",cellType = ColumnType.STRING)
    private String floorType;

    /** 总宿舍数量 */
    @Excel(name = "总宿舍数量",cellType = ColumnType.NUMERIC)
    private String totalNum;

    /** 管理员 */
    @Excel(name = "管理员",cellType = ColumnType.STRING)
    private String manager;

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
