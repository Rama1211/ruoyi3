package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 访客信息表
 *
 * @author dg
 */
public class MisVisitor extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Excel(name = "ID", cellType = ColumnType.NUMERIC)
    private Integer visitorId;


    /**
     * 受访学生姓名
     */
    @Excel(name = "受访学生姓名", cellType = ColumnType.STRING)
    private String studentName;

    /**
     * 受访学生学号
     */
    @Excel(name = "受访学生学号", cellType = ColumnType.STRING)
    private String studentNum;
    /**
     * 所在校区名称
     */
    @Excel(name = "所在校区名称", cellType = ColumnType.NUMERIC)
    private String campusName;

    /**
     * 所在楼栋名称
     */
    @Excel(name = "所在楼栋名称", cellType = ColumnType.NUMERIC)
    private String floorName;

    /**
     * 所在宿舍号
     */
    @Excel(name = "所在宿舍号", cellType = ColumnType.NUMERIC)
    private Integer roomNum;


    /**
     * 访客姓名
     */
    @Excel(name = "访客姓名", cellType = ColumnType.STRING)
    private String visitorNmae;

    /**
     * 访客关系
     */
    @Excel(name = "访客关系", cellType = ColumnType.STRING)
    private String relationship;

    /**
     * 来访日期
     */
    @Excel(name = "来访日期", cellType = ColumnType.STRING)
    private String visitorTime;

    /**
     * 手机号
     */
    @Excel(name = "手机号", cellType = ColumnType.STRING)
    private String phone;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorNmae() {
        return visitorNmae;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public void setVisitorNmae(String visitorNmae) {
        this.visitorNmae = visitorNmae;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getVisitorTime() {
        return visitorTime;
    }

    public void setVisitorTime(String visitorTime) {
        this.visitorTime = visitorTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
