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
     * 宿舍号
     */
    @Excel(name = "宿舍号", cellType = ColumnType.NUMERIC)
    private String dormNum;

    /**
     * 宿舍类型（男女）
     */
    @Excel(name = "宿舍类型（男女）", cellType = ColumnType.STRING)
    private String dormType;

    /**
     * 宿舍应住人数
     */
    @Excel(name = "宿舍应住人数", cellType = ColumnType.STRING)
    private String dormShouldPeople;

    /**
     * 宿舍实住人数
     */
    @Excel(name = "宿舍实住人数", cellType = ColumnType.STRING)
    private String dormActualPeople;

    /**
     * 所在楼栋id
     */
    @Excel(name = "所在楼栋id", cellType = ColumnType.STRING)
    private String floorId;

    @Override
    public String toString() {
        return "MisRoom{" +
                "dormNum='" + dormNum + '\'' +
                ", dormType='" + dormType + '\'' +
                ", dormShouldPeople='" + dormShouldPeople + '\'' +
                ", dormActualPeople='" + dormActualPeople + '\'' +
                ", floorId='" + floorId + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getDormShouldPeople() {
        return dormShouldPeople;
    }

    public void setDormShouldPeople(String dormShouldPeople) {
        this.dormShouldPeople = dormShouldPeople;
    }

    public String getDormActualPeople() {
        return dormActualPeople;
    }

    public void setDormActualPeople(String dormActualPeople) {
        this.dormActualPeople = dormActualPeople;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }
}
