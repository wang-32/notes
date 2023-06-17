package com.hspedu.furns.web;

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private MemberService memberService = new MemberServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Member member = memberService.login(new Member(null,username,password,null));
        if (member == null){
            request.setAttribute("msg","用户名或者密码错误");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/views/member/login_ok.html").forward(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
