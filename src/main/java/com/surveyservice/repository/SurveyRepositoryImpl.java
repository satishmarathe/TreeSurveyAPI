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
                    w.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());

                    return w;
                });
            return survey;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }



    public List<Survey> getSurveys() {
        logger.log(Level.INFO, "getSurveys START");
        return jdbcTemplate.query("SELECT * FROM survey_data",
            (rs, rowNumber) -> {
                logger.log(Level.INFO, "got something");
                Survey survey = new Survey();
                survey.setTreeId(rs.getString("tree_id"));
                survey.setSpecies(rs.getString("species"));
                logger.log(Level.INFO, "details from db {}",survey);
                return survey;
            });
    }



    @Override
    public boolean update(Survey survey,String experiment,String site) {
        return false;
    }

    @Override
    public Survey save(Survey survey,String experiment,String site) {
        return null;
    }








}
