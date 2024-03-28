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

![Interview_1](https://github.com/GowsalyaRS/interview-panel-json/assets/137131987/21e7be0f-9bc8-4377-8c5a-4a838f6253b5)
![Interview_2](https://github.com/GowsalyaRS/interview-panel-json/assets/137131987/be5b998f-1716-4ef9-9011-f3085b633480)
![Interview_3](https://github.com/GowsalyaRS/interview-panel-json/assets/137131987/4d39d7cb-c88d-4f74-984c-5d47c79a4280)
![Interview_4](https://github.com/GowsalyaRS/interview-panel-json/assets/137131987/81689815-6141-43dc-8ac9-7b115709440c)
![Interview_5](https://github.com/GowsalyaRS/interview-panel-json/assets/137131987/f19029fa-5d1d-4a50-a7cf-8b479ca16a59)



