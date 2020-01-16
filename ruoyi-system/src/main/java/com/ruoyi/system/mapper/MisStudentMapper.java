package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.MisStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生信息 数据层
 * 
 * @author dg
 */
@Repository
public interface MisStudentMapper
{
    /**
     * 查询学生信息集合
     * 
     * @param student 学生信息
     * @return 学生数据集合
     */
    public List<MisStudent> selectStudentList(MisStudent student);

        /**
     * 校验学号唯一
     *
     * @param studentId 学号
     * @return 结果
     */
    public MisStudent checkStudentCodeUnique(String studentId);


        /**
     * 新增学生信息
     *
     * @param student 学生信息
     * @return 结果
     */
    public int insertStudent(MisStudent student);

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
//     */
//    public int deletePostByIds(Long[] ids);
//
//    /**
//     * 修改岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public int updatePost(SysPost post);
//
//    /**
//     * 新增岗位信息
//     *
//     * @param post 岗位信息
//     * @return 结果
//     */
//    public int insertPost(SysPost post);
//
//    /**
//     * 校验岗位名称
//     *
//     * @param postName 岗位名称
//     * @return 结果
//     */
//    public SysPost checkPostNameUnique(String postName);
//
//    /**
//     * 校验岗位编码
//     *
//     * @param postCode 岗位编码
//     * @return 结果
//     */
//    public SysPost checkPostCodeUnique(String postCode);
}
