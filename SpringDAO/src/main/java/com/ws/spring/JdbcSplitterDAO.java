package com.ws.spring;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by laowang on 16-10-15.
 */
public class JdbcSplitterDAO  {
    private SimpleJdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    String SQL_SELECT_SPITTER = "select * from user_info by id";
   public Spitter getSpitterbyId(int id){
       return jdbcTemplate.queryForObject(
               SQL_SELECT_SPITTER,
               new ParameterizedRowMapper<Spitter>() {
                   public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
                       Spitter spitter = new Spitter();
                       spitter.setId(resultSet.getInt(1));
                       spitter.setUsername(resultSet.getString(2));
                       spitter.setPassword(resultSet.getString(3));
                       spitter.setFullName(resultSet.getString(4));
                       return spitter;
                   }
               },
               id
       );
   }
}
