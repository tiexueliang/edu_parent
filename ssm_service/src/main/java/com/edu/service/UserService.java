package com.edu.service;

import com.github.pagehelper.PageInfo;
import com.edu.domain.ResponseResult;
import com.edu.domain.Role;
import com.edu.domain.User;
import com.edu.domain.UserVo;

import java.util.List;

public interface UserService {

    /*
        查询所有用户
    */
    public PageInfo findAllUserByPage(UserVo userVo);


    /*
    * 修改用户状态
    * */
    public void updateUserStatus(int id, String status);

    /*
        用户登陆
     */
    public User login(User user);


    /*
    * 获取用户权限
    * */
    ResponseResult getUserPermissions(Integer id);

    /*
         用户关联角色
     */
    void userContextRole(UserVo userVo);

    /**
     * 根据ID查询用户当前角色
     * */
    List<Role> findUserRelationRoleById(int id);

    User findUserById(String phone);
}
