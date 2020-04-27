package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 *
 * @author dg
 */
public class MisAccommodation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id", cellType = ColumnType.NUMERIC)
    private Long id;

    /** 对应宿舍id */
    @Excel(name = "对应宿舍id", cellType = ColumnType.NUMERIC)
    private Long roomId;

    /** 对应学生学号 */
    @Excel(name = "对应学生学号", cellType = ColumnType.NUMERIC)
    private Long studentNum;

    /** 入住时间 */
    @Excel(name = "入住时间", cellType = ColumnType.NUMERIC)
    private Date checkInTime;

    /** 退宿时间 */
    @Excel(name = "退宿时间", cellType = ColumnType.NUMERIC)
    private Date checkoutTime;

    /** 是否入住 */
    @Excel(name = "是否入住",cellType = ColumnType.NUMERIC)
    private String checkInStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Long studentNum) {
        this.studentNum = studentNum;
    }

    public String getCheckInStatus() {
        return checkInStatus;
    }

    public void setCheckInStatus(String checkInStatus) {
        this.checkInStatus = checkInStatus;
    }
}
