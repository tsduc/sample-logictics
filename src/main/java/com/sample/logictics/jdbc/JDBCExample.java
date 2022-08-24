package com.sample.logictics.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;

public class JDBCExample {

    static final String DB_URL = "jdbc:mysql://localhost:3306/sample_logictics";
    static final String USER = "root";
    static final String PASS = "123456";



    public static void main(String[] args) {
//		System.out.println("Connecting to a selected database...");
        // Open a connection
//		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
//			System.out.println("Connected database successfully...");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {

            String ten = "banh";
            int soluong = 111;
            int gia = 11111;
            String ngaytao = "2022-07-03";
//        Date ngaytao = new Date(System.currentTimeMillis());


            String sql = "select * from product where ten = '" + ten + "';";

//            sql = "insert product(ten, soluong, gia, ngaytao) values('" + ten + "'," + soluong + "," + gia + ",'" + ngaytao + "');";


            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            int id = stmt.executeUpdate(sql);




            int dem = 0;
            System.out.println(sql);
            while(rs.next()){
                if(rs.getString("ten") != ten){
                    dem++;
                }
            }
            if(dem == 0){
                String sqll = "insert product(ten, soluong, gia, ngaytao) values('" + ten + "'," + soluong + "," + gia + ",'" + ngaytao + "');";
                int id = stmt.executeUpdate(sqll);
            }


//            if(rs.getString("ten") != ten){
//                sql = "insert product(ten, soluong, gia, ngaytao) values('" + ten + "'," + soluong + "," + gia + ",'" + ngaytao + "');";
//            }

//            System.out.println("ID da duoc tao: " + id);

//            System.out.println(9/0);
//			if(conn != null) {
//				System.out.println("Connected database successfully...");
//			}

//            while(rs.next()){
//                System.out.print("ID: " + rs.getInt("id"));
//                System.out.print(", Name: " + rs.getString("name"));
//                String address = rs.getString("street") + ", " + rs.getString("ward") + ", " + rs.getString("district");
//                System.out.println(", Address: " + address);
//            }

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
//		catch (SQLException e) {
//			// TODO: handle exception
//		}

    }

}
