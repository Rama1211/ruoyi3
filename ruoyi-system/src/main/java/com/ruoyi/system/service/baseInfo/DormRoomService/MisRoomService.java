package com.ruoyi.system.service.baseInfo.DormRoomService;

import com.ruoyi.system.domain.MisRoom;

import java.util.List;
import java.util.Map;

/**
 * 房间信息 服务层
 */
public interface MisRoomService
{
    /**
     * 查询房间信息集合
     *
     * @return 房间信息集合
     */
    public List<MisRoom> selectRoomList(String campusId,String floorId);

    /**
     * 根据校区id查找所有楼栋
     *
     * @param campusId 校区id
     * @return 楼栋信息集合
     */
    public Map<String,String> selectfloor(String campusId);

    /**
     * 通过房间ID查询房间信息
     *
     * @param dormId 房间ID
     */
    public MisRoom selectRoomById(Long dormId);


    /**
     * 通过楼栋ID查询该楼栋所有房间信息
     */
    public List<MisRoom> selectRoomByFloorId(String floorId,int level);

    /**
     * 批量删除房间信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteRoomByIds(String ids) throws Exception;

    /**
     * 新增保存房间信息
     *
     * @param room 房间信息
     * @return 结果
     */
    public int insertRoom(MisRoom room);

    /**
     * 修改保存房间信息
     *
     * @param room 房间信息
     * @return 结果
     */
    public int updateRoom(MisRoom room);

    /**
     * 分配宿舍后更新预入住人数
     *
     */
    public int updateEarlyCheckIn(int num,int dormId);



    /**
     * 校验宿舍号
     *
     * @param  room 宿舍信息
     * @return 结果
     */
    public String checkDormmNumUnique(MisRoom room);


    /**
     * 批量新增宿舍
     * @return 结果
     */
    int insertRoomBatch(List<MisRoom> roomList);


    public String selectminNum(int floorId,int campusId,int floorLevel);
}
