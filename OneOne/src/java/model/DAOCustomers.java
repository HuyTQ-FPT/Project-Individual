package model;

import entity.Customers;
import entity.OrderDetails;
import entity.OrderList;
import entity.OrderProduct;
import entity.Products;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *a=10
 * @author Admin//"values"+a+""
 */
public class DAOCustomers extends ConnectDB{
    
    public int addCustomer(Customers cus) {
        int n = 0;
        String sql = "Insert into Customers"+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
          try {
            //System.out.println(sql);
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerID());
            pre.setString(2, cus.getCompanyName());
            pre.setString(3, cus.getContactName());
            pre.setString(4, cus.getContactTitle());
            pre.setString(5, cus.getAddress());
            pre.setString(6, cus.getCity());
            pre.setString(7, cus.getRegion());
            pre.setString(8, cus.getPostalCode());
            pre.setString(9, cus.getCountry());
            pre.setString(10, cus.getPhone());
            pre.setString(11, cus.getFax());
            pre.setString(12, cus.getUsername());
            pre.setString(13, cus.getPassword());

                //run
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return n;
        }
//    public String checkCus(String CustomerID) {
//        String sql = "SELECT*FROM [SE1613].[dbo].[Customers] where [CustomerID]=?";
//        //Nhận kết quả trả về
//
//        try {
//            PreparedStatement pre = conn.prepareStatement(sql);
//            pre.setString(1, CustomerID);
//
//            ResultSet rs = pre.executeQuery();
//
//            while (rs.next()) {
//                String cus = rs.getString(1);
//
//                return cus;
//
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//
//    }
    public int Register(Customers cus) {
        int n = 0;
        String sql = "insert into Customers(CustomerID,CompanyName,username,[password]) values(?,?,?,?)";       
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerID());
            pre.setString(2, cus.getCompanyName());
            pre.setString(3, cus.getUsername());
            pre.setString(4, cus.getPassword());
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
     public int updateCustomer(Customers cus) {
        int n = 0;
        String sqlPre = "update Customers set CompanyName=?,"
                + "ContactName=?,ContactTitle=?,Address=?,"
                + "City=?,Region=?,PostalCode=?,Country=?,Phone=?,Fax=?,username=?,[password]=? where CustomerID=?";

        try {
            //System.out.println(sql);
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sqlPre);
            pre.setString(1, cus.getCompanyName());
            pre.setString(2, cus.getContactName());
            pre.setString(3, cus.getContactTitle());
            pre.setString(4, cus.getAddress());
            pre.setString(5, cus.getCity());
            pre.setString(6, cus.getRegion());
            pre.setString(7, cus.getPostalCode());
            pre.setString(8, cus.getCountry());
            pre.setString(9, cus.getPhone());
            pre.setString(10, cus.getFax());
            pre.setString(11, cus.getUsername());
            pre.setString(12, cus.getPassword());
            pre.setString(13, cus.getCustomerID());

            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }

