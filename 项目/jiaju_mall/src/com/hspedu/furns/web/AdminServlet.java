package com.hspedu.furns.web;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Member;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.MemberService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import com.hspedu.furns.service.impl.MemberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminServlet extends BasicServlet {

    private MemberService memberService = new MemberServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Member member = memberService.login(new Member(null,username,password,null));
        if(member == null){
            req.getRequestDispatcher("/views/manage/manage_login.jsp").forward(req,resp);
        }else {
            //请求转发
            req.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(req,resp);
        }


    }
}
