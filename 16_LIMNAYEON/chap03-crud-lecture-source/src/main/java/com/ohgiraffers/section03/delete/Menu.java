package com.ohgiraffers.section02.update;

public class Menu {

    private String menuName;
    private int menuPirce;
    private int categoryCode;
    private String orderbleStatus;
    private int menuCode;

    public Menu( String menuName, int menuPirce, int menuCode) {
        this.menuName = menuName;
        this.menuPirce = menuPirce;
        this.menuCode = menuCode;
    }


    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPirce() {
        return menuPirce;
    }

    public void setMenuPirce(int menuPirce) {
        this.menuPirce = menuPirce;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderbleStatus() {
        return orderbleStatus;
    }

    public void setOrderbleStatus(String orderbleStatus) {
        this.orderbleStatus = orderbleStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                ", menuName='" + menuName + '\'' +
                ", menuPirce=" + menuPirce +
                ", categoryCode=" + categoryCode +
                ", orderbleStatus='" + orderbleStatus + '\'' +
                '}';
    }
}
