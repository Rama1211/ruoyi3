package com.ruoyi.system.mapper.baseInfo;

import com.ruoyi.system.domain.MisDiscipline;
import com.ruoyi.system.domain.MisItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *物品出入信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisItemMapper
{
    /**
     * 物品出入信息集合
     *
     * @return 物品出入信息集合
     */
    public List<MisItem> selectItemList(MisItem item);

    /**
     * 新增物品出入
     *
     * @param item 物品出入
     * @return 结果
     */
    public int insertItem(MisItem item);

    /**
     * 通过id查询物品出入信息
     *
     * @param id ID
     * @return 出入信息
     */
    public MisItem selecItemById(String id);

    /**
     * 修改保存物品出入信息
     *
     * @param item 物品出入信息
     * @return 结果
     */
    public int updateItem(MisItem item);

    /**
     * 删除物品出入信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteItemByIds(String ids);
}
