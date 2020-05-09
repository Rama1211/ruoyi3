package com.ruoyi.system.mapper.baseInfo;

import com.ruoyi.system.domain.MisDiscipline;
import com.ruoyi.system.domain.MisRelationship;
import com.ruoyi.system.domain.MisVisitor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *访客信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisDisciplineMapper
{
    /**
     * 查询违纪信息集合
     *
     * @return 访客信息集合
     */
    public List<MisDiscipline> selectDisciplineList(@Param("discipline") MisDiscipline discipline,@Param("check") String check);

    /**
     * 根据学号查询违纪集合
     *
     * @return 访客信息集合
     */
    public List<MisDiscipline> selectDisciplineListByStuNum(String studentNum);

    /**
     * 查询违纪次数大于3次的学生学号
     *
     * @return 访客信息集合
     */
    public List<String> selectDisciplineStuList(String check);


    /**
     * 通过id查询违纪信息
     *
     * @param id ID
     * @return 违纪信息
     */
    public MisDiscipline selectDisciplineById(String id);

    /**
     * 修改保存违纪信息
     *
     * @param discipline 违纪信息
     * @return 结果
     */
    public int updateDiscipline(MisDiscipline discipline);

    /**
     * 删除违纪信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDisciplineByIds(String ids);
}
