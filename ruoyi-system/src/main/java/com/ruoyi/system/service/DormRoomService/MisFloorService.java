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
    public List<MisFloor> selectFloorByCampusId(Long campusId,String floorId);

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

}
