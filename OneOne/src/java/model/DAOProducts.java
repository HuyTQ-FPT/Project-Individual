package model;

import com.oracle.jrockit.jfr.DataType;
import entity.Employees;
import entity.Orders;
import entity.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Alternative;
import javax.naming.spi.DirStateFactory;

/**
 *a=10
 * @author Admin//"values"+a+""
 */
public class DAOProducts extends ConnectDB{
    
    int size_page=24;
    public int addProducts(Products pro) {
        int n = 0;
        String sql = "Insert into Products values(?,?,?,?,?,?,?,?,?,?)";
          try {
            //System.out.println(sql);
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitsInStock());
            pre.setInt(7, pro.getUnitsOnOrder());
            pre.setInt(8, pro.getReorderLevel());
            pre.setInt(9, pro.getDiscontinued());
            pre.setString(10, pro.getimage());
                //run
                n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int changeQuantity(int id, int unitInStock) {
        int n = 0;
        String sql = "update Products set where UnitsInStock=? ProductID=? ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, unitInStock);
            pre.setInt(2, id);
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public int removeProduct(int id){
        int n=0;
        String sql = "delete from Products where ProductID=? ";
        //check constrain = String sql=" viet SQL vao"
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
        public int updateProduct(Products pro) {
        int n = 0;
//        String sql="update Categories set CategoryName='"+cate.getCategoryName()+"',"
//                "Description='"+cate.getDescription()+"',Picture='"+cate.getPicture()+
//                        "'where CategoryID=";
        String sqlPre = "update Products set " +
"ProductName=?," +
"SupplierID=?," +
"CategoryID=?," +
"QuantityPerUnit=?," +
"UnitPrice=?," +
"UnitsInStock=?," +
"UnitsOnOrder=?," +
"ReorderLevel=?," +
"Discontinued=?,[image]=? where ProductID=?";
        try {

            PreparedStatement pre = conn.prepareStatement(sqlPre);
            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getSupplierID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitsInStock());
            pre.setInt(7, pro.getUnitsOnOrder());
            pre.setInt(8, pro.getReorderLevel());
            pre.setInt(9, pro.getDiscontinued());
            pre.setString(10, pro.getimage());
            pre.setInt(11, pro.getProductID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
        public int updateQuantity(Products pro) {
        int n = 0;
        String sqlPre = "update Products set UnitsInStock=? where ProductID=?";
        try {

            PreparedStatement pre = conn.prepareStatement(sqlPre);
            pre.setInt(1, pro.getUnitsInStock());
            pre.setInt(2, pro.getProductID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public Vector<Products> searchByPrice(double from, double to) {
        Vector<Products> vector = new Vector<Products>();
        String sql = "select * from Products where UnitPrice between " + from + " and "
                + to;
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) { //rs.next beforefirst / after last data ở giữa
//                rs.getDataType(DataType,index);
                int pID = rs.getInt("ProductID");
                String pname = rs.getString(2);//rs.getString("ProductName");
                int subid = rs.getInt(3);
                int cateID = rs.getInt(4);
                String QuantityPerUnit = rs.getString(5);
                int UnitPrice = rs.getInt(6);
                int UnitsInStock = rs.getInt(7);
                int UnitsOnOrder = rs.getInt(8);
                int ReorderLevel = rs.getInt(9);
                int Discontinued = rs.getInt(10);
                String img=rs.getString(11);
                  Products pro = new Products(pID, pname, subid, cateID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public Vector<Products> listAllProduct(String name){
        String sql="select * from Products where ProductName like N'%" + name + "%'";
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= state.executeQuery(sql);
          while(rs.next()){ //rs.next beforefirst / after last data ở giữa
//                rs.getDataType(DataType,index);
                  int pID=rs.getInt("ProductID");
                  String pname=rs.getString(2);//rs.getString("ProductName");
                  int subid=rs.getInt(3);
                  int cateID=rs.getInt(4);
                  String QuantityPerUnit=rs.getString(5);
                  int UnitPrice=rs.getInt(6);
                  int UnitsInStock=rs.getInt(7);
                  int UnitsOnOrder=rs.getInt(8);
                  int ReorderLevel=rs.getInt(9);
                  int Discontinued=rs.getInt(10);
                  String img=rs.getString(11);
                  Products pro = new Products(pID, pname, subid, cateID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                  vector.add(pro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return vector;
    }
    public Vector<Products> PageProduct_1(){
        String sql="select top("+size_page+")* from Products";
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= state.executeQuery(sql);
          while(rs.next()){ //rs.next beforefirst / after last data ở giữa
//                rs.getDataType(DataType,index);
                  int pID=rs.getInt("ProductID");
                  String pname=rs.getString(2);//rs.getString("ProductName");
                  int subid=rs.getInt(3);
                  int cateID=rs.getInt(4);
                  String QuantityPerUnit=rs.getString(5);
                  int UnitPrice=rs.getInt(6);
                  int UnitsInStock=rs.getInt(7);
                  int UnitsOnOrder=rs.getInt(8);
                  int ReorderLevel=rs.getInt(9);
                  int Discontinued=rs.getInt(10);
                  String img=rs.getString(11);
                  Products pro = new Products(pID, pname, subid, cateID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                  vector.add(pro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return vector;
    }     
    public Vector<Products> PageProductSort_Home_MaxtoMin(){
        String sql="with t as (select top("+size_page+")* from Products order by UnitPrice desc) \n" +
"select top("+size_page+")* from t order by UnitPrice asc;";
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= state.executeQuery(sql);
          while(rs.next()){ //rs.next beforefirst / after last data ở giữa
//                rs.getDataType(DataType,index);
                  int pID=rs.getInt("ProductID");
                  String pname=rs.getString(2);//rs.getString("ProductName");
                  int subid=rs.getInt(3);
                  int cateID=rs.getInt(4);
                  String QuantityPerUnit=rs.getString(5);
                  int UnitPrice=rs.getInt(6);
                  int UnitsInStock=rs.getInt(7);
                  int UnitsOnOrder=rs.getInt(8);
                  int ReorderLevel=rs.getInt(9);
                  int Discontinued=rs.getInt(10);
                  String img=rs.getString(11);
                  Products pro = new Products(pID, pname, subid, cateID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                  vector.add(pro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return vector;
    }     
    public Vector<Products> PageProductSort_Home_MintoMax(){
        String sql="with t as (select top("+size_page+")* from Products order by UnitPrice asc) \n" +
"select top("+size_page+")* from t order by UnitPrice desc;";
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= state.executeQuery(sql);
          while(rs.next()){ //rs.next beforefirst / after last data ở giữa
//                rs.getDataType(DataType,index);
                  int pID=rs.getInt("ProductID");
                  String pname=rs.getString(2);//rs.getString("ProductName");
                  int subid=rs.getInt(3);
                  int cateID=rs.getInt(4);
                  String QuantityPerUnit=rs.getString(5);
                  int UnitPrice=rs.getInt(6);
                  int UnitsInStock=rs.getInt(7);
                  int UnitsOnOrder=rs.getInt(8);
                  int ReorderLevel=rs.getInt(9);
                  int Discontinued=rs.getInt(10);
                  String img=rs.getString(11);
                  Products pro = new Products(pID, pname, subid, cateID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                  vector.add(pro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return vector;
    }     
    public Vector<Products> PageProduct(String numberPage){
        int temp=Integer.parseInt(numberPage);
        
        int start=(size_page*(temp-1));
        int end=size_page*temp;
        String sql="select * from Products where ProductID>"+start+" and ProductID<="+end;
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= state.executeQuery(sql);
          while(rs.next()){ //rs.next beforefirst / after last data ở giữa
//                rs.getDataType(DataType,index);
                  int pID=rs.getInt("ProductID");
                  String pname=rs.getString(2);//rs.getString("ProductName");
                  int subid=rs.getInt(3);
                  int cateID=rs.getInt(4);
                  String QuantityPerUnit=rs.getString(5);
                  int UnitPrice=rs.getInt(6);
                  int UnitsInStock=rs.getInt(7);
                  int UnitsOnOrder=rs.getInt(8);
                  int ReorderLevel=rs.getInt(9);
                  int Discontinued=rs.getInt(10);
                  String img=rs.getString(11);
                  Products pro = new Products(pID, pname, subid, cateID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                  vector.add(pro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return vector;
    }   
    public Vector<Products> PageProductSortMax_Min(String numberPage){
        DAOProducts dao=new DAOProducts();
        Vector<Products> vector1 = dao.listAllProduct("");
        int temp=Integer.parseInt(numberPage);
        int end=0;
        int start=0;
        if(vector1.size()-(size_page*(temp-1))>=size_page){
            end=size_page*temp;
            start=size_page;
        }
        else{
            start =vector1.size()-(size_page*(temp-1));
            end=vector1.size();
        }
        String sql="with t as (select top("+end+")* from Products order by UnitPrice desc) \n" +
"select top("+start+")* from t order by UnitPrice asc;";
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= state.executeQuery(sql);
          while(rs.next()){ //rs.next beforefirst / after last data ở giữa
//                rs.getDataType(DataType,index);
                  int pID=rs.getInt("ProductID");
                  String pname=rs.getString(2);//rs.getString("ProductName");
                  int subid=rs.getInt(3);
                  int cateID=rs.getInt(4);
                  String QuantityPerUnit=rs.getString(5);
                  int UnitPrice=rs.getInt(6);
                  int UnitsInStock=rs.getInt(7);
                  int UnitsOnOrder=rs.getInt(8);
                  int ReorderLevel=rs.getInt(9);
                  int Discontinued=rs.getInt(10);
                  String img=rs.getString(11);
                  Products pro = new Products(pID, pname, subid, cateID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                  vector.add(pro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return vector;
    }   
    public Vector<Products> PageProductSortMin_Max(String numberPage){
        DAOProducts dao=new DAOProducts();
        Vector<Products> vector1 = dao.listAllProduct("");
        System.out.println(vector1.size()+" la sixe");
        int temp=Integer.parseInt(numberPage);
        int end=0;
        int start=0;
        if(vector1.size()-(size_page*(temp-1))>=size_page){
            end=size_page*temp;
            start=size_page;
        }
        else{
            start =vector1.size()-(size_page*(temp-1));
            end=vector1.size();
        }
        String sql="with t as (select top("+end+")* from Products order by UnitPrice asc) \n" +
"select top("+start+")* from t order by UnitPrice desc;";
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= state.executeQuery(sql);
          while(rs.next()){ //rs.next beforefirst / after last data ở giữa
//                rs.getDataType(DataType,index);
                  int pID=rs.getInt("ProductID");
                  String pname=rs.getString(2);//rs.getString("ProductName");
                  int subid=rs.getInt(3);
                  int cateID=rs.getInt(4);
                  String QuantityPerUnit=rs.getString(5);
                  int UnitPrice=rs.getInt(6);
                  int UnitsInStock=rs.getInt(7);
                  int UnitsOnOrder=rs.getInt(8);
                  int ReorderLevel=rs.getInt(9);
                  int Discontinued=rs.getInt(10);
                  String img=rs.getString(11);
                  Products pro = new Products(pID, pname, subid, cateID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                  vector.add(pro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return vector;
    }      
        public Vector<Products> Search_Products_By_Name(String name) {
        Vector<Products> vector = new Vector<Products>();
        String sql = "select * from Products where ProductName='" + name+"'";       
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {                
                int ProductID = rs.getInt(1);
                String ProductName = rs.getString(2);
                int SupplierID = rs.getInt(3);
                int CategoryID = rs.getInt(4);
                String QuantityPerUnit = rs.getString(5);
                double UnitPrice = rs.getDouble(6);
                int UnitsInStock = rs.getInt(7);
                int UnitsOnOrder = rs.getInt(8);
                int ReorderLevel = rs.getInt(9);
                int Discontinued = rs.getInt(10);
                String img=rs.getString(11);
                  Products pro = new Products(ProductID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,img);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;

    }

    public static void main(String[] args) {
        DAOProducts dao = new DAOProducts();
//        int n = dao.addProducts(
//                new Products("thung",4,4,"PRj103",4,4,4,4,0));
//        if (n > 0) {
//            System.out.println("inserted");
//        } else {
//            System.out.println("NO");
//        }
dao.removeProduct(2);
        Vector<Products> vector = dao.listAllProduct("chai123");
//        for (Products o : vector) {
//            System.out.println(o);
//        }
//            dao.updateProduct(new Products(1, "chai1", 1, 3, "ke", 4, 5, 5, 6, 1));
//        Vector<Products> vector = new Vector<Products>();
//        vector = dao.Search_Products_By_Name("chai");
//        for (Products p : vector) {
//            System.out.println(p);
//        }
    }

   
}