package com.cs.service;

import com.cs.entity.User;

import java.util.List;

public interface UserService {

    //查询数据的总记录数
    public int findByCountUser()throws Exception;

    //分页方法
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception;
    public User serach(int id) throws Exception;
    public int edit(User user) throws Exception;
    public int add1(User user)throws Exception;




}
