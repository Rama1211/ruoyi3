package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 访客信息表
 *
 * @author dg
 */
public class MisDiscipline extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Excel(name = "ID", cellType = ColumnType.NUMERIC)
    private Integer disciplineId;


    /**
     * 违纪学生姓名
     */
    @Excel(name = "违纪学生姓名", cellType = ColumnType.STRING)
    private String disciplineStudentName;

    /**
     * 违纪学生学号
     */
    @Excel(name = "违纪学生学号", cellType = ColumnType.STRING)
    private String disciplineStudentNum;
    /**
     * 所在校区名称
     */
    @Excel(name = "所在校区名称", cellType = ColumnType.STRING)
    private String disciplineCampus;

    /**
     * 所在楼栋名称
     */
    @Excel(name = "所在楼栋名称", cellType = ColumnType.STRING)
    private String disciplineFloor;

    /**
     * 所在宿舍号
     */
    @Excel(name = "所在宿舍号", cellType = ColumnType.STRING)
    private String disciplineDorm;


    /**
     * 违纪日期
     */
    @Excel(name = "违纪日期", cellType = ColumnType.STRING)
    private Date disciplineTime;

    /**
     * 违纪类型
     */
    @Excel(name = "违纪类型", cellType = ColumnType.STRING)
    private String disciplineType;

    /**
     * 违纪原因
     */
    @Excel(name = "违纪原因", cellType = ColumnType.STRING)
    private String disciplineReason;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getDisciplineStudentName() {
        return disciplineStudentName;
    }

    public void setDisciplineStudentName(String disciplineStudentName) {
        this.disciplineStudentName = disciplineStudentName;
    }

    public String getDisciplineStudentNum() {
        return disciplineStudentNum;
    }

    public void setDisciplineStudentNum(String disciplineStudentNum) {
        this.disciplineStudentNum = disciplineStudentNum;
    }

    public String getDisciplineCampus() {
        return disciplineCampus;
    }

    public void setDisciplineCampus(String disciplineCampus) {
        this.disciplineCampus = disciplineCampus;
    }

    public String getDisciplineFloor() {
        return disciplineFloor;
    }

    public void setDisciplineFloor(String disciplineFloor) {
        this.disciplineFloor = disciplineFloor;
    }

    public String getDisciplineDorm() {
        return disciplineDorm;
    }

    public void setDisciplineDorm(String disciplineDorm) {
        this.disciplineDorm = disciplineDorm;
    }

    public Date getDisciplineTime() {
        return disciplineTime;
    }

    public void setDisciplineTime(Date disciplineTime) {
        this.disciplineTime = disciplineTime;
    }

    public String getDisciplineType() {
        return disciplineType;
    }

    public void setDisciplineType(String disciplineType) {
        this.disciplineType = disciplineType;
    }

    public String getDisciplineReason() {
        return disciplineReason;
    }

    public void setDisciplineReason(String disciplineReason) {
        this.disciplineReason = disciplineReason;
    }
}
