package com.ohgiraffers.crud.domain.member.service;

import com.ohgiraffers.crud.domain.member.dto.Member;
import com.ohgiraffers.crud.domain.member.repository.MemberRepository;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.crud.common.JDBCTemplate.close;
import static com.ohgiraffers.crud.common.JDBCTemplate.getConnection;

public class MemberService {

    private final MemberRepository mr;

    public MemberService() {
        mr = new MemberRepository();
    }

    public void selectAllMembers() {

        Connection con = getConnection();

        List<Member> memberList = mr.selectAllMembers(con);

        for(Member member : memberList) {
            System.out.println(member);
        }

        close(con);
    }

    public void findAMember() {
    }

    public void joinMember() {
    }

    public void modifyMember() {
    }

    public void withdrawMember() {
    }
}
