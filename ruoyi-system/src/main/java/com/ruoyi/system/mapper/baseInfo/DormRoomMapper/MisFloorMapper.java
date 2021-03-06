package com.ruoyi.system.mapper.baseInfo.DormRoomMapper;

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
    public List<MisFloor> selectFloorByCampusId(@Param("campusId")String campusId,@Param("floorName")String floorId);


    /**
     * 通过校区id和楼栋名称查询楼栋信息集合
     *
     * @param campusId 校区id
     * @return 楼栋数据集合
     */
    public MisFloor selectFloorByFloorName(@Param("campusId")String campusId,@Param("floorName")String floorName);



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

    //通过id查询楼栋信息
    public MisFloor selectFloorById(String floorId);

    /**
     * 修改楼栋信息
     *
     * @param floor 楼栋信息
     * @return 结果
     */
    public int updateFloor(MisFloor floor);


    /**
     * 删除楼栋信息
     *
     * @param floorId 楼栋id
     * @return 结果
     */
    public int deleteFloor(String floorId);


    //增加楼栋时校区表楼栋数加一
    public void addOne(@Param("floorNum") int floorNum,@Param("campusId") String campusId,@Param("updateBy") String updateBy);

    //删除楼栋时校区表楼栋数减一
    public void reduceOne(@Param("floorNum") int floorNum,@Param("campusId") String campusId,@Param("updateBy") String updateBy);

    /**
     * 根据校区id查找校区楼栋数
     *
     * @param campusId 校区id
     * @return 结果
     */
    public int selectFloorByCampus(String campusId);

    /**
     *根据floorid查看校区id
     * @param floorId 楼栋id
     * @return 结果
     */
    public int selectCampusIdByFloorId(String floorId);



    /**
     * 删除校区信息时删除所有该小区楼栋
     *
     * @return 结果
     */
    public int deleteFloorBycampuse(String campusId);

}
