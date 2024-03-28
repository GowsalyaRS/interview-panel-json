  # Interview Panel
  
_____Type of Application_____   : B2C

___Target Audience___           : Interviewe / Receptionist 

___Development time___           : 3 days

____Tech Stack____                : Java 


## Features
 
### Interviewer

1.Sign in  Interviewer(Hr)

2.Sign up  Interviewer(Hr)

3.Schedule Interview

4.Start Interview 

5.Selected Person View

 ### Receptionist

Sign Up (Default username,Password)
Add Candidate in Specific Interview
View Candidate
View Interviewer

  ### Model Classes

#### Interviewer

- Hr Name            -  String
- Email                 -  String
- Phone No      -  Long
- Password       -  String

#### Candidate
         
- Name              - String 
- email             - String
- location            - String  
- Selected          - boolean 
- Phone No        -  Long
- Degree            -  String

 #### Interview Scheduler
        
- Interview  Id            - int 
- Team   Name         - String 
- Role                       - String 
- Hr                           - Interviewer 
- candidate                - Map <String,Candidate>
- Interview queue      - Queue <Candidate> 
- Completed              - boolean  
