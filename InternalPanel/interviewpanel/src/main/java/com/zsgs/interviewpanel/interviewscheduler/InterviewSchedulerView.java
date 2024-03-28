package com.zsgs.interviewpanel.interviewscheduler;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import com.zsgs.interviewpanel.model.Candidate;
import com.zsgs.interviewpanel.model.InterviewScheduler;
import com.zsgs.interviewpanel.model.Interviewer;

public class InterviewSchedulerView 
{
    static Scanner scan = new Scanner(System.in);
    private InterviewSchedulerModel interviewModel;
    public InterviewSchedulerView()
    {
        interviewModel = new InterviewSchedulerModel(this);
    }
    public void init() 
    {
        System.out.println("Enter the username");
        String username = scan.nextLine();
        System.out.println("Enter the password");
        String password = scan.nextLine();
        interviewModel.validateUser(username,password);
    }
    public void onSuccess()  
    {
        System.out.println(".....Successful Login.....");
        new InterviewSchedulerView().init(scan);      
    }
    public static void alert(String msg)
    {
        System.out.println(msg);
    }
    public void init(Scanner scan)  
    {
        while(true)
        {
           System.out.println("------------------------------------------"); 
           System.out.println("1.View Candidate & add Candidate \n2.view Candidate   \n3.view Hr  \n4.Exit" ); 
           System.out.println("------------------------------------------"); 
           int num = scan.nextInt();
            switch(num)
            {
                case 1: listAllInterview();break;
                case 2: viewCanditate();break;
                case 3: viewHr();break;
                case 4: return ;
                default : System.out.println("Invalid number...!");
            }
        }
    }
    public void viewHr() 
    {
        Map <String,Interviewer> data =interviewModel.getInterviewerDetails();
        System.out.println("-----------------------------");
        for(Map.Entry <String,Interviewer> hr : data.entrySet())
        {
           System.out.println(hr);
           System.out.println("------------------------------");
        }
    }
   
    public void viewCanditate() 
    {
        Map <String,Candidate> candi =  interviewModel.getCandidate();
        System.out.println("===========================================");
        for(Entry<String, Candidate> data : candi.entrySet())
        {
            System.out.println(data.getValue());
            System.out.println("===========================================");
        }
    }
    public void listAllInterview() 
    {
        Map<Integer,InterviewScheduler> interviews =  interviewModel.listAllInterview();
        System.out.println("----------------------------------");
        for(Map.Entry <Integer,InterviewScheduler> data :interviews.entrySet())
        {
           System.out.println(data.getValue());
           System.out.println("----------------------------------");
        }
        interviewModel.checkInterview() ;
    }
    public void allowcateExam(Interviewer interviewer) 
    {
        System.out.println("Enter team name ");  
        String teamName = scan.nextLine();
        System.out.println("Enter the Role of Exam");
        String roleOfExam = scan.nextLine();
        InterviewScheduler schedle  = new InterviewScheduler(teamName, roleOfExam, interviewer);
        interviewModel.validateInterview(schedle);
    }
    public int findInterview() 
    {
        System.out.println("Enter the Interview Id ");
        int interviewId = scan.nextInt();
        return interviewId;
    }
    public void viewInterviews() 
    {
        Map<Integer,InterviewScheduler> interview = interviewModel.getInterviews();
        for(Map.Entry<Integer,InterviewScheduler> data : interview.entrySet())
        {
            if(!data.getValue().isCompleted())
            {
               System.out.println(data.getValue());
               System.out.println("-------------------------------------");
            }
        }
        System.out.println("Are you ready? then, start press 1");
        int ch = scan.nextInt();
        switch(ch)
        {
           case 1 : startInterview(interview); break;
           default : System.out.println("It's wrong option");
        }
        
    }
    public void startInterview(Map<Integer, InterviewScheduler> interview) 
    {
        System.out.println("Enter the interview Id ");
        int interviewId = scan.nextInt();
        interviewModel.checkInterviewId(interviewId,interview);
    }
    public int isSelecdCanditate() 
    {
        System.out.println("Is Selected ? Enter 1");
        int num = scan.nextInt();
        return num;
    }
    public void selectCandidate(InterviewScheduler interview) 
    {
        System.out.println("Press 1...view selected candidate result");
        int num = scan.nextInt();
        if(num==1)
        {
            List<Candidate> user = interviewModel.selectCandidateList(interview);
            System.out.println("------------------------------");
            for(Candidate candidate : user)
            {
                System.out.println(candidate);
                System.out.println("------------------------------");
            } 
       }
    }
}
