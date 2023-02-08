package org.StudentDao;

import org.entites.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        String query="insert into student(id,name,city) values(?,?,?)";
        int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
