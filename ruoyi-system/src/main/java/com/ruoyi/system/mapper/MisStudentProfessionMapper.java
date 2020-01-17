package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.MisFaculty;
import com.ruoyi.system.domain.MisProfession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 院系信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisStudentProfessionMapper
{
    /**
     * 查询院系信息集合
     * 
     * @return 院系数据集合
     */
    public List<MisProfession> selectProfessionList(String facultyId);


    /**
     * 根据id查询专业名称
     */
    public String selectProfessionById(String ProfessionId);
}
