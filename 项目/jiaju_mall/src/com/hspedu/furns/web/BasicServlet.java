package com.hspedu.furns.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BasicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        //使用反射，获取当前对象的方法
        try {
            Method declaredMethod = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //使用方法对象，进行反射调用
            System.out.println(this);
            declaredMethod.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
