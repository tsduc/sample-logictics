package com.sample.logictics.jdbc;

import java.sql.*;

public class main {
    static final String DB_URL = "jdbc:mysql://localhost:3306/sample_logictics";
    static final String USER = "root";
    static final String PASS = "123456";



    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        InsertTable insertTable = new InsertTable();
        insertTable.ten = "banhhh";
        insertTable.soluong = 111;
        insertTable.gia = 11111;
        insertTable.ngaytao = "2022-07-03";


        try {
            String sql = "select * from product where ten = '" + insertTable.ten + "';";

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            int id = stmt.executeUpdate(sql);

            int dem = 0;
            System.out.println(sql);
            while(rs.next()){
                if(rs.getString("ten") != insertTable.ten){
                    dem++;
                }
            }
            if(dem == 0){
                String sqll = "insert product(ten, soluong, gia, ngaytao) values('" + insertTable.ten + "'," + insertTable.soluong + "," + insertTable.gia + ",'" + insertTable.ngaytao + "');";
                int id = stmt.executeUpdate(sqll);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
                conn.close();
//                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
