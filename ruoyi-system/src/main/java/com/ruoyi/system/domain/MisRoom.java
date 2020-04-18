package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间信息表 room
 *
 * @author dg
 */
public class MisRoom extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 宿舍ID
     */
    @Excel(name = "宿舍ID", cellType = ColumnType.NUMERIC)
    private Integer dormId;

    /**
     * 宿舍号
     */
    @Excel(name = "宿舍号", cellType = ColumnType.STRING)
    private String dormNum;

    /**
     * 宿舍类型（男女）
     */
    @Excel(name = "宿舍类型（男女）", cellType = ColumnType.STRING)
    private String dormType;

    /**
     * 宿舍应住人数
     */
    @Excel(name = "宿舍应住人数", cellType = ColumnType.NUMERIC)
    private Integer dormShouldPeople;

    /**
     * 宿舍实住人数
     */
    @Excel(name = "宿舍实住人数", cellType = ColumnType.NUMERIC)
    private Integer dormActualPeople;

    /**
     * 所在楼层
     */
    @Excel(name = "所在楼层", cellType = ColumnType.NUMERIC)
    private Integer floorLevel;

    /**
     * 所在校区id
     */
    @Excel(name = "所在校区id", cellType = ColumnType.NUMERIC)
    private Integer campusId;

    /**
     * 所在校区id
     */
    @Excel(name = "所在校区id", cellType = ColumnType.NUMERIC)
    private Integer floorId;

    /**
     * 状态
     */
    @Excel(name = "状态", cellType = ColumnType.STRING)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFloorLevel() {
        return floorLevel;
    }

    public void setFloorLevel(Integer floorLevel) {
        this.floorLevel = floorLevel;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum;
    }

    public String getDormType() {
        return dormType;
    }

    public void setDormType(String dormType) {
        this.dormType = dormType;
    }

    public Integer getDormShouldPeople() {
        return dormShouldPeople;
    }

    public void setDormShouldPeople(Integer dormShouldPeople) {
        this.dormShouldPeople = dormShouldPeople;
    }

    public Integer getDormActualPeople() {
        return dormActualPeople;
    }

    public void setDormActualPeople(Integer dormActualPeople) {
        this.dormActualPeople = dormActualPeople;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }
}
