/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class OrderList {
    private int OrderID;
    private String CompanyName;
    private String  LastName;
    private String  FirtName;
    private String OrderDate;
    private int status;
    private String ShippedDate;
    public OrderList() {
    }

    public OrderList(int OrderID, String CompanyName, String LastName, String FirtName, String OrderDate, String ShippedDate) {
        this.OrderID = OrderID;
        this.CompanyName = CompanyName;
        this.LastName = LastName;
        this.FirtName = FirtName;
        this.OrderDate = OrderDate;
        this.ShippedDate = ShippedDate;
    }
    public OrderList(int OrderID) {
        this.OrderID = OrderID;
    }

    public OrderList(int OrderID, String CompanyName, String LastName, String FirtName, String OrderDate, int status, String ShippedDate) {
        this.OrderID = OrderID;
        this.CompanyName = CompanyName;
        this.LastName = LastName;
        this.FirtName = FirtName;
        this.OrderDate = OrderDate;
        this.status = status;
        this.ShippedDate = ShippedDate;
    }
    

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirtName() {
        return FirtName;
    }

    public void setFirtName(String FirtName) {
        this.FirtName = FirtName;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(String ShippedDate) {
        this.ShippedDate = ShippedDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    
}
