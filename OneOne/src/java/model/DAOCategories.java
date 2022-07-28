package model;

import com.fasterxml.classmate.TypeBindings;
import entity.Categories;
import entity.Customers;
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
public class DAOCategories extends ConnectDB{
    
    
    public int addCategories1(Categories cate) {
        int n = 0;
        String sql = "Insert into Categories"
                + " values('" + cate.getCategoryName() + "','" + cate.getDescription() + "','" 
                + cate.getPicture()+"')";;
               
        try {
            //        create statement: execute sql
            Statement state = conn.createStatement();
            //run
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int addCategories(Categories cate) {
        int n = 0;
        String sql = "insert into Categories(CategoryName,Description)"
                + " values(?,?)";
               
        try {
            //        create statement: execute sql
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, cate.getCategoryName());
            pre.setString(2, cate.getDescription());
//            pre.setString(3, cate.getPicture());
            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
   public int updateCategories(Categories cate) {
        int n = 0;
//        String sql="update Categories set CategoryName='"+cate.getCategoryName()+"',"
//                "Description='"+cate.getDescription()+"',Picture='"+cate.getPicture()+
//                        "'where CategoryID=";
//        
        String sqlPre = "update Categories set CategoryName=?,"
                + "Description=? where CategoryID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sqlPre);
            pre.setString(1, cate.getCategoryName());
            pre.setString(2, cate.getDescription());
//            pre.setString(3, cate.getPicture());
            pre.setInt(3, cate.getCategoryID());
            n = pre.executeUpdate();
//            pre.execute(); creat,drop,alter
//            pre.executeQuery():select
//             pre.executeUpdate(); insert update, delete
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
     public Vector<Categories> listAllCategories(){
                 Vector<Categories> vector = new Vector<Categories>();

        String sql="select * from Categories";
         try {
            Statement state = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);          
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {           
                int ID = rs.getInt("CategoryID");
                String name = rs.getString(2);
                rs.getString("CategoryName");
                String Description= rs.getString(3);
                rs.getString("Description");
                String Picture= rs.getString(3);
                rs.getString("Picture");
                Categories cate = new Categories(ID, name, Description, Picture);
                vector.add(cate);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return vector;
    }
     
       public int DeleteCategories(int CategoryID) {
        int n = 0;
        String sql = "delete from Categories where CategoryID= " + CategoryID;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public static void main(String[] args) {
        DAOCategories dao = new DAOCategories();
        int n=0;
//        n = dao.addCategories1(
//                new Categories("huy","Soft drinks",""));
//          n = dao.DeleteCategories(2);
//        dao.listAllCategories();
        n = dao.updateCategories(
                new Categories(11,"huy111","Huy123","321"));
        if (n > 0) {
            System.out.println("inserted");
        } else {
            System.out.println("NO");
        }
    }
}