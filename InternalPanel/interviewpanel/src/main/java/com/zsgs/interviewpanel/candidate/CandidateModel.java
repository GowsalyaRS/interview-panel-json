package com.zsgs.interviewpanel.candidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zsgs.interviewpanel.database.DataLayer;
import com.zsgs.interviewpanel.interviewscheduler.InterviewSchedulerView;
import com.zsgs.interviewpanel.model.Candidate;
import com.zsgs.interviewpanel.model.InterviewScheduler;

public class CandidateModel 
{
    private CandidateView candidateView;
    public CandidateModel(CandidateView candidateView) 
    {
        this.candidateView = candidateView;  
    }
    public void getCondidate(Candidate user, InterviewScheduler in) 
    {
        if(user!=null)
        {
            in.setCandidatess(user);
            in.setInterviewPersons(user);
            DataLayer.getInstance().pushInterviewsDataToJSON();
            InterviewSchedulerView.alert(" Candidate added successfully In Exam ");
        }
        else
        {
            System.out.println("New Candidate! Enter the Personal Details");
            candidateView.getCandidate(in);
        }
    }
    public void validateCandidate(InterviewScheduler in, Candidate user) 
    {
        if(user.getName().length()<4)
        {
            InterviewSchedulerView.alert("Canditate name Invalid"); 
            return;
        }
        if(user.getLocation().length()<4)
        {
            InterviewSchedulerView.alert("Location is  Invalid!"); 
            return;
        }
        if( user.getDegree().length()<2 )
        {
            InterviewSchedulerView.alert("Degree is Invalid! "); 
            return;
        }
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(user.getEmail());
        if(!matcher.matches())
        {
            InterviewSchedulerView.alert(" email is Invalid");
            return;
        }
        Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");  
        matcher = ptrn.matcher(""+user.getPhoneNo());
        if(!matcher.matches())
        {
            InterviewSchedulerView.alert(" Phone no is Invalid");
            return;
        }
        DataLayer.getInstance().addCandidate(user);
        DataLayer.getInstance().pushUserDataToJSON();
        getCondidate(user,in);
    }
}
