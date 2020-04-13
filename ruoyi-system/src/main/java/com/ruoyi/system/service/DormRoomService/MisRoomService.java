package com.ruoyi.system.service.DormRoomService;

import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.domain.SysPost;

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
//
//    /**
//     * 通过岗位ID查询岗位使用数量
//     *
//     * @param postId 岗位ID
//     * @return 结果
//     */
//    public int countUserPostById(Long postId);
//
//    /**
//     * 校验岗位名称
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public String checkPostNameUnique(SysPost post);
//
//    /**
//     * 校验岗位编码
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public String checkPostCodeUnique(SysPost post);
}
