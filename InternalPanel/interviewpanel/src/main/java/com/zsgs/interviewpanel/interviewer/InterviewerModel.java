package com.zsgs.interviewpanel.interviewer;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zsgs.interviewpanel.database.DataLayer;
import com.zsgs.interviewpanel.interviewscheduler.InterviewSchedulerView;
import com.zsgs.interviewpanel.model.Interviewer;

public class InterviewerModel 
{
    private InterviewerView interviewerView;
    public InterviewerModel(InterviewerView interviewerView) 
    {
        interviewerView = interviewerView;
    }
    public void isHrValidation(Interviewer interviewer)
    {
        if(interviewer.getHrName().length()<3 )
        {
           InterviewSchedulerView.alert("Invalid Name !");
           return;
        }
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(interviewer.getEmail());
        if(!matcher.matches())
        {
            InterviewSchedulerView.alert(" email is Invalid");
            return;
        }
        Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");  
        matcher = ptrn.matcher(""+interviewer.getPhoneNo());
        if(!matcher.matches())
        {
            InterviewSchedulerView.alert(" Phone no is Invalid");
            return;
        }
        DataLayer.getInstance().addInterviewer(interviewer);
        DataLayer.getInstance().pushHrDataToJSON();
        InterviewSchedulerView.alert("Hr added successfully!");
        interviewerView.viewInterviewShedule(interviewer);
    }
    public void isValidateInterviewer(String email, String password) 
    {
        Map<String,Interviewer> hr = DataLayer.getInstance().getHrDetails();
        Interviewer interview =  hr.get(email);
        if(interview==null)
        {
            InterviewSchedulerView.alert("Email is Invalid");
        }
        else
        {
            if(interview.getPassword().equals(password))
            {
                new  InterviewerView().viewInterviewShedule(interview);
            }
        }
    }
    
}
