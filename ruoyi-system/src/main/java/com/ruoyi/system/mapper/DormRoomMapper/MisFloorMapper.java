package com.ruoyi.system.mapper.DormRoomMapper;

import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisFloor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisFloorMapper
{
    /**
     * 查询校区信息集合
     * 
     * @param campusId 校区id
     * @return 校区数据集合
     */
    public List<MisFloor> selectFloorByCampusId(long campusId);



}
