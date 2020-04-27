package com.ruoyi.system.service.impl.baseInfo;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MisAccommodation;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.mapper.baseInfo.DormRoomMapper.MisRoomMapper;
import com.ruoyi.system.mapper.baseInfo.MisAccommodationMapper;
import com.ruoyi.system.mapper.baseInfo.student.MisStudentMapper;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisAccommodationService;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 房间信息 服务层处理
 *
 * @author ruoyi
 */
@Service
public class MisAccommodationServiceImpl implements MisAccommodationService {

    @Autowired
    private MisAccommodationMapper accommodationMapper;

    @Override
    public int insertAccommodation(MisAccommodation accommodation) {
        return accommodationMapper.insertAccommodation(accommodation);
    }

    @Override
    public int checnkIn(Long studentId) {
        return accommodationMapper.checnkIn(studentId);
    }

    @Override
    public int checnkOut(Long studentId) {
        return accommodationMapper.checnkOut(studentId);
    }

    @Override
    public MisAccommodation selectAccommodationById(Long studentId) {
        return accommodationMapper.selectAccommodationById(studentId);
    }
}
