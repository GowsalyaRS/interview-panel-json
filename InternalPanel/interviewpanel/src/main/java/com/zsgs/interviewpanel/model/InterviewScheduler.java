package com.zsgs.interviewpanel.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class InterviewScheduler
{
    private int interviewId;
    private static int count =1000;
    private String teamName;
    private String roleOfExam;
    private Interviewer interviewer;
    private Map<String,Candidate> candidates = new HashMap<>();
    private Queue <Candidate> interviewPerson = new LinkedList<>();
    private boolean isCompleted;
    public InterviewScheduler()
    {
    }
    public InterviewScheduler(int interviewId, String teamName, String roleOfExam, Interviewer interviewer,
            Map<String, Candidate> candidates, Queue<Candidate> interviewPerson, boolean isCompleted) {
        this.interviewId = interviewId;
        this.teamName = teamName;
        this.roleOfExam = roleOfExam;
        this.interviewer = interviewer;
        this.candidates = candidates;
        this.interviewPerson = interviewPerson;
        this.isCompleted = isCompleted;
    }
    public InterviewScheduler( String teamName, String roleOfExam,Interviewer interviewer) 
    {
        interviewId = count++;
        this.teamName = teamName;
        this.roleOfExam = roleOfExam;
        this.interviewer = interviewer;
    }
    public int getInterviewId() {
        return interviewId;
    }
    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        InterviewScheduler.count = count;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getRoleOfExam() {
        return roleOfExam;
    }
    public void setRoleOfExam(String roleOfExam) {
        this.roleOfExam = roleOfExam;
    }
    public Interviewer getInterviewer() {
        return interviewer;
    }
    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }
    public Map<String, Candidate> getCandidates() {
        return candidates;
    }
    public void setCandidates(Map<String, Candidate>candidates) {
        this.candidates = candidates;
    }
    public Queue<Candidate> getInterviewPerson() {
        return interviewPerson;
    }
    public void setInterviewPerson(Queue<Candidate> interviewPerson) {
        this.interviewPerson = interviewPerson;
    }
    public void setInterviewPersons(Candidate candidate) {
        interviewPerson.add(candidate);
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    public void setCandidatess(Candidate user) 
    {
       candidates.put(user.getEmail(),user);
    }
    public String toString()
    {
     return    "Interview Id      : " + interviewId +
             "\nTeam name         : " +  teamName +
             "\nRole of Exam      : " + roleOfExam +
             "\nInterviewer       : " + interviewer.getHrName() ;        
    }
   
}
