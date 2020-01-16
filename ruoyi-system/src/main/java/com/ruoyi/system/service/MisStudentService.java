package com.ruoyi.system.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.MisStudent;
import com.ruoyi.system.domain.SysPost;

import java.util.List;

/**
 * 学生信息 服务层
 * 
 * @author dg
 */
public interface MisStudentService
{
    /**
     * 查询学生信息集合
     * 
     * @param student 学生信息
     * @return 学生信息息集合
     */
    public List<MisStudent> selectStudentList(MisStudent student);

        /**
     * 校验学生学号是否唯一
     *
     *
     * @param student 学生信息
     * @return 结果
     */
    public String checkStudentCodeUnique(MisStudent student);



        /**
     * 新增保存学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    public int insertStudent(MisStudent student);



//
//    /**
//     * 查询所有岗位
//     *
//     * @return 岗位列表
//     */
//    public List<SysPost> selectPostAll();
//
//    /**
//     * 根据用户ID查询岗位
//     *
//     * @param userId 用户ID
//     * @return 岗位列表
//     */
//    public List<SysPost> selectPostsByUserId(Long userId);
//
//    /**
//     * 通过岗位ID查询岗位信息
//     *
//     * @param postId 岗位ID
//     * @return 角色对象信息
//     */
//    public SysPost selectPostById(Long postId);
//
//    /**
//     * 批量删除岗位信息
//     *
//     * @param ids 需要删除的数据ID
//     * @return 结果
//     * @throws Exception 异常
//     */
//    public int deletePostByIds(String ids) throws Exception;
//
//    /**
//     * 新增保存岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public int insertPost(SysPost post);
//
//    /**
//     * 修改保存岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public int updatePost(SysPost post);
//
//    /**
//     * 通过岗位ID查询岗位使用数量
//     *
//     * @param postId 岗位ID
//     * @return 结果
//     */
//    public int countUserPostById(Long postId);
//
//    /**
//     * 校验岗位名称
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public String checkPostNameUnique(SysPost post);
//
//    /**
//     * 校验岗位编码
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public String checkPostCodeUnique(SysPost post);
}
