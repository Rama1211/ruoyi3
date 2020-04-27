package com.ruoyi.system.service.impl.baseInfo;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.MisVisitor;
import com.ruoyi.system.mapper.baseInfo.MisVisitorMapper;
import com.ruoyi.system.mapper.baseInfo.student.MisStudentMapper;
import com.ruoyi.system.service.DailyOperation.MisVusitorService;
import com.ruoyi.system.service.baseInfo.student.MisStudentService;
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
public class MisVisitorServiceImpl implements MisVusitorService
{
    private static final Logger log = LoggerFactory.getLogger(MisVisitorServiceImpl.class);
    @Autowired
    private MisVisitorMapper visitorMapper;


    @Override
    public List<MisVisitor> selectVisitorList(MisVisitor visitor) {
        return visitorMapper.selectVisitorList(visitor);
    }
}
