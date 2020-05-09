package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Date;

/**
 * 访客信息表
 *
 * @author dg
 */
public class MisItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Excel(name = "ID", cellType = ColumnType.NUMERIC)
    private Integer itemId;


    /**
     * 物品名称
     */
    @Excel(name = "物品名称", cellType = ColumnType.STRING)
    private String itemName;

    /**
     * 物品数量
     */
    @Excel(name = "物品数量", cellType = ColumnType.NUMERIC)
    private int itemNum;

    /**
     * 物品外出时间
     */
    @Excel(name = "物品外出时间", cellType = ColumnType.STRING)
    private Date itemTime;

    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名", cellType = ColumnType.STRING)
    private String studentName;

    /**
     * 学生学号
     */
    @Excel(name = "学生学号", cellType = ColumnType.STRING)
    private String studentNum;


    /**
     * 楼栋名称
     */
    @Excel(name = "楼栋名称", cellType = ColumnType.STRING)
    private String floorName;

    /**
     * 校区名称
     */
    @Excel(name = "校区名称", cellType = ColumnType.STRING)
    private String campusName;

    /**
     * 宿舍号
     */
    @Excel(name = "宿舍号", cellType = ColumnType.STRING)
    private String roomNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public Date getItemTime() {
        return itemTime;
    }

    public void setItemTime(Date itemTime) {
        this.itemTime = itemTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}
