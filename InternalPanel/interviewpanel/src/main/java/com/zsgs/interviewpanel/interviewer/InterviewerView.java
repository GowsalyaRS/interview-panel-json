package com.zsgs.interviewpanel.interviewer;

import java.util.Scanner;

import com.zsgs.interviewpanel.interviewscheduler.InterviewSchedulerView;
import com.zsgs.interviewpanel.model.Interviewer;

public class InterviewerView 
{
    private InterviewerModel interviewerModel;
    private static Scanner scan = new Scanner(System.in);
    public InterviewerView ()
    {
        interviewerModel = new InterviewerModel(this);
    }
    public void init() 
    {
        while(true) 
        { 
            System.out.println("------------------------------------------"); 
            System.out.println("1.Signin  \n2.Signup \n3.Back");
            System.out.println("------------------------------------------"); 
            int num = scan.nextInt();
            switch(num) 
            {
                case 1:scan.nextLine();sininProcess();break;
                case 2:scan.nextLine();sinupProcess();break;
                case 3:return;
                default : System.out.println("Enter the correct option");
            }
        }
    }
    public void sininProcess() 
    {
       System.out.println("Enter the HR name ");
       String name = scan.nextLine();
       System.out.println("Enter the email"); 
       String email = scan.nextLine();
       System.out.println("Enter the PhoneNo");
       long phoneNo = scan.nextLong();
       scan.nextLine();
       System.out.println("Enter the password");
       String password = scan.nextLine();
       Interviewer interviewer = new Interviewer(name, email, phoneNo, password);
       interviewerModel.isHrValidation(interviewer);
    }
    public void sinupProcess() 
    {
       System.out.println("Enter the email"); 
       String email = scan.nextLine();
       System.out.println("Enter the password");
       String password = scan.nextLine();
       interviewerModel.isValidateInterviewer(email,password);
    }
    public static void viewInterviewShedule(Interviewer interviewer) 
    {
        System.out.println("you create interviews y/n ");
        char ch = scan.next().charAt(0);
        switch (ch) 
        {
           case 'y' : new InterviewSchedulerView().allowcateExam(interviewer);break;
           case 'n' : System.out.println("Ok! Thank you ");break;
           default  : viewInterviewShedule(interviewer);
        }
    }
}
