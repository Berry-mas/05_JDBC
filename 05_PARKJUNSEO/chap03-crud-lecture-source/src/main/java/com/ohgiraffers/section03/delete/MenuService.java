package com.ohgiraffers.section03.delete;

import com.ohgiraffers.section03.delete.Menu;
import com.ohgiraffers.section03.delete.MenuRepository;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;
import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuService {

    private final MenuRepository menuRepository = new MenuRepository();

    public void deleteMenu(int menuCode) {
        System.out.println("[MenuService] deleteMenu() : menu ===> " + menuCode);

        Connection con = getConnection();
        int result = menuRepository.removeMenu(con, menuCode);

        // 수행 결과에 따라서 Commit, Rollback 정해야 한다.
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        System.out.println("[MenuService] deleteMenu() : End ===> ");


    }
}
