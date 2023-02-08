package org.example;

import org.StudentDao.StudentDao;
import org.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        System.out.println( "Hello World!" );
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
//        JdbcTemplate jdbcTemplate =context.getBean("jdbcTemplate", JdbcTemplate.class);
//        String query="insert into student(id,name,city) values(?,?,?)";
//        int result= jdbcTemplate.update(query,112,"Manish1 ","Indore");
//        System.out.println("Rows affected...."+result);

        // 2-nd way to insert into table
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        Student student=new Student();
        student.setId(131);
        student.setName("Monika");
        student.setCity("Nas");
        int result= studentDao.insert(student);
        System.out.println("inserted rows....."+result);

    }
}