    public Vector<Customers> listAllCustomers(String cusid) {
        Vector<Customers> vector = new Vector<Customers>();
        String sql = "select * from Customers where CustomerID like N'%" + cusid + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String cusID = rs.getString("CustomerID");
                String company = rs.getString(2);
                rs.getString("CompanyName");
                String contactName = rs.getString(3);
                rs.getString("ContactName");
                String ContactTitle = rs.getString(4);
                rs.getString("ContactTitle");
                String Address = rs.getString(5);
                rs.getString("Address");
                String city = rs.getString(6);
                rs.getString("City");
                String Region = rs.getString(7);
                rs.getString("Region");
                String RPostalCode = rs.getString(8);
                rs.getString("PostalCode");
                String Country = rs.getString(9);
                rs.getString("Country");
                String Phone = rs.getString(10);
                rs.getString("Phone");
                String Fax = rs.getString(11);
                rs.getString("Fax");
                String user= rs.getString(12);
                String pass = rs.getString(13);
                Customers cus = new Customers(cusID, contactName, contactName, ContactTitle, Address, city, Region, RPostalCode, Country, Phone, Fax,user,pass);
                vector.add(cus);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    public Vector<Customers> Account(String user, String pass) {
        Vector<Customers> vector = new Vector<Customers>();
        String sql = "select * from Customers where username='"+user+"' and password='"+pass+"'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String cusID = rs.getString("CustomerID");
                String company = rs.getString(2);
                rs.getString("CompanyName");
                String contactName = rs.getString(3);
                rs.getString("ContactName");
                String ContactTitle = rs.getString(4);
                rs.getString("ContactTitle");
                String Address = rs.getString(5);
                rs.getString("Address");
                String city = rs.getString(6);
                rs.getString("City");
                String Region = rs.getString(7);
                rs.getString("Region");
                String RPostalCode = rs.getString(8);
                rs.getString("PostalCode");
                String Country = rs.getString(9);
                rs.getString("Country");
                String Phone = rs.getString(10);
                rs.getString("Phone");
                String Fax = rs.getString(11);
                rs.getString("Fax");
                String username =rs.getString(12);
                String password =rs.getString(13);
                Customers cus = new Customers(cusID, contactName, contactName, ContactTitle, Address, city, Region, RPostalCode, Country, Phone, Fax,username,password);
                vector.add(cus);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

  public int DeleteCustomers(String CustomerID) {
        int n = 0;
        String sql = "delete from Customers where CustomerID='" + CustomerID+"'";
          try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public Vector<OrderList> Join_Customer_Vs_Order_OrderItem_Product_Employee(){
        Vector<OrderList> vector = new Vector<>();
        int n=0;
        String sql ="select distinct o.OrderID,c.CompanyName,o.OrderDate,e.LastName,e.FirstName,o.ShippedDate,o.Status from "+
"[Order Details] od join Products p\n" +
"on od.ProductID=p.ProductID right join Orders o\n" +
"on o.OrderID=od.OrderID left join Customers c\n" +
"on o.CustomerID=c.CustomerID left join Employees e\n" +
"on o.EmployeeID=e.EmployeeID";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                String cname = rs.getString(2);
                String orderdate = rs.getString(3);
                String lastname = rs.getString(4);
                String firstname = rs.getString(5);
                String shipdate = rs.getString(6);
                int status = rs.getInt(7);
                vector.add(new OrderList(OrderID, cname, lastname, firstname, orderdate,status, shipdate));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public Vector<OrderList> Join_Customer_Vs_Order_OrderItem_Product_Employee(String from, String to){
        Vector<OrderList> vector = new Vector<>();
        int n=0;
        String sql ="select distinct o.OrderID from "+
"[Order Details] od join Products p\n" +
"on od.ProductID=p.ProductID right join Orders o\n" +
"on o.OrderID=od.OrderID left join Customers c\n" +
"on o.CustomerID=c.CustomerID left join Employees e\n" +
"on o.EmployeeID=e.EmployeeID where o.OrderDate > '"+from+"' and o.OrderDate< '"+to+"'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                vector.add(new OrderList(OrderID));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public Vector<OrderList> Join_Customer_Vs_Order_OrderItem_Product_Employee_by_orderid(int oid){
        Vector<OrderList> vector = new Vector<>();
        int n=0;
        String sql ="select distinct o.OrderID,c.CompanyName,o.OrderDate,e.LastName,e.FirstName,o.ShippedDate,o.Status from "+
"[Order Details] od join Products p\n" +
"on od.ProductID=p.ProductID right join Orders o\n" +
"on o.OrderID=od.OrderID left join Customers c\n" +
"on o.CustomerID=c.CustomerID left join Employees e\n" +
"on o.EmployeeID=e.EmployeeID where o.OrderID="+oid;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                String cname = rs.getString(2);
                String orderdate = rs.getString(3);
                String lastname = rs.getString(4);
                String firstname = rs.getString(5);
                String shipdate = rs.getString(6);
                int status = rs.getInt(7);
                vector.add(new OrderList(OrderID, cname, lastname, firstname, orderdate,status, shipdate));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public Vector<OrderProduct> Join_Customer_Vs_Order_OrderItem_Product_Employee_1(int oid){;
        Vector<OrderProduct>vector = new Vector<>();
        int n=0;
        String sql ="select distinct p.ProductID,p.ProductName,od.Quantity,p.UnitPrice,"+
"o.OrderID,c.CompanyName,o.OrderDate,e.LastName,e.FirstName,o.ShippedDate,o.Status from [Order Details] od join Products p\n" +
"on od.ProductID=p.ProductID join Orders o\n" +
"on o.OrderID=od.OrderID join Customers c\n" +
"on o.CustomerID=c.CustomerID join Employees e\n" +
"on o.EmployeeID=e.EmployeeID where o.OrderID="+oid;
        ResultSet rs1 = getData(sql);
        try {
            while (rs1.next()) {
                int productID = rs1.getInt(1);
                String productname = rs1.getString(2);
                double quantity = rs1.getDouble(3);
                double price = rs1.getDouble(4);
                int orderId=rs1.getInt(5);
                String CompanyName = rs1.getString(6);
                Date OrderDate = rs1.getDate(7);
                String LastName = rs1.getString(8);
                String FirstName = rs1.getString(9);
                Date ShippedDate = rs1.getDate(10);
                int status=rs1.getInt(11);
                vector.add(new OrderProduct(productID, productname, quantity, price, orderId,status, CompanyName, LastName, FirstName, OrderDate, ShippedDate));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOCustomers dao = new DAOCustomers();
        int n=0;
        n= dao.Register(new Customers("Mu2", "bruno fenendes","roseBlackpink", "12345678"));
//           n= dao.DeleteCustomers("huy");
//         n = dao.addCustomer(
//                new Customers("huy1", "2001", "Huy",
//                "Sales Huy", "4311", "london", "3", "2K1", "Viet nam", "23", "123"));
//        n=dao.Join_Customer_Vs_Order_OrderItem_Product_Employee();
        if (n > 0) {
            System.out.println("inserted");
        } else {
            System.out.println("NO");
        }
    }

}