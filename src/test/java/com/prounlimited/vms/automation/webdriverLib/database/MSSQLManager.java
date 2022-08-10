package com.prounlimited.vms.automation.webdriverLib.database;

import com.prounlimited.vms.automation.appLib.dataInit.RunSetting;

import java.sql.*;

public class MSSQLManager {

    static Statement sta;
    static ResultSet rs;
    public static ResultSet getResultSetFromMSSQL(String sqlQuery)  {
        Connection con=null;
        try {
            Class.forName(RunSetting.driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            con = DriverManager.getConnection(RunSetting.connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            sta = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs = sta.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rs!=null)
        {
            try {
                rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
}
