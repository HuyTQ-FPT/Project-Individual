package model;

import entity.OrderDetails;
import entity.Orders;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * a=10
 *
 * @author Admin//"values"+a+""
 */
public class DAOOrders extends ConnectDB {

    public int addOrders(Orders or) {
        int n = 0;
        String sql = "insert into Orders "
                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            //        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, or.getCustomerID());
            pre.setInt(2, or.getEmployeeID());
            pre.setString(3, or.getRequiredDate());
            pre.setString(4, or.getShippedDate());
            pre.setString(5, or.getOrderDate());
            pre.setInt(6, or.getShipVia());
            pre.setDouble(7, or.getFreight());
            pre.setString(8, or.getShipName());
            pre.setString(9, or.getShipAddress());
            pre.setString(10, or.getShipCity());
            pre.setString(11, or.getShipRegion());
            pre.setString(12, or.getShipPostalCode());
            pre.setString(13, or.getShipCountry());
            pre.setInt(14, or.getStatus());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int addOrders1(Orders or) {
        int n = 0;
        String sql = "INSERT into Orders ( CustomerID,EmployeeID,OrderDate,RequiredDate,ShippedDate,ShipVia,[Status]) values (?,?,?,?,?,?,?)";
        try {
            //        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, or.getCustomerID());
            pre.setInt(2, or.getEmployeeID());
            pre.setString(3, or.getRequiredDate());
            pre.setString(4, or.getShippedDate());
            pre.setString(5, or.getOrderDate());            
            pre.setInt(6, or.getShipVia());
            pre.setInt(7, or.getStatus());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateOrders(Orders or) {
        int n = 0;
        String sqlPre = "update Orders set CustomerID=?,EmployeeID=? where OrderID=?";

        System.out.println(sqlPre);

        try {
            PreparedStatement pre = conn.prepareStatement(sqlPre);

            pre.setString(1, or.getCustomerID());
            pre.setInt(2, or.getEmployeeID());
            pre.setInt(3, or.getOrderID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int updateStatus(int status, int oid) {
        int n = 0;
        String sqlPre = "update Orders set Status=? where OrderID=?";

        try {
            PreparedStatement pre = conn.prepareStatement(sqlPre);
            pre.setInt(1,status);
            pre.setInt(2, oid);
            //run
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int DeleteOrders(int id) {
        int n = 0;
        String sql = "delete from Orders where OrderID=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<Orders> listAllOrder() {
        Vector<Orders> vector = new Vector<Orders>();
        String sql = "select * from Orders";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int oID = rs.getInt("OrderID");
                String CustomerID = rs.getString(2);
                int EmployeeID = rs.getInt(3);
                String OrderDate = rs.getString(4);
                String RequiredDate = rs.getString(5);
                String ShippedDate = rs.getString(6);
                int ShipVia = rs.getInt(7);
                double F = rs.getDouble(8);
                String ShipName = rs.getString(9);
                String ShipAddress = rs.getString(10);
                String ShipCity = rs.getString(11);
                String ShipRegion = rs.getString(12);
                String ShipPostalCode = rs.getString(13);
                String ShipCountry = rs.getString(14);

                Orders o = new Orders(oID, CustomerID, EmployeeID,
                        OrderDate, RequiredDate, ShippedDate, ShipVia, F, ShipName,
                        ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                System.out.println(o);
                vector.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Orders> Search_Order_By_CustomerID(String customerID) {
        Vector<Orders> vector = new Vector<Orders>();
        String sql = "select * from Orders where CustomerID='" + customerID + "'";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int oID = rs.getInt("OrderID");
                String CustomerID = rs.getString(2);
                int EmployeeID = rs.getInt(3);
                String OrderDate = rs.getString(4);
                String RequiredDate = rs.getString(5);
                String ShippedDate = rs.getString(6);
                int ShipVia = rs.getInt(7);
                double F = rs.getDouble(8);
                String ShipName = rs.getString(9);
                String ShipAddress = rs.getString(10);
                String ShipCity = rs.getString(11);
                String ShipRegion = rs.getString(12);
                String ShipPostalCode = rs.getString(13);
                String ShipCountry = rs.getString(14);
                Orders o = new Orders(oID, CustomerID, EmployeeID,
                        OrderDate, RequiredDate, ShippedDate, ShipVia, F, ShipName,
                        ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                vector.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;

    }

    public static void main(String[] args) {
        DAOOrders dao = new DAOOrders();
        int n = 0;
//        n = dao.addOrders(
//                new Orders("ANTON", 3, "2001", "2001", "2001", 1, 100, "huy", "huy", "huy", "huy", "huy", "huy"));

//        n = dao.updateOrders(
//                new Orders(10248, "VINET", 6, "2002", "2002", "2002", 1, 100, "huy", "huy", "huy", "huy", "huy", "huy"));
//        
//        n = dao.DeleteOrders(11084);
//
//        dao.listAllOrder();
//        
        Vector<Orders> v = new Vector<Orders>();
//        v = dao.Search_Order_By_CustomerID("VINET");
//        for (Orders o : v) {
//            System.out.println(o);
//        }
        dao.updateStatus(2, 10248);

//        if (n > 0) {
//            System.out.println("inserted");
//        } else {
//            System.out.println("NO");
//        }
    }
}
