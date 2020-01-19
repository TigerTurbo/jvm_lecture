package com.yshuoo.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author yangshuo
 * @date 2020/1/17 16:23
 */
public class MyTest27 {

    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytestdb", "username", "password");

    }
}
