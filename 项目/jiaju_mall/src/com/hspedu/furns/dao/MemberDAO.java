package com.hspedu.furns.dao;

import com.hspedu.furns.entity.Member;

public interface MemberDAO {

    //提供一个通过用户名返回对应的Member
    public Member queryMemberByUsername(String username);

    public int saveMember(Member member);

    public Member queryMemberByUsernameAndPassword(String username,String password);
}
