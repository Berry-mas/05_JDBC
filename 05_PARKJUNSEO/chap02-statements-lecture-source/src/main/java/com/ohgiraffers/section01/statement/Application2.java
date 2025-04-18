package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    /* 메뉴코드를 입력받아서 하나의 메뉴를 */
    public static void main(String[] args) {

        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴코드를 입력하세요 : ");
        int menuCode = sc.nextInt();

        String query = "select * from menu where menu_code = " + menuCode;
        System.out.println("query = " + query);

        try {
            rset = stmt.executeQuery(query);
            if(rset.next()) {
                System.out.print(rset.getString("menu_name") + " ");
                System.out.print(rset.getInt("menu_price\n"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
    }

}
