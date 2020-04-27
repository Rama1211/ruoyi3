package com.ruoyi.system.service.baseInfo.DormRoomService;

import com.ruoyi.system.domain.MisAccommodation;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.domain.MisStudent;

import java.util.List;
import java.util.Map;

/**
 */
public interface MisAccommodationService
{
    /**
     * 分配房间信息
     *
     * @return 结果
     */
    public int insertAccommodation(MisAccommodation accommodation);

    /**
     * 入住
     *
     * @return 结果
     */
    public int checnkIn(Long studentId);

    /**
     * 退宿
     *
     * @return 结果
     */
    public int checnkOut(Long studentId);


    /**
     * 通过学号查询入住表信息
     */
    public MisAccommodation selectAccommodationById(Long studentId);


}
