package org.StudentDao;

import org.entites.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        String query="insert into student(id,name,city) values(?,?,?)";
        int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    @Override
    public int change(Student student) {
        String query="update student set name=?,city=? where id=?";
       int r= this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return r;
    }

    @Override
    public int delete(int studentId) {
        String query="delete from student where id=?";
        int result=this.jdbcTemplate.update(query,studentId);
        return result;
    }

    @Override
    public Student getStudent(int studentId) {
    String query="select * from student where id=?";
    // the second way using anonynous class

    Student student=this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student=new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setCity(rs.getString(3));
            return student;
        }
    }, studentId);
    return student;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
