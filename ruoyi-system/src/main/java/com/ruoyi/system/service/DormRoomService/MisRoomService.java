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

//    /**
//     * 批量删除岗位信息
//     *
//     * @param ids 需要删除的数据ID
//     * @return 结果
//     * @throws Exception 异常
//     */
//    public int deletePostByIds(String ids) throws Exception;
//
//    /**
//     * 新增保存岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public int insertPost(SysPost post);
//
//    /**
//     * 修改保存岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public int updatePost(SysPost post);
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
