package com.hspedu.furns.web;

import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberServlet extends BasicServlet {

    private MemberService memberService = new MemberServiceImpl();
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if ("login".equals(action)){
//            login(req,resp);
//        }else if ("register".equals(action)){
//            register(req,resp);
//        }else {
//            resp.getWriter().write("请求参数action错误");
//        }
//    }


    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    }
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
}
