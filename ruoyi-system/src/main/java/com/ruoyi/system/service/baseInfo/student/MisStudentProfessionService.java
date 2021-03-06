package com.ruoyi.system.service.baseInfo.student;

import com.ruoyi.system.domain.MisFaculty;
import com.ruoyi.system.domain.MisProfession;

import java.util.List;

/**
 * 专业信息查询
 * 
 * @author dg
 */
public interface MisStudentProfessionService
{
    /**
     * 查询专业信息集合
     * 
     * @return 专业信息集合
     */
    public List<MisProfession> selectProfessionList(String facultyId);

    /**
     * 根据id查询专业名称
     */
    public String selectProfessionByid(String ProfessionId);

}
