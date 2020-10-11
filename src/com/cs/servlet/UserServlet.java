package com.cs.servlet;

import com.cs.entity.User;
import com.cs.service.impl.UserServiceImpl;
import com.cs.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm=request.getParameter("comm");
        System.out.println(comm);
        PageSupport ps = null;
        UserServiceImpl usi = null;
        if(comm.equals("list")) {
            String pageNO = request.getParameter("indexno");
            if (pageNO == null || pageNO == "") {
                pageNO = "1";
            }
            int pno = Integer.parseInt(pageNO);
            usi = new UserServiceImpl();
            ps = new PageSupport();
            ps.setCurrentPageNo(pno);
            ps.setPageSize(3);
            try {
                ps.setTotalCount(usi.findByCountUser());
                List<User> list = usi.findByPageUserInfo(ps.getCurrentPageNo(), ps.getPageSize());
                if (list.size() > 0 && list != null) {
                    request.getSession().setAttribute("lists", list);
                    request.getSession().setAttribute("ps", ps);
                    response.sendRedirect("list.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(comm.equals("query")){
            String id = request.getParameter("id");
            int i = Integer.parseInt(id);
            usi = new UserServiceImpl();
            ps=new PageSupport();
            User user =null;

            try {
                user = usi.serach(i);
                if (user!=null){
                    request.getSession().setAttribute("user",user);
                    response.sendRedirect("query.jsp");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        if (comm.equals("add")){
            System.out.println(comm);

            try {
                User user2 = new User();
                usi=new UserServiceImpl();
                String name = request.getParameter("username");
                user2.setUsername(name);
                String password = request.getParameter("password");
                user2.setPassword(password);
                if (usi.add1(user2)>0){
                    request.getRequestDispatcher("UserServlet?comm=list").forward(request,response);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        if(comm.equals("del")){


        }
        if(comm.equals("update")){

            try {
                usi = new UserServiceImpl();
                String id1 = request.getParameter("id");
                int i1 = Integer.parseInt(id1);
                User user1 = new User();
                user1.setId(i1);
                String name = request.getParameter("username");
                user1.setUsername(name);
                String password = request.getParameter("password");
                user1.setPassword(password);

                    usi.edit(user1);
                 //   response.sendRedirect("list.jsp");

                request.getRequestDispatcher("UserServlet?comm=list").forward(request,response);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request,response);
    }
}
