package com.ohgiraffers.crud.domain.member.controller;

import com.ohgiraffers.crud.domain.member.service.MemberService;

public class MemberController {

    MemberService ms = new MemberService();

    public void selectAllMembers() {
        ms.selectAllMembers();
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
