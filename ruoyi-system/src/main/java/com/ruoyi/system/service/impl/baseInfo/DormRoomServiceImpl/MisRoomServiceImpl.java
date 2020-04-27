package com.ruoyi.system.service.impl.baseInfo.DormRoomServiceImpl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisRoom;
import com.ruoyi.system.mapper.baseInfo.DormRoomMapper.MisRoomMapper;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisRoomService;
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
    public List<MisRoom> selectRoomByFloorId(String floorId, int level) {
        return roomMapper.selectRoomByFloorId(floorId,level);
    }


    @Override
    public int updateRoom(MisRoom room) {
        return roomMapper.updateRoom(room);
    }

    @Override
    public int updateEarlyCheckIn(int num,int dormId) {
        return roomMapper.updateEarlyCheckIn(num,dormId);
    }

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

    @Override
    public int insertRoom(MisRoom room) {
        return roomMapper.insertRoom(room);
    }

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
    /**
     * 校验宿舍号是否唯一
     *
     * @param room 宿舍信息
     * @return 结果
     */
    @Override
    public String checkDormmNumUnique(MisRoom room)
    {
        MisRoom info = roomMapper.checkDormmNumUnique(room.getDormNum(),room.getFloorId(),room.getCampusId());
        if (StringUtils.isNotNull(info))
        {
            return UserConstants.ROOM_CODE_NOT_UNIQUE;
        }
        return UserConstants.ROOM_CODE_UNIQUE;
    }

    @Override
    public int insertRoomBatch(List<MisRoom> roomList) {
        return roomMapper.insertRoomBatch(roomList);
    }

    @Override
    public String selectminNum(int floorId,int campusId,int floorLevel) {
        return roomMapper.selectminNum(floorId,campusId,floorLevel);
    }
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
