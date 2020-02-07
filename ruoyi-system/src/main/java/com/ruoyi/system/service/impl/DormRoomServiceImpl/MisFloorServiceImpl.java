package com.ruoyi.system.service.impl.DormRoomServiceImpl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.mapper.DormRoomMapper.MisFloorMapper;
import com.ruoyi.system.mapper.DormRoomMapper.MisScampusMapper;
import com.ruoyi.system.service.DormRoomService.MisFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公寓信息 服务层处理
 * 
 * @author dg
 */
@Service
public class MisFloorServiceImpl implements MisFloorService
{
    @Autowired
    private MisFloorMapper floorMapper;


    @Override
    public List<MisFloor> selectFloorByCampusId(Long campusId,String floorId) {
        return floorMapper.selectFloorByCampusId(campusId,floorId);
    }



    @Override
    public String checkFloorNameUnique(MisFloor floor) {
        MisFloor info = floorMapper.checkFloorNameUnique(floor.getFloorName(),floor.getCampusId());
        if (StringUtils.isNotNull(info))
        {
            return UserConstants.STUDENT_CODE_NOT_UNIQUE;
        }
        return UserConstants.STUDENT_CODE_UNIQUE;
    }

    @Override
    public int insertFloor(MisFloor floor) {
        return floorMapper.insertFloor(floor);
    }
}
