package com.ruoyi.system.service.DormRoomService;

import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisFloor;

import java.util.List;

/**
 * 公寓信息 服务层
 * 
 * @author dg
 */
public interface MisFloorService
{
    /**
     * 通过校区ID查询楼栋信息
     *
     * @param campusId 校区ID
     * @return 楼栋信息
     */
    public List<MisFloor> selectFloorByCampusId(String campusId,String floorId);

    /**
     * 校验楼栋名称是否唯一
     *
     *
     * @param floor 楼栋信息
     * @return 结果
     */
    public String checkFloorNameUnique(MisFloor floor);


    /**
     * 新增保存楼栋信息
     *
     * @param floor 楼栋信息
     * @return 结果
     */
    public int insertFloor(MisFloor floor);


    /**
     * 通过ID查询楼栋详细信息
     *     * @return 校区信息
     */
    public MisFloor selectFloorById(String floorId);

    /**
     * 修改保存楼栋信息
     *
     * @param floor 楼栋信息
     * @return 结果
     */
    public int updateFloor(MisFloor floor);

    /**
     * 删除楼栋信息
     *
     * @param floorId 楼栋
     * @return 结果
     */
    public int deleteFloor(String floorId,String loginName);

}
