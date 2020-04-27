package com.ruoyi.system.mapper.baseInfo.DormRoomMapper;

import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisRoom;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 房间信息 数据层
 *
 * @author ruoyi
 */
@Repository
public interface MisRoomMapper {
    /**
     * 查询房间信息数据集合
     *
     * @return 房间信息数据集合
     */
    public List<MisRoom> selectRoomService(@Param("campusId") String campusId, @Param("floorId") String floorId);

    /**
     * 根据校区id查找所有楼栋
     *
     * @param campusId 校区id
     * @return 房间信息数据集合
     */
    public List<MisFloor> selectfloor(String campusId);

    /**
     * 通过房间ID查询房间信息
     *
     * @param dormId 房间ID
     */
    public MisRoom selectRoomById(Long dormId);

    /**
     * 分配宿舍后更新预入住人数
     *
     */
    public int updateEarlyCheckIn(@Param("num") int num,@Param("dormId") int dormId);


    /**
     * 通过楼栋ID查询该楼栋所有房间信息
     */
    public List<MisRoom> selectRoomByFloorId(@Param("floorId") String floorId,@Param("level") int level);

    /**
     * 批量删除房间信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoomByIds(Long[] ids);

    /**
     * 修改房间信息
     *
     * @param room 房间信息
     * @return 结果
     */
    public int updateRoom(MisRoom room);

    /**
     * 新增房间信息
     *
     * @param room 房间信息
     * @return 结果
     */
    public int insertRoom(MisRoom room);

    /**
     * 检查宿舍号是否唯一
     *
     * @param dormNum 宿舍号
     * @return 结果
     */
    public MisRoom checkDormmNumUnique(@Param("dormNum") String dormNum, @Param("floorId") Integer floorId, @Param("campusId") int campusId);

    /**
     * 批量新增宿舍
     *
     * @return 结果
     */
    public int insertRoomBatch(List<MisRoom> roomList);


    public String selectminNum(@Param("floorId") int floorId, @Param("campusId") int campusId, @Param("floorLevel") int floorLevel);
}
