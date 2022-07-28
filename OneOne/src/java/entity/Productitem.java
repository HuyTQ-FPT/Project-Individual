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
public class Productitem {
    int ProductID;
    String ProductName;
    int Quantity;
    Double Price;
    String image;
    String username;
    String password;
    String admin;
    public Productitem() {
    }

    

    public Productitem(int ProductID, String ProductName, int Quantity, Double Price, String image, String username, String password) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
        this.image = image;
        this.username = username;
        this.password = password;
    }
    
    public Productitem(int ProductID, String ProductName, int Quantity, Double Price, String image) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
        this.image = image;
    }
    

    public Productitem(int ProductID, String ProductName, int Quantity, Double Price) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public Productitem(int ProductID, String ProductName, int Quantity, Double Price, String username, String password) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
        this.username = username;
        this.password = password;
    }
    
    

    public int getProductID() {
        return ProductID;
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

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
