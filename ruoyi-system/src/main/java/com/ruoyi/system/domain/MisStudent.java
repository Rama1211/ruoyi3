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
    @Excel(name = "学号", cellType = ColumnType.STRING)
    private Long studentId;

    /** 姓名 */
    @Excel(name = "姓名",cellType = ColumnType.STRING)
    private String studentName;

    /** 院系 */
    @Excel(name = "院系",cellType = ColumnType.STRING)
    private String studentFaculty;

    /** 专业 */
    @Excel(name = "专业", cellType = ColumnType.STRING)
    private String studentProfession;

    /**班级 */
    @Excel(name = "班级",  cellType = ColumnType.STRING)
    private String studentClass;

    /**宿舍号 */
    @Excel(name = "宿舍号",  cellType = ColumnType.STRING,type = Excel.Type.EXPORT)
    private String apartmentId;

    /**入学年份 */
    @Excel(name = "入学年份",  cellType = ColumnType.STRING)
    private String studentYear;

    /**入住日期 */
    @Excel(name = "入住日期",  cellType = ColumnType.STRING)
    private String time;


    /**性别 */
    @Excel(name = "性别",  cellType = ColumnType.STRING)
    private String gender;

    /**家庭住址*/
    @Excel(name = "家庭住址",  cellType = ColumnType.STRING)
    private String address;

    /**楼栋号 */
    @Excel(name = "楼栋号",  cellType = ColumnType.STRING,type = Excel.Type.EXPORT)
    private String floorId;

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
                ", address='" + address + '\'' +
                ", floorId='" + floorId + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }
}
