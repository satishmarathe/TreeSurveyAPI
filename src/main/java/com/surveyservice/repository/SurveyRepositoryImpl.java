package com.surveyservice.repository;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.surveyservice.model.Survey;

@Repository
public class SurveyRepositoryImpl implements SurveyRepository {

    private static final Logger logger = LogManager.getLogger(SurveyRepositoryImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public SurveyRepositoryImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;

        // Build a SimpleJdbcInsert object from the specified data source
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
            .withTableName("survey_data")
            .usingGeneratedKeyColumns("id");
    }

    @Override
    public Survey findById(String city,String country) {
        try {
            Survey survey = jdbcTemplate.queryForObject("SELECT * FROM survey_data WHERE experiment = ? and site = ?",
                new Object[]{city,country},
                (rs, rowNum) -> {
                    Survey w = new Survey();
                    w.setTreeId(rs.getString("tree_id"));
                    return w;
                });
            return survey;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }



    public List<Survey> getSurveys() {
        logger.log(Level.INFO, "getSurveys START");
        return jdbcTemplate.query("select tm.tree_id,tm.location_id ,tm.plant_date ,tm.species ,tm.treatment ,s.inspection_date ,"
            + "s.health_score ,s.pathogen_count ,s.woodborer_count ,s.notes \r\n" + 
            "from tree_survey.tree_master tm,tree_survey.survey s\r\n" + 
            "where tm.tree_id = s.tree_id;",
            (rs, rowNumber) -> {
                logger.log(Level.INFO, "got something");
                Survey survey = new Survey();
                survey.setTreeId(rs.getString("tree_id"));
                survey.setLocation(rs.getString("location_id"));
                survey.setPlantDate(rs.getDate("plant_date"));
                survey.setSpecies(rs.getString("species"));
                survey.setTreatment(rs.getString("treatment"));
                survey.setInspectionDate(rs.getDate("inspection_date"));
                survey.setHealthScore(rs.getInt("health_score"));
                survey.setPathogenFound(rs.getInt("pathogen_count"));
                survey.setWoodBorerFound(rs.getInt("woodborer_count"));
                survey.setNotes(rs.getString("notes"));
                
                
                
                logger.log(Level.INFO, "details from db {}",survey);
                return survey;
            });
    }



    @Override
    public boolean update(Survey survey,String experiment,String site) {
        return false;
    }

    @Override
    public boolean createSurvey(Survey survey) {
        logger.log(Level.INFO, "createSurvey START");
        logger.log(Level.INFO, "createSurvey pojo = {}",survey);
       int response =  jdbcTemplate.update(
            "INSERT INTO tree_master VALUES (?, ?, ?, ?,?)", survey.getTreeId(),survey.getLocation(), survey.getPlantDate(),
            survey.getSpecies(),survey.getTreatment());
       
       logger.log(Level.INFO, "after db insert result = {}",response);
       
       if(response == 1) {
           response = jdbcTemplate.update(
               "INSERT INTO survey VALUES (?, ?, ?, ?,?,?)", survey.getTreeId(),survey.getInspectionDate(), survey.getHealthScore(),
               survey.getPathogenFound(),survey.getWoodBorerFound(),survey.getNotes());
       }
       return true;
    }   
    
}
