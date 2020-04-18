package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 批量添加财物模板 room
 *
 * @author dg
 */
public class MisPropertyTemplate extends BaseEntity {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @Excel(name = "id", cellType = ColumnType.NUMERIC)
    private Integer id;

    /**
     * 模板名称
     */
    @Excel(name = "模板名称", cellType = ColumnType.STRING)
    private String templateName;

    /**
     * 物品名称
     */
    @Excel(name = "物品名称", cellType = ColumnType.STRING)
    private String proName;

    /**
     * 物品数量
     */
    @Excel(name = "物品数量", cellType = ColumnType.STRING)
    private String proNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProNum() {
        return proNum;
    }

    public void setProNum(String proNum) {
        this.proNum = proNum;
    }
}
