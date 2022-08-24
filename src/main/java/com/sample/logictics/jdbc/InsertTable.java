package com.sample.logictics.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {
    String ten, ngaytao;
    int soluong, gia;
    public InsertTable(){

    }

    public InsertTable(String ten, int soluong, int gia, String ngaytao) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        stmt = conn.createStatement();

        String sqll = "insert product(ten, soluong, gia, ngaytao) values('" + ten + "'," + soluong + "," + gia + ",'" + ngaytao + "');";
        int id = stmt.executeUpdate(sqll);
    }
}
