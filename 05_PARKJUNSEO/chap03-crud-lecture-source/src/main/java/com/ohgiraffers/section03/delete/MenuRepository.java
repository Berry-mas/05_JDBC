package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuRepository {

    private final Properties prop;

    public MenuRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * 메뉴코드를 이용해서 메뉴삭제 기능
     * @param con 연결객체
     * @param menuCode 삭제할 메뉴코드 번호
     * @return
     */
    public int removeMenu(Connection con, int menuCode) {
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            String sql = prop.getProperty("deleteMenu");
            System.out.println("sql = " + sql);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, menuCode);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        System.out.println();
        return result;
    }
}
