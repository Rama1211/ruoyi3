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
    public List<MisFloor> selectFloorByCampusId(String campusId,String floorId) {
        return floorMapper.selectFloorByCampusId(campusId,floorId);
    }

    @Override
    public MisFloor selectFloorByFloorName(String campusId, String floorName) {
        return floorMapper.selectFloorByFloorName(campusId,floorName);
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
    public int insertFloor(MisFloor floor,String flag) {
        if (flag.equals("true")){
            floorMapper.addOne(floorMapper.selectFloorByCampus(floor.getCampusId()),floor.getCampusId(),floor.getUpdateBy());
        }
        return floorMapper.insertFloor(floor);
    }

    @Override
    public MisFloor selectFloorById(String floorId) {
        return floorMapper.selectFloorById(floorId);
    }

    @Override
    public int updateFloor(MisFloor floor) {
        return floorMapper.updateFloor(floor);
    }

    @Override
    public int deleteFloor(String floorId,String loginName) {
        int campusId=floorMapper.selectCampusIdByFloorId(floorId);
        floorMapper.reduceOne(floorMapper.selectFloorByCampus(String.valueOf(campusId)),String.valueOf(campusId),loginName);
        return floorMapper.deleteFloor(floorId);
    }

    @Override
    public int deleteFloorBycampuse(String campusId) {
        return floorMapper.deleteFloorBycampuse(campusId);
    }
}
