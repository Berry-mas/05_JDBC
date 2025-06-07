package com.ohgiraffers.crud.domain.member.controller;

import com.ohgiraffers.crud.domain.member.dto.Member;
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
            System.out.print(searchUsingEmpNO);
            String empNo = sc.nextLine();
            ms.findAMemberByEmpNo(empNo);
        } else if (selectEmployeeIdentifier == 2) {
            System.out.print(searchUsingEmpName);
            String empName = sc.nextLine();
            ms.findAMenberByEmpName(empName);
        }
    }

    public void joinMember(Member member) {

        boolean result = ms.insertMember(member); // 비즈니스 로직 처리
        if (result) {
            System.out.println("회원 가입이 완료되었습니다.");
        } else {
            System.out.println("회원 가입에 실패했습니다.");
        }

    }

    public void modifyMember(Member member) {

        boolean result = ms.updateMember(member); // 비즈니스 로직 처리
        if (result) {
            System.out.println("회원 수정이 완료되었습니다.");
        } else {
            System.out.println("회원 수정에 실패했습니다.");
        }

    }

    public void withdrawMember() {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제하실 회원 번호를 입력해주세요 : ");
        String inputEmpNo = sc.nextLine();
        boolean result = ms.deleteMember(inputEmpNo); // 비즈니스 로직 처리
        if (result) {
            System.out.println("회원 삭제가 완료되었습니다.");
        } else {
            System.out.println("회원 삭제가 실패했습니다.");
        }

    }
}
