package com.ruoyi.system.service.DormRoomService;

import com.ruoyi.system.domain.MiScampus;

import java.util.List;

/**
 * 公寓信息 服务层
 * 
 * @author dg
 */
public interface MisCampusService
{
    /**
     * 查询公寓信息集合
     * 
     * @param scampus 公寓信息
     * @return 公寓信息集合
     */
    public List<MiScampus> selectScampusList(MiScampus scampus);


    /**
     * 通过校区ID查询校区信息
     *
     * @param campusId 校区ID
     * @return 校区信息
     */
    public MiScampus selectMiScampusById(Long campusId);

    /**
     * 修改保存校区信息
     *
     * @param scampus 校区信息
     * @return 结果
     */
    public int updateScampus(MiScampus scampus);


    /**
     * 校验校区名称是否唯一
     *
     *
     * @param scampus 校区信息
     * @return 结果
     */
    public String checkCampusNameUnique(MiScampus scampus);


    /**
     * 新增保存校区信息
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
