package com.ohgiraffers.crud.domain.member.controller;

import com.ohgiraffers.crud.domain.member.service.MemberService;

import java.util.Scanner;

public class MemberController {

    MemberService ms = new MemberService();

    public void selectAllMembers() {
            ms.selectAllMembers();


    }
    public void findAMember(int selectEmployeeIdentifier) {
        Scanner sc = new Scanner(System.in);
        String searchUsingEmpNO = """
                ❗ 찾으시는 사원의 사원번호를 입력해주세요 : """ + " ";
        String searchUsingEmpName = """
                ❗ 찾으시는 사원의 이름을 입력해주세요 : """ + " ";
        if (selectEmployeeIdentifier == 1) {
            System.out.println(searchUsingEmpNO);
            String empNo = sc.nextLine();
            ms.findAMemberByEmpNo(empNo);
        } else if (selectEmployeeIdentifier == 2) {
            System.out.println(searchUsingEmpName);
            String empName = sc.nextLine();
            ms.findAMenberByEmpName(empName);
        }
    }

    public void joinMember() {
    }

    public void modifyMember() {
    }

    public void withdrawMember() {
    }
}
