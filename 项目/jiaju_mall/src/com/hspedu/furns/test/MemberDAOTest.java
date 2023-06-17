package com.hspedu.furns.test;

import com.hspedu.furns.dao.MemberDAO;
import com.hspedu.furns.dao.impl.MemberDAOImpl;
import com.hspedu.furns.entity.Member;
import org.junit.jupiter.api.Test;

public class MemberDAOTest {

    private MemberDAO memberDAO = new MemberDAOImpl();

    @Test
    public void queryMemberByUsername(){
        if(memberDAO.queryMemberByUsername("admin") == null){
            System.out.println("该用户不存在");
        }else {
            System.out.println("存在");
        }
    }

    @Test
    public void saveMember(){
        Member member = new Member(null, "king", "king", "king@sohu.com");
        if (memberDAO.saveMember(member) == 1){
            System.out.println("添加ok");
        }else {
            System.out.println("添加失败");
        }
    }
    @Test
    public void queryMemberByUsernameAndPassword(){
        Member member = memberDAO.queryMemberByUsernameAndPassword("admin", "admin");
        System.out.println("member" + member);
    }
}
