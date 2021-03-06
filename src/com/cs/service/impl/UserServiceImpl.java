package com.cs.service.impl;

import com.cs.dao.impl.UserDaoImpl;
import com.cs.entity.User;
import com.cs.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl udi=new UserDaoImpl();
    @Override
    public int findByCountUser() throws Exception {
        return udi.findByCountUser();
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        return udi.findByPageUserInfo(pageNo,pageSize);
    }

    @Override
    public User serach(int id) throws Exception {
        return udi.serach(id);
    }

    @Override
    public int edit(User user) throws Exception {
        return udi.edit(user);
    }

    @Override
    public int add1(User user) throws Exception {

        return udi.add1(user);

    }

}
