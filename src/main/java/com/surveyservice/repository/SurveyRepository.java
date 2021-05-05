package com.surveyservice.repository;




import java.time.LocalDateTime;
import java.util.List;

import com.surveyservice.model.Survey;

/**
 * Defines the persistence methods for a SurveyRepository.
 */
public interface SurveyRepository {
    /**
     * Returns the survey data .
     *
     * @param experiment        experiment for which data is retrieved.
     * @param site     site for which data is retrieved.
     * @return          The requested Survey detail if found.
     */
    Survey findById(String experiment,String site);
    
    boolean update(Survey survey,String experiment,String site);
    
    Survey save(Survey survey,String experiment,String site);
    
    
    List<Survey> getSurveys();

    

    
}
