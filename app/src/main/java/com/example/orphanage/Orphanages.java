package com.example.orphanage;

public class Orphanages {
    int OrphanageID,OrphansCount;
    String OrphanageName,City,PhoneNumber, OrphanageManager,Address,Email,AccountNo,IFSCCode,Password,PicturePath,Location;

    public Orphanages(int orphanageID,String orphanageName,String orphanageManager, int orphansCount,String address,String city,String phoneNumber,String email, String accountNo, String IFSCCode, String password, String picturePath, String location) {
        this.OrphanageID = orphanageID;
        this.PhoneNumber = phoneNumber;
        this.OrphanageName = orphanageName;
        this.City = city;
        this.OrphanageManager = orphanageManager;
        this.Address = address;
        this.Email = email;
        this.AccountNo = accountNo;
        this.IFSCCode = IFSCCode;
        this.Password = password;
        this.PicturePath = picturePath;
        this.Location = location;
        this.OrphansCount = orphansCount;
    }

    public Orphanages(){

    }



    public int getOrphanageID() {
        return OrphanageID;
    }

    public void setOrphanageID(int orphanageID) {
        OrphanageID = orphanageID;
    }

    public int getOrphansCount() {
        return OrphansCount;
    }

    public void setOrphansCount(int orphansCount) {
        OrphansCount = orphansCount;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getOrphanageName() {
        return OrphanageName;
    }

    public void setOrphanageName(String orphanageName) {
        OrphanageName = orphanageName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getOrphanageManager() {
        return OrphanageManager;
    }

    public void setOrphanageManager(String orphanageManager) {
        OrphanageManager = orphanageManager;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String accountNo) {
        AccountNo = accountNo;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPicturePath() {
        return PicturePath;
    }

    public void setPicturePath(String picturePath) {
        PicturePath = picturePath;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
