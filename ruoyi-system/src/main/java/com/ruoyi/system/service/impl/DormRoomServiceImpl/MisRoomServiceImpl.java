package com.ruoyi.system.service.impl.DormRoomServiceImpl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.mapper.DormRoomMapper.MisRoomMapper;
import com.ruoyi.system.service.DormRoomService.MisRoomService;
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
public class MisRoomServiceImpl implements MisRoomService
{
    @Autowired
    private MisRoomMapper roomMapper;

    /**
     * 查询房间信息集合
     *
     * @return 房间信息集合
     */
    @Override
    public List<MisRoom> selectRoomList(String campusId,String floorId)
    {
        return roomMapper.selectRoomService(campusId,floorId);
    }

    @Override
    public Map<String, String> selectfloor(String campusId) {
        List<MisFloor> list=new ArrayList<>();
        Map<String,String> map=new HashMap<>();
        for (MisFloor floor:list){
            map.put(floor.getFloorId(),floor.getFloorName());
        }
        return map;
    }

    @Override
    public MisRoom selectRoomById(Long dormId) {
        return roomMapper.selectRoomById(dormId);
    }


    @Override
    public int updateRoom(MisRoom room) {
        return roomMapper.updateRoom(room);
    }

//    /**
//     * 查询所有岗位
//     *
//     * @return 岗位列表
//     */
//    @Override
//    public List<SysPost> selectPostAll()
//    {
//        return postMapper.selectPostAll();
//    }
//
//    /**
//     * 根据用户ID查询岗位
//     *
//     * @param userId 用户ID
//     * @return 岗位列表
//     */
//    @Override
//    public List<SysPost> selectPostsByUserId(Long userId)
//    {
//        List<SysPost> userPosts = postMapper.selectPostsByUserId(userId);
//        List<SysPost> posts = postMapper.selectPostAll();
//        for (SysPost post : posts)
//        {
//            for (SysPost userRole : userPosts)
//            {
//                if (post.getPostId().longValue() == userRole.getPostId().longValue())
//                {
//                    post.setFlag(true);
//                    break;
//                }
//            }
//        }
//        return posts;
//    }
//
//    /**
//     * 通过岗位ID查询岗位信息
//     *
//     * @param postId 岗位ID
//     * @return 角色对象信息
//     */
//    @Override
//    public SysPost selectPostById(Long postId)
//    {
//        return postMapper.selectPostById(postId);
//    }

    /**
     * 批量删除岗位信息
     *
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteRoomByIds(String ids) throws BusinessException
    {
        Long[] roomIds = Convert.toLongArray(ids);
        return roomMapper.deleteRoomByIds(roomIds);
    }
//
//    /**
//     * 新增保存岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    @Override
//    public int insertPost(SysPost post)
//    {
//        return postMapper.insertPost(post);
//    }
//
//    /**
//     * 修改保存岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    @Override
//    public int updatePost(SysPost post)
//    {
//        return postMapper.updatePost(post);
//    }
//
//    /**
//     * 通过岗位ID查询岗位使用数量
//     *
//     * @param postId 岗位ID
//     * @return 结果
//     */
//    @Override
//    public int countUserPostById(Long postId)
//    {
//        return userPostMapper.countUserPostById(postId);
//    }
//
//    /**
//     * 校验岗位名称是否唯一
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    @Override
//    public String checkPostNameUnique(SysPost post)
//    {
//        Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
//        SysPost info = postMapper.checkPostNameUnique(post.getPostName());
//        if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue())
//        {
//            return UserConstants.POST_NAME_NOT_UNIQUE;
//        }
//        return UserConstants.POST_NAME_UNIQUE;
//    }
//
//    /**
//     * 校验岗位编码是否唯一
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    @Override
//    public String checkPostCodeUnique(SysPost post)
//    {
//        Long postId = StringUtils.isNull(post.getPostId()) ? -1L : post.getPostId();
//        SysPost info = postMapper.checkPostCodeUnique(post.getPostCode());
//        if (StringUtils.isNotNull(info) && info.getPostId().longValue() != postId.longValue())
//        {
//            return UserConstants.POST_CODE_NOT_UNIQUE;
//        }
//        return UserConstants.POST_CODE_UNIQUE;
//    }
}
