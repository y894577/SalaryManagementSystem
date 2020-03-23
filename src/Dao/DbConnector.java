package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private Connection conn;

    private String dbDriver = "com.mysql.cj.jdbc.Driver";

    private String dbUrl = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC";

    private String userName = "root";

    private String psw = "root";

    private UserDao userDao;

    public Connection getConnection() {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("数据库驱动加载成功！");
        try {
            conn = DriverManager.getConnection(dbUrl, userName, psw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("数据库连接成功！");
        return conn;
    }

    public void closeConnection() {

    }

}
