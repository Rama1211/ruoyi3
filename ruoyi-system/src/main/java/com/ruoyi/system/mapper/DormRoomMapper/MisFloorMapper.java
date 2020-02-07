package com.ruoyi.system.mapper.DormRoomMapper;

import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisFloor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 楼栋信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisFloorMapper
{
    /**
     * 查询楼栋信息集合
     *
     * @param campusId 校区id
     * @return 楼栋数据集合
     */
    public List<MisFloor> selectFloorByCampusId(@Param("campusId")long campusId,@Param("floorName")String floorId);


    /**
     * 校验楼栋名称唯一
     *
     * @param floorName 楼栋名称
     * @return 结果
     */
    public MisFloor checkFloorNameUnique(@Param("floorName")String floorName,@Param("campusId") String campusId);

    /**
     * 新增楼栋信息
     *
     * @param floor 楼栋信息
     * @return 结果
     */
    public int insertFloor(MisFloor floor);
}
