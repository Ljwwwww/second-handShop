package com.example.demo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class BaseDao {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    Connection conn = null;
    public PreparedStatement pstmt = null;
    public ResultSet rs = null;

    static {
        init();
    }

    /**
     * 初始化连接参数,从配置文件里获得
     */
    public static void init() {
        Properties params = new Properties();
        String configFile = "database.properties";//配置文件路径
        //加载配置文件到输入流中
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configFile);

        try {
            //从输入流中读取属性列表
            params.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //根据指定的获取对应的值
        driver = params.getProperty("driver");
        url = params.getProperty("url");
        user = params.getProperty("user");
        password = params.getProperty("password");
    }

    /**
     * 获取数据库连接对象。
     */
    public Connection getConnection() {
        if (conn == null) {
            // 获取连接并捕获异常
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();// 异常处理
            }


        }
        return conn;// 返回连接对象
    }

    /**
     * 关闭数据库连接。
     *
     * @param conn 数据库连接
     * @param stmt Statement对象
     * @param rs   结果集
     */
    //关闭数据库
    public void closeAll() {
        try {
            if (null != rs)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //查
    public ResultSet executeQuery(String sql, Object... params) {
        try {
            pstmt = getConnection().prepareStatement(sql);
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeQueryCount(String sql, Object... params) {
        int count = 0;
        try {
            pstmt = getConnection().prepareStatement(sql);
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            System.out.println(pstmt);
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    //增删改
    public int executeUpdate(String sql, Object... params) {
        try {
            pstmt = getConnection().prepareStatement(sql);
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            System.out.println(pstmt);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //模糊查询
    public ResultSet executeSearch(String sql, Object... params) {

        ResultSet rs = null;
        try {
            pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, "%" + params[i] + "%");
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }

}
