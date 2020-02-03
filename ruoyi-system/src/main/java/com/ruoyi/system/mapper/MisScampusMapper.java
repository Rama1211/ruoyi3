package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.SysPost;
import org.springframework.stereotype.Repository;
import com.ruoyi.system.domain.MiScampus;

import java.util.List;

/**
 * 学生信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisScampusMapper
{
    /**
     * 查询校区信息集合
     * 
     * @param scampus 校区信息
     * @return 校区数据集合
     */
    public List<MiScampus> selectScampusList(MiScampus scampus);

    /**
     * 根据校区id查询校区信息
     *
     * @param campusId 校区id
     * @return 校区数据
     */
    public MiScampus selectScampusById(Long campusId);

    /**
     * 修改校区信息
     *
     * @param scampus 校区信息
     * @return 结果
     */
    public int updateScampus(MiScampus scampus);

    /**
     * 校验校区名称唯一
     *
     * @param campusName 校区名称
     * @return 结果
     */
    public MiScampus checkCampusNameUnique(String campusName);

    /**
     * 新增校区信息
     *
     * @param scampus 校区信息
     * @return 结果
     */
    public int insertCampus(MiScampus scampus);

    /**
     * 删除校区信息
     *
     * @param campusId 校区id
     * @return 结果
     */
    public int deleteCampus(String campusId);

}
