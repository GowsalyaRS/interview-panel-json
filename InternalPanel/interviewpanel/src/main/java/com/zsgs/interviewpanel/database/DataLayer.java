package com.zsgs.interviewpanel.database;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.zsgs.interviewpanel.model.Candidate;
import com.zsgs.interviewpanel.model.InterviewScheduler;
import com.zsgs.interviewpanel.model.Interviewer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class DataLayer 
{
   static DataLayer db;
   public static DataLayer getInstance()
   {
      if(db == null)
      db = new DataLayer();
      return db;
   }
   private Map <Integer,InterviewScheduler> interviews = new LinkedHashMap<>(); 
   private Map <String,Candidate> candidate =  new HashMap<>();
   private Map <String,Interviewer> hr =  new HashMap<>();
   private ObjectMapper mapper = new ObjectMapper();
   
   public Map<Integer, InterviewScheduler> getInterviews() 
   {
      return interviews;
   }
   public Map<String, Candidate> getCandidate() 
   {
      return candidate;
   }
   public Map <String,Interviewer> getHrDetails()
   {
      return hr;
   }
   public void addInterviewer(Interviewer interviewer) 
   {
      hr.put(interviewer.getEmail(), interviewer);
   }
   public void addInterviews(InterviewScheduler schedle) 
   {
	  int interviewId = interviews.size()+1000;
	  schedle.setInterviewId(interviewId);
      interviews.put(schedle.getInterviewId(),schedle);
   }
   public void addCandidate(Candidate user) 
   {
      candidate.put(user.getEmail(),user);
   }
   
   private String candidateFileName = "/home/gowsalya/Gowsalya/InternalPanel/interviewpanel/src/main/resources/Candidate.txt"; 
	Path filePath = Path.of(candidateFileName);
	public void pushUserDataToJSON() 
	{
		File file = new File(candidateFileName);
		if (file.exists()) 
      {
			try 
         {
				String s = mapper.writeValueAsString(candidate);
				Files.writeString(filePath, s);
			} 
         catch (Exception e ) 
         {
				e.printStackTrace();
			}
		}
	}
	public void pullUserDataFromJSON() 
	{
		File url = new File(candidateFileName);
		if (url.exists()) 
		{
			try 
			{
				candidate.putAll(mapper.readValue(url, new TypeReference<Map<String,Candidate>>(){}));
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.err.println("File not found: " + candidateFileName);
		}
	}
   private String hrFileName = "/home/gowsalya/Gowsalya/InternalPanel/interviewpanel/src/main/resources/Hr.txt"; 
	Path filePath1 = Path.of(hrFileName);
	public void pushHrDataToJSON() 
	{
		File file = new File(hrFileName);
		if (file.exists()) 
      {
			try 
         {
				String s = mapper.writeValueAsString(hr);
				Files.writeString(filePath1, s);
			} 
         catch (Exception e ) 
         {
				e.printStackTrace();
			}
		}
	}
	public void pullHrDataFromJSON() 
	{
		File url = new File(hrFileName);
		if (url.exists()) 
		{
			try 
			{
				hr.putAll(mapper.readValue(url, new TypeReference<Map<String,Interviewer>>(){}));
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.err.println("File not found: " + hrFileName);
		}
	}
   private String interviewsFileName = "/home/gowsalya/Gowsalya/InternalPanel/interviewpanel/src/main/resources/Interview.txt"; 
	Path filePath2 = Path.of(interviewsFileName);
	public void pushInterviewsDataToJSON() 
	{
		File file = new File(interviewsFileName);
		if (file.exists()) 
      {
			try 
         {
				String s = mapper.writeValueAsString(interviews);
				Files.writeString(filePath2, s);
			} 
         catch (Exception e ) 
         {
				e.printStackTrace();
			}
		}
	}
	public void pullInterviewsDataFromJSON() 
	{
		File url = new File(interviewsFileName);
		if (url.exists()) 
		{
			try 
			{
				interviews = mapper.readValue(url, new TypeReference<Map<Integer,InterviewScheduler>>(){});
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.err.println("File not found: " + interviewsFileName);
		}
	}
}
