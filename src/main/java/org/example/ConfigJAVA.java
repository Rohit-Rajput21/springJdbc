package org.example;

import org.StudentDao.StudentDao;
import org.StudentDao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ConfigJAVA {
    @Bean(name={"ds"})
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    @Bean(name ={"jdbcTemplate"})
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
    @Bean(name={"studentDao"})
    public StudentDao getStudentDao(){
        StudentDaoImpl studentDao=new StudentDaoImpl();
        studentDao.setJdbcTemplate(getTemplate());
        return studentDao;
    }
}
