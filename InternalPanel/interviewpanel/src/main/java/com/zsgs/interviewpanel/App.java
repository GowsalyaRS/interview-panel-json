package com.zsgs.interviewpanel;

import java.util.Scanner;

import com.zsgs.interviewpanel.database.DataLayer;
import com.zsgs.interviewpanel.interviewer.InterviewerView;
import com.zsgs.interviewpanel.interviewscheduler.InterviewSchedulerView;

public class App 
{
   static
   {
      DataLayer.getInstance().pullHrDataFromJSON();
      DataLayer.getInstance().pullUserDataFromJSON();
   }
   public static void main(String[] args)  
   {
       Scanner scan = new Scanner(System.in);
       InterviewSchedulerView interviews =  new InterviewSchedulerView();
       while(true) 
       { 
         System.out.println("------------------------------------------");     
         System.out.println("1.Interviewer  \n2.Receptionist   \n3.Start Interview \n4.Exit");
         System.out.println("------------------------------------------"); 
         int choose = scan.nextInt();
         switch (choose) 
         {
            case 1: new InterviewerView().init(); break;
            case 2: interviews.init();break;
            case 3: interviews.viewInterviews() ;break;
            case 4: System.exit(0);
            default: System.out.println("Invalid number....");
         }
       }  
   }
}
