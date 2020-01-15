package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 学生信息表 student
 * 
 * @author dg
 */
public class MisStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号 */
    @Excel(name = "学号", cellType = ColumnType.NUMERIC)
    private Long studentId;

    /** 姓名 */
    @Excel(name = "姓名",cellType = ColumnType.NUMERIC)
    private String studentName;

    /** 院系 */
    @Excel(name = "院系",cellType = ColumnType.NUMERIC)
    private String studentFaculty;

    /** 专业 */
    @Excel(name = "专业", cellType = ColumnType.NUMERIC)
    private String studentProfession;

    /**班级 */
    @Excel(name = "班级",  cellType = ColumnType.NUMERIC)
    private String studentClass;

    /**宿舍号 */
    @Excel(name = "宿舍号",  cellType = ColumnType.NUMERIC)
    private String apartmentId;

    /**入学年份 */
    @Excel(name = "入学年份",  cellType = ColumnType.NUMERIC)
    private String studentYear;

    @Override
    public String toString() {
        return "MisStudent{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentFaculty='" + studentFaculty + '\'' +
                ", studentProfession='" + studentProfession + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", apartmentId='" + apartmentId + '\'' +
                ", studentYear='" + studentYear + '\'' +
                ", time='" + time + '\'' +
                ", gender='" + gender + '\'' +
                ", floorId='" + floorId + '\'' +
                '}';
    }

    /**入住时间 */
    @Excel(name = "入住时间",  cellType = ColumnType.NUMERIC)
    private String time;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    public void setStudentFaculty(String studentFaculty) {
        this.studentFaculty = studentFaculty;
    }

    public String getStudentProfession() {
        return studentProfession;
    }

    public void setStudentProfession(String studentProfession) {
        this.studentProfession = studentProfession;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    /**性别 */
    @Excel(name = "性别",  cellType = ColumnType.NUMERIC)
    private String gender;

    /**楼栋号 */
    @Excel(name = "楼栋号",  cellType = ColumnType.NUMERIC)
    private String floorId;
}
