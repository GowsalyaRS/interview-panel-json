package com.zsgs.interviewpanel.candidate;

import java.util.Map;
import java.util.Scanner;

import com.zsgs.interviewpanel.database.DataLayer;
import com.zsgs.interviewpanel.model.Candidate;
import com.zsgs.interviewpanel.model.InterviewScheduler;

public class CandidateView 
{
    private CandidateModel candidateModel;
    private static Scanner scan = new Scanner(System.in);
    public CandidateView()
    {
        candidateModel = new CandidateModel(this);
    }
    public void addCandidate(InterviewScheduler in) 
    {
        System.out.println("Enter the email");
        String email= scan.nextLine();
        Map <String,Candidate> candidate  = DataLayer.getInstance().getCandidate();
        Candidate user = candidate.get(email);
        candidateModel.getCondidate(user,in);
    }
    public void getCandidate(InterviewScheduler in) 
    {
        System.out.println("Enter the name ");
        String name = scan.nextLine();
        System.out.println("Enter the email "); 
        String email = scan.nextLine();
        System.out.println("Enter the phone no"); 
        long phoneNo = scan.nextLong();
        scan.nextLine();
        System.out.println("Enter the Location ");
        String location = scan.nextLine();
        System.out.println("Enter the degree");
        String degree = scan.nextLine();
        Candidate user = new Candidate(name,email,phoneNo,location,degree);
        candidateModel.validateCandidate(in,user);
    }
}
