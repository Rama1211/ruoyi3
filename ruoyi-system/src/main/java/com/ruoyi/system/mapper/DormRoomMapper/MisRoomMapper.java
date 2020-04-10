package com.ruoyi.system.mapper.DormRoomMapper;

import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.domain.SysPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 房间信息 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface MisRoomMapper
{
    /**
     * 查询房间信息数据集合
     * 
     * @return 房间信息数据集合
     */
    public List<MisRoom> selectRoomService(@Param("campusId")String campusId,@Param("floorId")String floorId);

    /**
     * 根据校区id查找所有楼栋
     *
     * @param campusId 校区id
     * @return 房间信息数据集合
     */
        public List<MisFloor> selectfloor(String campusId);

//    /**
//     * 查询所有岗位
//     *
//     * @return 岗位列表
//     */
//    public List<SysPost> selectPostAll();
//
//    /**
//     * 根据用户ID查询岗位
//     *
//     * @param userId 用户ID
//     * @return 岗位列表
//     */
//    public List<SysPost> selectPostsByUserId(Long userId);
//
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
     */
    public int deleteRoomByIds(Long[] ids);

    /**
     * 修改房间信息
     *
     * @param room 房间信息
     * @return 结果
     */
    public int updateRoom(MisRoom room);
//
//    /**
//     * 新增岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public int insertPost(SysPost post);
//
//    /**
//     * 校验岗位名称
//     *
//     * @param postName 岗位名称
//     * @return 结果
//     */
//    public SysPost checkPostNameUnique(String postName);
//
//    /**
//     * 校验岗位编码
//     *
//     * @param postCode 岗位编码
//     * @return 结果
//     */
//    public SysPost checkPostCodeUnique(String postCode);
}
