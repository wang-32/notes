package com.hspedu.furns.web;

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private MemberService memberService = new MemberServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户注册信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if(!memberService.isExistsUsername(username)){
            Member member = new Member(null, username, password, email);
            if (memberService.registerMember(member)){
                //System.out.println("注册ok");
                request.getRequestDispatcher("/views/member/register_ok.html").forward(request,response);
            }else {
                //System.out.println("注册失败");
                request.getRequestDispatcher("/views/member/register_ok.html").forward(request,response);
            }
        }else {
            //System.out.println("存在");
            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
        }
        System.out.println("RegisterServlet 被调用");

//        String loginusername = request.getParameter("loginusername");
//        String loginpassword = request.getParameter("loginpassword");

//        if(!memberService.isExistsUsername(loginusername)){
//            Member member = new Member(null, username, password, email);
////            if (memberService.login(loginusername,loginpassword)){
////                //System.out.println("注册ok");
////                System.out.println("登录成功");
////                request.getRequestDispatcher("/views/member/register_ok.html").forward(request,response);
////                System.out.println("登录成功");
////            }else {
////                //System.out.println("注册失败");
////                request.getRequestDispatcher("/views/member/register_ok.html").forward(request,response);
////            }
//        }else {
//            //System.out.println("存在");
//            request.getRequestDispatcher("/views/member/login.jsp").forward(request,response);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
