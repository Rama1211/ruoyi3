package com.ruoyi.system.service.impl.baseInfo;

import com.ruoyi.system.domain.MisRepair;
import com.ruoyi.system.domain.MisVisitor;
import com.ruoyi.system.mapper.baseInfo.MisRepairMapper;
import com.ruoyi.system.mapper.baseInfo.MisVisitorMapper;
import com.ruoyi.system.service.DailyOperation.MisRepairService;
import com.ruoyi.system.service.DailyOperation.MisVusitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *访客信息 服务层处理
 * 
 * @author dg
 */
@Service
public class MisRepairServiceImpl implements MisRepairService
{
    @Autowired
    private MisRepairMapper repairMapper;

    @Override
    public List<MisRepair> selectRepairList(MisRepair repair) {
        return repairMapper.selectRepairList(repair);
    }

    @Override
    public MisRepair selectRepairById(String id) {
        return repairMapper.selectRepairById(id);
    }

    @Override
    public int updateRepair(MisRepair repair) {
        return repairMapper.updateRepair(repair);
    }

    @Override
    public int deleteRepairByIds(String ids) {
        return repairMapper.deleteRepairByIds(ids);
    }

    @Override
    public int insertRepair(MisRepair repair) {
        return repairMapper.insertRepair(repair);
    }
}
