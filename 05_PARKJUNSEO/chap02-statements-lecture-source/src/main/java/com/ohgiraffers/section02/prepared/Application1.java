package com.ohgiraffers.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;


public class Application1 {

    public static void main(String[] args) {

        Connection con = getConnection();

        /*
        * PreparedStatement 객체의 타입이 무엇이냐고 묻는다면
        * PreparedStatement 타입이면서 Statement 타입이기도 하다.
        * 상속구조이기 때문이고, 다형성을 적용할 수 있다.
        *
        * close(pstmt) ===> close(Statement stmt = PreparedStatement 타입)
        * */

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = con.prepareStatement("SELECT MENU_NAME, MENU_PRICE FROM tbl_menu");
            /*
            * JDBC에서 SELECT문을 실행할 때 사용하는 메소드
            * Statement 객체일 경우 : executeQuery(쿼리문);
            * 
            * PreparedStatement 객체일 경우 : excuteQuery();
            * */
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.printf("%s %d\n", rset.getString("MENU_NAME"), rset.getInt("MENU_PRICE"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
