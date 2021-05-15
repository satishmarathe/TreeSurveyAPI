package com.surveyservice.web;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surveyservice.model.Survey;
import com.surveyservice.service.SurveyService;

@RestController
public class SurveyController {

    private static final Logger logger = LogManager.getLogger(SurveyController.class);

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }	

    @CrossOrigin   
    @GetMapping("/api/v1/surveys")
    public ResponseEntity<?>  getSurveyDetails() {
        ResponseEntity<?> responseEntity = null;
        try {
            logger.log(Level.INFO, "getSurveyDetails START:");

            List<Survey> surveyList = surveyService.getSurveys();
            
            if(surveyList != null && surveyList.size() > 0) {
                logger.log(Level.INFO, "we got something:");
                responseEntity= ResponseEntity.status(200).body(surveyList);
            }else {
                logger.log(Level.INFO, "we got nothing!");
                   
            }
            return responseEntity;
        }catch(Exception e) {
            logger.log(Level.ERROR, "System Exception contact administrator ");
            return null;
        }
    }
    
    /**
     * this will be used to create a survey
     * @return
     */
    @CrossOrigin   
    @PostMapping("/api/v1/surveys")
    public ResponseEntity<?>  createSurvey(@RequestBody Survey survey) {
        ResponseEntity<?> responseEntity = null;
        
        surveyService.createSurvey(survey);
        return responseEntity;        
    }
    
    /**
     * this will be used to update a survey
     * @return
     */
    @CrossOrigin   
    @PutMapping("/api/v1/surveys")
    public ResponseEntity<?>  updateSurvey() {
        ResponseEntity<?> responseEntity = null;
        return responseEntity;        
    }
    
    /**
     * this will be used to update a survey
     * @return
     */
    @CrossOrigin   
    @DeleteMapping("/api/v1/surveys")
    public ResponseEntity<?>  deleteSurvey() {
        ResponseEntity<?> responseEntity = null;
        return responseEntity;        
    }
        

   
    

    
}
