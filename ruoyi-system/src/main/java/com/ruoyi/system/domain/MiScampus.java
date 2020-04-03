package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 校区信息表
 * 
 * @author dg
 */
public class MiScampus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 校区编号 */
    @Excel(name = "校区编号", cellType = ColumnType.NUMERIC)
    private String campusId;

    /** 校区名称 */
    @Excel(name = "校区名称",cellType = ColumnType.STRING)
    private String campusName;

    /** 校区楼栋数 */
    @Excel(name = "校区楼栋数",cellType = ColumnType.STRING)
    private String floorNum;

    private long nextid;

    public long getNextid() {
        return nextid;
    }

    public void setNextid(long nextid) {
        this.nextid = nextid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCampusId() {
        return campusId;
    }

    public void setCampusId(String campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }
}
