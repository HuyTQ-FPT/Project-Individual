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
public class Employees {
    private int EmployeeID; //indentity(1,1)
    private String  LastName;
    private String  FirtName;
    private String  Title;
    private String  TitleOfCourtesy;
    private String  BirthDate;
    private String  HireDate;
    private String  Address;
    private String  City;
    private String  Region;
    private String  PostaCode;
    private String  Country;
    private String  HomePhone;
    private String  Extension;
    private String  Photo;
    private String  Notes;
    private int ReportsTo;
    private String  PhotoPath;

    public Employees() {
    }

    public Employees(int EmployeeID, String LastName, String FirtName, String Title, String TitleOfCourtesy, String BirthDate, String HireDate, String Address, String City, String Region, String PostaCode, String Country, String HomePhone, String Extension, String Photo, String Notes, int ReportsTo, String PhotoPath) {
        this.EmployeeID = EmployeeID;
        this.LastName = LastName;
        this.FirtName = FirtName;
        this.Title = Title;
        this.TitleOfCourtesy = TitleOfCourtesy;
        this.BirthDate = BirthDate;
        this.HireDate = HireDate;
        this.Address = Address;
        this.City = City;
        this.Region = Region;
        this.PostaCode = PostaCode;
        this.Country = Country;
        this.HomePhone = HomePhone;
        this.Extension = Extension;
        this.Photo = Photo;
        this.Notes = Notes;
        this.ReportsTo = ReportsTo;
        this.PhotoPath = PhotoPath;
    }
    

    public Employees(String LastName, String FirtName, String Title, String TitleOfCourtesy, String BirthDate, String HireDate, String Address, String City, String Region, String PostaCode,String Country, String HomePhone, String Extension, String Photo, String Notes, int ReportsTo, String PhotoPath) {
        
        this.LastName = LastName;
        this.FirtName = FirtName;
        this.Title = Title;
        this.TitleOfCourtesy = TitleOfCourtesy;
        this.BirthDate = BirthDate;
        this.HireDate = HireDate;
        this.Address = Address;
        this.City = City;
        this.Region = Region;
        this.PostaCode = PostaCode;
        this.Country = Country;
        this.HomePhone = HomePhone;
        this.Extension = Extension;
        this.Photo = Photo;
        this.Notes = Notes;
        this.ReportsTo = ReportsTo;
        this.PhotoPath = PhotoPath;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getTitleOfCourtesy() {
        return TitleOfCourtesy;
    }

    public void setTitleOfCourtesy(String TitleOfCourtesy) {
        this.TitleOfCourtesy = TitleOfCourtesy;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getHireDate() {
        return HireDate;
    }

    public void setHireDate(String HireDate) {
        this.HireDate = HireDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getPostaCode() {
        return PostaCode;
    }

    public void setPostaCode(String PostaCode) {
        this.PostaCode = PostaCode;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public void setHomePhone(String HomePhone) {
        this.HomePhone = HomePhone;
    }

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String Extension) {
        this.Extension = Extension;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public int getReportsTo() {
        return ReportsTo;
    }

    public void setReportsTo(int ReportsTo) {
        this.ReportsTo = ReportsTo;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public void setPhotoPath(String PhotoPath) {
        this.PhotoPath = PhotoPath;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
    

    @Override
    public String toString() {
        return "Employees{" + "EmployeeID=" + EmployeeID + ", LastName=" + LastName + ", FirtName=" + FirtName + ", Title=" + Title + ", TitleOfCourtesy=" + TitleOfCourtesy + ", BirthDate=" + BirthDate + ", HireDate=" + HireDate + ", Address=" + Address + ", City=" + City + ", Region=" + Region + ", PostaCode=" + PostaCode + ", HomePhone=" + HomePhone + ", Extension=" + Extension + ", Photo=" + Photo + ", Notes=" + Notes + ", ReportsTo=" + ReportsTo + ", PhotoPath=" + PhotoPath + '}';
    }
    
}
