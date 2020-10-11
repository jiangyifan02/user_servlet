package com.cs.dao.impl;

import com.cs.basedao.BaseDao;
import com.cs.dao.UserDao;
import com.cs.entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int findByCountUser() throws Exception {
        int index=0;
        String sql="select Count(*) from user";
        ResultSet rs=exeuQuery(sql,null);
        while(rs.next()){
            index=rs.getInt(1);
        }
        getClose();
        return index;
    }

    @Override
    public List<User> findByPageUserInfo(int pageNo, int pageSize) throws Exception {
        List<User> list=new ArrayList<User>();
        String sql="select * from user limit ?,?";
        Object obj[]={(pageNo-1)*pageSize,pageSize};
        ResultSet rs=exeuQuery(sql,obj);
        while(rs.next()){
            User us=new User();
            us.setId(rs.getInt(1));
            us.setUsername(rs.getString(2));
            us.setPassword(rs.getString(3));
            us.setBorndate(rs.getDate(4));
            list.add(us);
        }
        getClose();
        return list;
    }

    @Override
    public User serach(int id) throws Exception {
        User us1=null;
        String sql="select * from user where id=?";
        Object[] objects={id};
        ResultSet rs = exeuQuery(sql,objects);
        while (rs.next()){
            us1=new User();
            us1.setId(rs.getInt(1));
            us1.setUsername(rs.getString(2));
            us1.setPassword(rs.getString(3));
        }
        getClose();
        return us1;
    }

    @Override
    public int edit(User user) throws Exception {
        int a=-1;
        String sql = "update user set username=?,password=?where id=?";
        Object[] objects={user.getUsername(),user.getPassword(),user.getId()};
        a = exeuUpdate(sql, objects);
        getClose();
        return a;
    }

    @Override
    public int add1(User user) throws Exception {
        int b=-1;
        String sql = "INSERT INTO `user`(username,password,borndate,userpic)VALUE(?,?,?,?)";
        Object[] objects={user.getUsername(),user.getPassword(),user.getBorndate(),user.getUserpic()};
        b = exeuUpdate(sql, objects);
        getClose();
        return b;
    }
}
