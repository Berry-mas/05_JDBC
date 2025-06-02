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

    }


    public void findAMemberByEmpNo(String empNo) {

    }

    public void findAMenberByEmpName(String empName) {
    }
}
