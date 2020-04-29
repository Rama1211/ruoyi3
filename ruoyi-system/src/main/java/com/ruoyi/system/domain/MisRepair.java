package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

import java.sql.Date;


/**
 * 维修信息表 repair
 *
 * @author dg
 */
public class MisRepair extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 报修
     */
    @Excel(name = "报修", cellType = ColumnType.NUMERIC)
    private Integer repairId;

    /**
     * 宿舍号
     */
    @Excel(name = "宿舍号", cellType = ColumnType.STRING)
    private String repairDormId;

    /**
     * 报修原因及备注
     */
    @Excel(name = "报修原因及备注", cellType = ColumnType.STRING)
    private String repairRemark;

    /**
     * 报修学生姓名
     */
    @Excel(name = "报修学生姓名", cellType = ColumnType.STRING)
    private String repairStudentName;

    /**
     * 报修时间
     */
    @Excel(name = "报修时间", cellType = ColumnType.STRING)
    private Date repairDeclareTime;

    /**
     * 报修学生联系方式
     */
    @Excel(name = "报修学生联系方式", cellType = ColumnType.STRING)
    private Long repairStudentPhone;

    /**
     * 处理时间
     */
    @Excel(name = "处理时间", cellType = ColumnType.STRING)
    private Date repairCompleteTime;

    /**
     * 处理结果
     */
    @Excel(name = "处理结果", cellType = ColumnType.STRING)
    private String repairResult;


    /**
     * 0/报修未处理，1/报修已处理
     */
    @Excel(name = "0/报修未处理，1/报修已处理", cellType = ColumnType.STRING)
    private String status;

    /**
     * 所在校区
     */
    @Excel(name = "所在校区", cellType = ColumnType.STRING)
    private String repairCampus;

    /**
     * 所在楼栋
     */
    @Excel(name = "所在楼栋", cellType = ColumnType.STRING)
    private String repairFloor;

    /**
     * 学号
     */
    @Excel(name = "学号", cellType = ColumnType.STRING)
    private Long repairStudentNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getRepairDormId() {
        return repairDormId;
    }

    public void setRepairDormId(String repairDormId) {
        this.repairDormId = repairDormId;
    }

    public String getRepairRemark() {
        return repairRemark;
    }

    public void setRepairRemark(String repairRemark) {
        this.repairRemark = repairRemark;
    }

    public String getRepairStudentName() {
        return repairStudentName;
    }

    public void setRepairStudentName(String repairStudentName) {
        this.repairStudentName = repairStudentName;
    }



    public Date getRepairDeclareTime() {
        return repairDeclareTime;
    }

    public void setRepairDeclareTime(Date repairDeclareTime) {
        this.repairDeclareTime = repairDeclareTime;
    }

    public Date getRepairCompleteTime() {
        return repairCompleteTime;
    }

    public void setRepairCompleteTime(Date repairCompleteTime) {
        this.repairCompleteTime = repairCompleteTime;
    }

    public String getStatus() {
        return status;
    }

    public String getRepairCampus() {
        return repairCampus;
    }

    public void setRepairCampus(String repairCampus) {
        this.repairCampus = repairCampus;
    }

    public String getRepairFloor() {
        return repairFloor;
    }

    public void setRepairFloor(String repairFloor) {
        this.repairFloor = repairFloor;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Long getRepairStudentPhone() {
        return repairStudentPhone;
    }

    public void setRepairStudentPhone(Long repairStudentPhone) {
        this.repairStudentPhone = repairStudentPhone;
    }

    public Long getRepairStudentNum() {
        return repairStudentNum;
    }

    public void setRepairStudentNum(Long repairStudentNum) {
        this.repairStudentNum = repairStudentNum;
    }

    public String getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(String repairResult) {
        this.repairResult = repairResult;
    }
}
