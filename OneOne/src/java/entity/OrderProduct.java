/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class OrderProduct {
    private int ProductID;
    private String ProductName;
    private double Quantity;
    private double UnitPrice;
    private int OrderID;
    private int status;
    private String CompanyName;
    private String  LastName;
    private String  FirtName;
    private Date OrderDate;
    private Date ShippedDate;

    public OrderProduct() {
    }

    public OrderProduct(int ProductID, String ProductName, double Quantity, double UnitPrice, int OrderID, String CompanyName, String LastName, String FirtName, Date OrderDate, Date ShippedDate) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
        this.OrderID = OrderID;
        this.CompanyName = CompanyName;
        this.LastName = LastName;
        this.FirtName = FirtName;
        this.OrderDate = OrderDate;
        this.ShippedDate = ShippedDate;
    }

    public OrderProduct(int ProductID, String ProductName, double Quantity, double UnitPrice, int OrderID, int status, String CompanyName, String LastName, String FirtName, Date OrderDate, Date ShippedDate) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
        this.OrderID = OrderID;
        this.status = status;
        this.CompanyName = CompanyName;
        this.LastName = LastName;
        this.FirtName = FirtName;
        this.OrderDate = OrderDate;
        this.ShippedDate = ShippedDate;
    }
    

    public int getProductID() {
        return ProductID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
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

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Date getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(Date ShippedDate) {
        this.ShippedDate = ShippedDate;
    }
    

    

}
