package com.ruoyi.system.service.DormRoomService;

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
     * @return 校区信息
     */
    public List<MisFloor> selectFloorByCampusId(Long campusId);

}
