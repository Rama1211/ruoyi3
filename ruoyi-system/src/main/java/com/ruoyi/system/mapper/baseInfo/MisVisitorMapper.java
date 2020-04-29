package com.ruoyi.system.mapper.baseInfo;

import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.MisVisitor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *访客信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisVisitorMapper
{
    /**
     * 查询访客信息集合
     *
     * @return 访客信息集合
     */
    public List<MisVisitor> selectVisitorList(MisVisitor visitor);

    /**
     * 记录访客信息时查询学生及宿舍是否正确
     */
    public int selectVisitorInfo(MisVisitor visitor);

    /**
     * 新增保存访客信息
     *
     * @param visitor 访客信息
     * @return 结果
     */
    public int insertVisitor(MisVisitor visitor);

    /**
     * 修改保存访客信息
     *
     * @param visitor
     * @return 结果
     */
    public int updateVisitor(MisVisitor visitor);

    /**
     * 通过id查询访客信息
     *
     * @param id ID
     * @return 访客信息
     */
    public MisVisitor selectVisitorById(String id);

    /**
     * 删除访客信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVisitorByIds(String ids);

}
