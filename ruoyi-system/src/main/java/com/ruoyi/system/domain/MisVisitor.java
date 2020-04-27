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
    private Integer Id;

    /**
     * 访客姓名
     */
    @Excel(name = "访客姓名", cellType = ColumnType.STRING)
    private String visitorNmae;

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
     * 所在校区id
     */
    @Excel(name = "所在校区id", cellType = ColumnType.NUMERIC)
    private Integer campusId;

    /**
     * 所在楼栋id
     */
    @Excel(name = "所在楼栋id", cellType = ColumnType.NUMERIC)
    private Integer floorId;

    /**
     * 所在宿舍号
     */
    @Excel(name = "所在宿舍号", cellType = ColumnType.NUMERIC)
    private Integer roomId;
    /**
     * 访客关系
     */
    @Excel(name = "访客关系", cellType = ColumnType.STRING)
    private String relationship;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getVisitorNmae() {
        return visitorNmae;
    }

    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
}
