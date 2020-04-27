package com.ruoyi.system.service.impl.baseInfo.DormRoomServiceImpl;

import com.ruoyi.system.domain.DimProperty;
import com.ruoyi.system.domain.MisProperty;
import com.ruoyi.system.domain.MisPropertyTemplate;
import com.ruoyi.system.mapper.baseInfo.DormRoomMapper.MisPropertyMapper;
import com.ruoyi.system.service.baseInfo.DormRoomService.MisPeropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公寓信息 服务层处理
 * 
 * @author dg
 */
@Service
public class MisPropertyServiceImpl implements MisPeropertyService
{
    @Autowired
    private MisPropertyMapper propertyMapper;

    @Override
    public List<MisProperty> selectPropertyList(String dormId,String propertyName) {
        return propertyMapper.selectPropertyList(dormId,propertyName);
    }

    @Override
    public MisProperty selectPropertyById(String propertyId) {
        return propertyMapper.selectPropertyById(propertyId);
    }

    @Override
    public int updateProperty(MisProperty property) {
        return propertyMapper.updateProperty(property);
    }

    @Override
    public int deletePropertyByIds(String ids) {
        return propertyMapper.deletePropertyByIds(ids);
    }

    @Override
    public List<DimProperty> selectDimPropertyAll() {
        return propertyMapper.selectDimPropertyAll();
    }

    @Override
    public int insertProperty(MisProperty property) {
        return propertyMapper.insertProperty(property);
    }

    @Override
    public List<MisPropertyTemplate> selectPropertyTem(String templateName) {
        return propertyMapper.selectPropertyTem(templateName);
    }
}
