package com.surveyservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.surveyservice.model.Survey;
import com.surveyservice.repository.SurveyRepository;

@Service
public class SurveyServiceImpl implements SurveyService { 

    private static final Logger logger = LogManager.getLogger(SurveyServiceImpl.class);

    private final SurveyRepository surveyRepository;
    
 

    public SurveyServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    /** my method **/
    public Survey getSurveyDetails(String city,String country,LocalDateTime now) {
        logger.log(Level.INFO, "getSurveyDetails START");

        return null; 

    }
    
    @Override
    public List<Survey> getSurveys() {
        logger.log(Level.INFO, "getSurveys START");
        return surveyRepository.getSurveys();
    }
    
    @Override
    public boolean createSurvey(Survey survey) {
        surveyRepository.createSurvey(survey);
        return true;
    }
    

    
}
