package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static final String url = "jdbc:mysql://localhost:3306/wangstore?useUnicode=true&characterEncoding=utf-8";
    private static final  String driver = "com.mysql.cj.jdbc.Driver";
    public static final  String userName = "root";
    public static final String password = "042300";
    public static Connection getConnection()throws SQLException
    {
        try {
            Class.forName(driver);
            //System.out.println("数据库连接成功");
            return DriverManager.getConnection(url,userName,password);
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new SQLException();
        }
    }
}
