package com.ruoyi.system.service.impl.baseInfo;

import com.ruoyi.system.domain.MisDiscipline;
import com.ruoyi.system.domain.MisItem;
import com.ruoyi.system.mapper.baseInfo.MisDisciplineMapper;
import com.ruoyi.system.mapper.baseInfo.MisItemMapper;
import com.ruoyi.system.service.DailyOperation.MisDisciplineService;
import com.ruoyi.system.service.DailyOperation.MisItemService;
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
public class MisItemServiceImpl implements MisItemService
{
    private static final Logger log = LoggerFactory.getLogger(MisItemServiceImpl.class);
    @Autowired
    private MisItemMapper itemMapper;


    @Override
    public List<MisItem> selectItemList(MisItem item) {
        return itemMapper.selectItemList(item);
    }

    @Override
    public int insertItem(MisItem item) {
        return itemMapper.insertItem(item);
    }

    @Override
    public MisItem selecItemById(String id) {
        return itemMapper.selecItemById(id);
    }

    @Override
    public int updateItem(MisItem item) {
        return itemMapper.updateItem(item);
    }

    @Override
    public int deleteItemByIds(String ids) {
        return itemMapper.deleteItemByIds(ids);
    }
}
