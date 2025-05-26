package com.ohgiraffers.crud.domain.member.view;

import com.ohgiraffers.crud.domain.member.controller.MemberController;
import com.ohgiraffers.crud.domain.member.service.MemberService;

import java.util.Scanner;

public class MemberView {



    public static void main(String[] args) {
        MemberController mc = new MemberController();

        Scanner sc = new Scanner(System.in);
        String menu = """
                ============= 회원 관리 프로그램 ===============
                1. 모든 회원 정보 보기
                2. 회원 찾기
                3. 회원 가입
                4. 회원 정보수정
                5. 회원 탈퇴
                9. 프로그램 종료
                메뉴를 선택해주세요 : """ + " ";

        while(true) {
            System.out.print(menu);
            int input = sc.nextInt();

            switch (input) {
                case 1 :  mc.selectAllMembers(); break;
                case 2 :  mc.findAMember(); break;
                case 3 :  mc.joinMember(); break;
                case 4 :  mc.modifyMember(); break;
                case 5 :  mc.withdrawMember(); break;
                case 9 : return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }
}
