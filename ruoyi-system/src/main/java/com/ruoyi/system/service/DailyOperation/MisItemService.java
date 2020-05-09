package com.ruoyi.system.service.DailyOperation;

import com.ruoyi.system.domain.MisDiscipline;
import com.ruoyi.system.domain.MisItem;
import com.ruoyi.system.domain.MisRepair;
import com.ruoyi.system.domain.MisVisitor;

import java.util.List;

/**
 * 物品出入信息 服务层
 */
public interface MisItemService
{
    /**
     * 查询物品出入信息集合
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
