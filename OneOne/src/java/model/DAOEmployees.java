/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Categories;
import entity.Customers;
import entity.Employees;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class DAOEmployees extends ConnectDB {

    public int addEmployees(Employees emp) {
        int n = 0;

        String sql = "insert into Employees(LastName, FirstName, Title, TitleOfCourtesy"
                + ", BirthDate, HireDate, Address, City, Region, "
                + "PostalCode, Country,HomePhone, Extension, Notes, "
                + "ReportsTo, PhotoPath)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            //Create Prepare Statement
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, emp.getLastName());
            pre.setString(2, emp.getFirtName());
            pre.setString(3, emp.getTitle());
            pre.setString(4, emp.getTitleOfCourtesy());
            pre.setString(5, emp.getBirthDate());
            pre.setString(6, emp.getHireDate());
            pre.setString(7, emp.getAddress());
            pre.setString(8, emp.getCity());
            pre.setString(9, emp.getRegion());
            pre.setString(10, emp.getPostaCode());
            pre.setString(11, emp.getCountry());
            pre.setString(12, emp.getHomePhone());
            pre.setString(13, emp.getExtension());
            pre.setString(14, emp.getNotes());
            pre.setInt(15, emp.getReportsTo());
            pre.setString(16, emp.getPhotoPath());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateEmployee(Employees empl) {
        int n = 0;
//        String sql="update Categories set CategoryName='"+cate.getCategoryName()+"',"
//                "Description='"+cate.getDescription()+"',Picture='"+cate.getPicture()+
//                        "'where CategoryID=";
        String sqlPre = "update Employees set LastName=?, FirstName=?, Title=?, TitleOfCourtesy=?"
                + ",BirthDate=?, HireDate=?, Address=?, City=?, Region=?,"
                + "PostalCode=?, Country=?,HomePhone=?, Extension=?, Notes=?,"
                + "ReportsTo=?, PhotoPath=? where EmployeeID=?";
       try {

            PreparedStatement pre = conn.prepareStatement(sqlPre);

            pre.setString(1, empl.getLastName());
            pre.setString(2, empl.getFirtName());
            pre.setString(3, empl.getTitle());
            pre.setString(4, empl.getTitleOfCourtesy());
            pre.setString(5, empl.getBirthDate());
            pre.setString(6, empl.getHireDate());
            pre.setString(7, empl.getAddress());
            pre.setString(8, empl.getCity());
            pre.setString(9, empl.getRegion());
            pre.setString(10, empl.getPostaCode());
            pre.setString(11, empl.getCountry());
            pre.setString(12, empl.getHomePhone());
            pre.setString(13, empl.getExtension());
            pre.setString(14, empl.getNotes());
            pre.setInt(15, empl.getReportsTo());
            pre.setString(16, empl.getPhotoPath());
            pre.setInt(17, empl.getEmployeeID());

//            pre.execute(); creat,drop,alter
//            pre.executeQuery():select
//             pre.executeUpdate(); insert update, delete
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    //Delete

    public int DeleEmployee(int id) {
        int n = 0;
        String sql = "delete from Employees where EmployeeID=" + id;

        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    //Select list all
    public Vector<Employees> listAllEmployee() {
                Vector<Employees> vector = new Vector<Employees>();

        String sql = "select * from Employees";

        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int empID = rs.getInt("EmployeeID");
                String lastname = rs.getString(2);
                String firstname = rs.getString(3);
                String title = rs.getString(4);
                String TOC = rs.getString(5);
                String birthDate = rs.getString(6);
                String hireDate = rs.getString(7);
                String address = rs.getString(8);
                String city = rs.getString(9);
                String region = rs.getString(10);
                String postalCode = rs.getString(11);
                String country = rs.getString(12);
                String homePhone = rs.getString(13);
                String extension = rs.getString(14);
                String photo = rs.getString(15);
                String notes = rs.getString(16);
                int reportsTo = rs.getInt(17);
                String photoPath = rs.getString(18);

                Employees emp = new Employees(empID, lastname, firstname, title, TOC, birthDate,
                        hireDate, address, city, region, postalCode, country, homePhone,
                        extension, photo, notes, reportsTo, photoPath);

                vector.add(emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOEmployees dao = new DAOEmployees();
        int n = 0;
//         n = dao.addEmployees(
//                new Employees("David", "DemoA", "Sales Manager", "Mr", 
//            "1999-01-01", "2021", "Hai duong", "Hai duong", "WA", 
//            "99201", "VN", "123", "1234", "Photo", "Notes", 2, "ee")
//        );
//         n = dao.DeleEmployee(10);
         n = dao.updateEmployee(
                new Employees(1, "way rooney", "UpdateA", "Sales Manager", "Mr",
                        "1999-01-01", "2021", "Hai Duong", "Bac ", "WA",
                        "99201", "VN", "21412", "1234", "Photo", "Notes", 4, "de")
        );
//        dao.listAllEmployee();

    }

}
