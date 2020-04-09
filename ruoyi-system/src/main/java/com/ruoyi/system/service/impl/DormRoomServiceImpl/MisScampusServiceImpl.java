package com.ruoyi.system.service.impl.DormRoomServiceImpl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.mapper.DormRoomMapper.MisScampusMapper;
import com.ruoyi.system.service.DormRoomService.MisCampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公寓信息 服务层处理
 * 
 * @author dg
 */
@Service
public class MisScampusServiceImpl implements MisCampusService
{
    @Autowired
    private MisScampusMapper scampusMapper;


    @Override
    public List<MiScampus> selectScampusList(MiScampus scampus) {
        return scampusMapper.selectScampusList(scampus);
    }

    @Override
    public MiScampus selectMiScampusById(Long campusId) {
        return scampusMapper.selectScampusById(campusId);
    }

    @Override
    public MiScampus selectMiScampusByName(String campusName) {
        return scampusMapper.selectMiScampusByName(campusName);
    }

    @Override
    public int updateScampus(MiScampus scampus) {
        return scampusMapper.updateScampus(scampus);
    }

    @Override
    public String checkCampusNameUnique(MiScampus scampus) {
        MiScampus info = scampusMapper.checkCampusNameUnique(scampus.getCampusName());
        if (StringUtils.isNotNull(info))
        {
            return UserConstants.STUDENT_CODE_NOT_UNIQUE;
        }
        return UserConstants.STUDENT_CODE_UNIQUE;
    }

    @Override
    public int insertCampus(MiScampus scampus) {
        return scampusMapper.insertCampus(scampus);
    }

    @Override
    public int deleteCampus(String campusId) {
        return scampusMapper.deleteCampus(campusId);
    }
}
