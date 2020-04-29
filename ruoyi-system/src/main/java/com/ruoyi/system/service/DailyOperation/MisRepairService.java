package com.ruoyi.system.service.DailyOperation;

import com.ruoyi.system.domain.MiScampus;
import com.ruoyi.system.domain.MisRepair;
import com.ruoyi.system.domain.MisVisitor;

import java.util.List;

/**
 * 维修信息 服务层
 */
public interface MisRepairService
{
    /**
     * 查询维修信息集合
     *
     * @return 维修信息集合
     */
    public List<MisRepair> selectRepairList(MisRepair repair);

    /**
     * 通过id查询维修信息
     *
     * @param id
     * @return 维修信息
     */
    public MisRepair selectRepairById(String id);

    /**
     * 修改保存维修信息
     *
     * @param repair 维修信息
     * @return 结果
     */
    public int updateRepair(MisRepair repair);


    /**
     * 删除维修信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRepairByIds(String ids);


    /**
     * 新增维修信息
     *
     * @param repair 维修信息
     * @return 结果
     */
    public int insertRepair(MisRepair repair);

}
