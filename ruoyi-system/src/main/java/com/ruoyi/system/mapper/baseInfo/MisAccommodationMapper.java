package com.ruoyi.system.mapper.baseInfo;

import com.ruoyi.system.domain.MisAccommodation;
import com.ruoyi.system.domain.MisFloor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 分配房间信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisAccommodationMapper
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
