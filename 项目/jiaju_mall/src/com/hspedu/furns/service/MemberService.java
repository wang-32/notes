package com.hspedu.furns.service;

import com.hspedu.furns.entity.Member;

public interface MemberService {

    //注册用户
    public boolean registerMember(Member member);

    //判断用户名是否存在
    public boolean isExistsUsername(String username);

    public Member login(Member member);
}
