package org.example;

import org.StudentDao.StudentDao;
import org.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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

        // update into table
//        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//        Student student=new Student();
//        student.setId(112);
//        student.setName("Golu");
//        student.setCity("pamgaon");
//        int result= studentDao.change(student);
//        System.out.println("inserted rows....."+result);

        // delete from table
//        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//        int result=studentDao.delete(121);
//        System.out.println("Deleted rows ......"+result);

   //     StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
    //    Student student=studentDao.getStudent(113);
    //    System.out.println(student);

        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
        List<Student> students=studentDao.getAllStudentS();
        for (Student s:students) {
            System.out.println(s);

        }
    }
}
