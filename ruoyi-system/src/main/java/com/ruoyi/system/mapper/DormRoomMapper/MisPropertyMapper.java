package com.ruoyi.system.mapper.DormRoomMapper;

import com.ruoyi.system.domain.MisFloor;
import com.ruoyi.system.domain.MisProperty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 楼栋信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisPropertyMapper
{
    /**
     * 查询楼栋信息集合
     *
     * @return 楼栋数据集合
     */
    public List<MisProperty> selectPropertyList(MisProperty property);


}
