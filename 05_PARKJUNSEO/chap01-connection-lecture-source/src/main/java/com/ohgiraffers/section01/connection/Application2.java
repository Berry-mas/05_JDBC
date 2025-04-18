package com.ohgiraffers.section01.connection;

import com.ohgiraffers.section02.template.JDBCTemplate;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* import static은 메소드명까지 작성하며 static 메소드를 '클래스명'으로 생략하고 호출할 수 있다. */
import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Properties props = new Properties();
        Connection con = null;

        try {

            props.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            Class.forName(driver);

            /* 설정 정보는 유지보수성을 위해 리터럴 값으로 작성하지 않고 별도의 파일로 분리한다. */
            con = DriverManager.getConnection(url, user, password);
            con = DriverManager.getConnection(url, props);     // 위, 아래 둘다 가능

            System.out.println("con = " + con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            con = getConnection();
            System.out.println("con = " + con);

            // 내가 원하는 시점에 생성
            close(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

