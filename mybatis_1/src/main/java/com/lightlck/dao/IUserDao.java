package com.lightlck.dao;

import com.lightlck.entity.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有的用户
     * @return  List<User>
     */
    List<User> findAll();
}
