package com.zsgs.interviewpanel.model;

public class Interviewer 
{
    private String hrName;
    private String email;
    private long phoneNo;
    private String password;
    public Interviewer()
    {
    }
    public Interviewer(String hrName, String email, long phoneNo, String password) 
    {
        this.hrName = hrName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }
    public String getHrName() {
        return hrName;
    }
    public void setHrName(String hrName) {
        this.hrName = hrName;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }  
    public String toString()
    {
        return "HR Name      : " + hrName +
             "\nEmail        : " + email +
             "\nPhone No     : " + phoneNo;
    }
}
