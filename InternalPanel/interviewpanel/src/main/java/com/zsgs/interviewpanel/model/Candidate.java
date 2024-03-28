package com.zsgs.interviewpanel.model;
public class Candidate
{
    private String name;
    private String email;
    private long phoneNo;
    private String location;
    private String degree;
    private boolean seleced;
    public Candidate()
    {
    }
    public Candidate(String name, String email, long phoneNo, String location, String degree) 
    {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.location = location;
        this.degree = degree;
    }
    public boolean getSeleced() {
        return seleced;
    }
    public void setSeleced(boolean seleced) {
        this.seleced = seleced;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String toString()
    {
        return  "Name     :  " + name +
               "\nEmail    :  " + email +
               "\nPhone No :  " + phoneNo +
               "\nDegree   :  " + degree +
               "\nLocation :  " + location ;
    }
}