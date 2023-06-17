package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.BasicDAO;
import com.hspedu.furns.dao.MemberDAO;
import com.hspedu.furns.entity.Member;

public class MemberDAOImpl extends BasicDAO<Member> implements MemberDAO {
    @Override
    public Member queryMemberByUsername(String username) {
        String sql = "SELECT id,username,password,email from member where username = ?";
        Member member = querySingle(sql, Member.class, username);
        return member;
    }

    @Override
    public int saveMember(Member member) {
        String sql = "insert into member(username,password,email) VALUES(?,MD5(?),?)";
        return update(sql,member.getUsername(),member.getPassword(),member.getEmail());
    }

    @Override
    public Member queryMemberByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from member where username = ? and password = md5(?)";
        return querySingle(sql,Member.class,username,password);
    }
}
