package com.zsgs.interviewpanel.interviewscheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import com.zsgs.interviewpanel.candidate.CandidateView;
import com.zsgs.interviewpanel.database.DataLayer;
import com.zsgs.interviewpanel.model.Candidate;
import com.zsgs.interviewpanel.model.InterviewScheduler;
import com.zsgs.interviewpanel.model.Interviewer;

public class InterviewSchedulerModel 
{
    static
    {
        DataLayer.getInstance().pullInterviewsDataFromJSON();
    }
    private InterviewSchedulerView interviewView;
    DataLayer db;
    public InterviewSchedulerModel(InterviewSchedulerView examSchedulerView) 
    {
        db = DataLayer.getInstance();
       this.interviewView =  examSchedulerView;
    }
    public void validateUser(String username, String password) 
    {
        if(username.equals("zsgs"))
        {
            if(password.equals("zoho"))
            {
                interviewView.onSuccess();
            }
            else
            {
                InterviewSchedulerView.alert("Wrong password!");
            }
        }
        else
        {
            interviewView.alert("Wrong username!");
        }
    }
    public Map<Integer,InterviewScheduler> listAllInterview() 
    {
        return DataLayer.getInstance().getInterviews();
    }
    public void checkInterview() 
    {
        if(!db.getInterviews().isEmpty()) 
        {
            Map<Integer,InterviewScheduler> interviews = DataLayer.getInstance().getInterviews();
            int interviewId = interviewView.findInterview(); 
            InterviewScheduler in = interviews.get(interviewId);
            if(in!=null)
            {
                InterviewSchedulerView.alert("Do you want add canditate?");
                int num = interviewView.isSelecdCanditate();
                if(num==1)
                new CandidateView().addCandidate(in);
            }
            else
            {
                InterviewSchedulerView.alert(" Interview Not Available RightNow this interview id ");
            } 
        }
        else
        {
            InterviewSchedulerView.alert(" Interview Not Available RightNow ");
        }    
    }
   
    public void validateInterview(InterviewScheduler schedle) 
    {
       if(schedle.getTeamName().length()<4) 
       { 
          InterviewSchedulerView.alert("Wrong Team name!");
          return;
       }
       if(schedle.getRoleOfExam().length()<4)
       {
           InterviewSchedulerView.alert("Wrong Exam role !");
           return;
       }
       DataLayer.getInstance().addInterviews(schedle);
       DataLayer.getInstance().pushInterviewsDataToJSON();
       InterviewSchedulerView.alert("Interview added successfully!");
    }
    public  Map <String,Candidate> getCandidate() 
    {
        Map <String,Candidate> candi =  DataLayer.getInstance().getCandidate();
        return candi;
    }
    public Map<Integer,InterviewScheduler> getInterviews() 
    {
        return  DataLayer.getInstance().getInterviews();
    }
    public void checkInterviewId(int interviewId, Map<Integer, InterviewScheduler> interview) 
    {
        if(interview.get(interviewId)!=null)
        {
           Queue <Candidate> inter = interview.get(interviewId).getInterviewPerson();
            if(inter.isEmpty())
            {
                InterviewSchedulerView.alert("No canditate in exam");
            }
            else
            {
               startInterview(interview.get(interviewId),inter);
            }
        }
        else
        {
            InterviewSchedulerView.alert("Interview Id is Invalid!");
        }
    }
    public void startInterview(InterviewScheduler interview, Queue<Candidate> inter) 
    {
            while(inter.peek()!=null)
            {
                Candidate can =inter.peek();
                System.out.println("--------------------------");
                System.out.println(can);
                System.out.println("--------------------------");
                int num = interviewView.isSelecdCanditate();
                if(num==1) 
                {
                   interview.getCandidates().get(can.getEmail()).setSeleced(true);
                   can.setSeleced(true);
                }
                inter.poll();
            }
        
        interview.setCompleted(true);
        InterviewSchedulerView.alert("Interview is finished! ");
        DataLayer.getInstance().pushInterviewsDataToJSON();
        interviewView.selectCandidate(interview);
    }
    public List<Candidate> selectCandidateList(InterviewScheduler interview) 
    {
        Map<String,Candidate> candidates = interview.getCandidates();
        List <Candidate> selectPerson = new ArrayList<>();
        for(Map.Entry <String,Candidate> candidate:candidates.entrySet()) 
        {
            Candidate user = candidate.getValue();
            if(user.getSeleced())
            {
                selectPerson.add(user);
            }
        }
        return selectPerson;
    }
    public Map<String,Interviewer> getInterviewerDetails() 
    {
        return DataLayer.getInstance().getHrDetails();
    }
}
