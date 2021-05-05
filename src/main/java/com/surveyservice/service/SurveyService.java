package com.surveyservice.service;


import java.time.LocalDateTime;
import java.util.List;

import com.surveyservice.model.Survey;

public interface SurveyService {    
    
    /** my method **/
    Survey getSurveyDetails(String city,String country,LocalDateTime now) ;
    
    public List<Survey> getSurveys();

    
}
