package model;

import entity.Employees;
import entity.OrderDetails;
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
public class DAOOrderDetails extends ConnectDB{
    
    
    public int addOrderDetails(OrderDetails orderdetail) {
        int n = 0;
         String sql = "insert into [Order Details] "
                + " values(?,?,?,?,?)";

        try {
            //        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, orderdetail.getOrderID());
            pre.setInt(2, orderdetail.getProductID());
            pre.setDouble(3, orderdetail.getUnitPrice());
            pre.setDouble(4, orderdetail.getQuantity());
            pre.setDouble(5, orderdetail.getDiscount());

            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int addOrderProduct(OrderDetails orderdetail) {
        int n = 0;
         String sql = "insert into [Order Details](OrderID,ProductID,UnitPrice,Quantity) \n" +
"values((select top(1)OrderID from Orders \n" +
"Order by OrderID desc),?,?,?)";

        try {
            //        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, orderdetail.getProductID());
            pre.setDouble(2, orderdetail.getUnitPrice());
            pre.setDouble(3, orderdetail.getQuantity());

            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
     public int updateOrderDetail(OrderDetails orderdetail) {
        int n = 0;
        
        String sqlPre = "update [Order Details] set ProductID=?,"
                + "UnitPrice=?,Quantity=?,Discount=? where OrderID=?";
        try {

            PreparedStatement pre = conn.prepareStatement(sqlPre);

            pre.setInt(1, orderdetail.getProductID());
            pre.setDouble(2, orderdetail.getUnitPrice());
            pre.setDouble(3, orderdetail.getQuantity());
            pre.setInt(4, orderdetail.getDiscount());
            pre.setInt(5, orderdetail.getOrderID());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int DeleteOrderDetail(int id) {
        int n = 0;
        String sql = "delete from [Order Details] where OrderID=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Vector<OrderDetails> listAllOrdersDetail() {
                Vector<OrderDetails> vector = new Vector<OrderDetails>();

        String sql = "select * from [Order Details]";

        try {
            Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = getData(sql);
             while (rs.next()) {
            int OrderID = rs.getInt("OrderID");
            int ProductID = rs.getInt(2);
            double UnitPrice = rs.getDouble(3);
            int Quantity = rs.getInt(4);
            int discount = rs.getInt(5);
            OrderDetails or = new OrderDetails(OrderID, ProductID, UnitPrice, Quantity, discount);
            vector.add(or);
             }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOOrderDetails dao = new DAOOrderDetails();
        int n=0;
//        n = dao.addOrderDetails(
//                new OrderDetails(11084,1,15,15,0));
//        n = dao.updateOrderDetail(new OrderDetails(11084, 18, 1, 1, 1));
//          n = dao.DeleteOrderDetail(11078);
//        Vector<OrderDetails> vector=dao.listAllOrdersDetail();
//        for (OrderDetails od : vector) {
//            System.out.println(od);
//        }
        if (n > 0) {
            System.out.println("inserted");
        } else {
            System.out.println("NO");
        }
    }
}