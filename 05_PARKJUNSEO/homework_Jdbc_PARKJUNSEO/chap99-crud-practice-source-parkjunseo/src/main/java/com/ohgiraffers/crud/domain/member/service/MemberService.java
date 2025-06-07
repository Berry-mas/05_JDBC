package com.ohgiraffers.crud.domain.member.service;

import com.ohgiraffers.crud.common.JDBCTemplate;
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
        List<Member> allMembers = mr.selectAllMembers(con);
        System.out.println("======== 전체 사원 정보 ========");
        for (Member member : allMembers) {
            System.out.println(member.toString());
        }

    }


    public void findAMemberByEmpNo(String empNo) {
        Connection con = getConnection();
        List<Member> members = mr.selectAllMembers(con);
        boolean found = false;
        for (Member member : members) {
            if (member.getEmpId().equals(empNo)) {
                found = true;
                System.out.println("======== 찾으시는 사원 정보 ========");
                System.out.println(member);
            }
        }
        if (!found) {
            System.out.println("======== 찾으시는 사원 정보가 존재하지 않습니다 ========");
        }


    }

    public void findAMenberByEmpName(String empName) {
        Connection con = getConnection();
        List<Member> members = mr.selectAllMembers(con);
        boolean found = false;
        for (Member member : members) {
            if (member.getEmpName().equals(empName)) {
                found = true;
                System.out.println("======== 찾으시는 사원 정보 ========");
                System.out.println(member);
            }
        }
        if (!found) {
            System.out.println("======== 찾으시는 사원 정보가 존재하지 않습니다 ========");
        }
    }

    public boolean insertMember(Member member) {
        Connection con = getConnection();
        boolean result = false;

        try {
            int insertResult = mr.insertMember(con, member);

            if (insertResult > 0) {
                JDBCTemplate.commit(con);
                result = true;
            } else {
                JDBCTemplate.rollback(con);
            }

        } catch (Exception e) {
            JDBCTemplate.rollback(con);
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(con);
        }

        return result;
    }

    public boolean updateMember(Member member) {
        Connection con = getConnection();
        boolean result = false;

        try {
            int updateResult = mr.updateMember(con, member);

            if (updateResult > 0) {
                JDBCTemplate.commit(con);
                result = true;
            } else {
                JDBCTemplate.rollback(con);
            }

        } catch (Exception e) {
            JDBCTemplate.rollback(con);
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(con);
        }

        return result;
    }


    public boolean deleteMember(String inputEmpNo) {

        Connection con = getConnection();
        boolean result = false;

        try {
            int updateResult = mr.deleteMember(con, inputEmpNo);

            if (updateResult > 0) {
                JDBCTemplate.commit(con);
                result = true;
            } else {
                JDBCTemplate.rollback(con);
            }

        } catch (Exception e) {
            JDBCTemplate.rollback(con);
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(con);
        }

        return result;
    }
}
