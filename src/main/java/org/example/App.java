package org.example;

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
        JdbcTemplate jdbcTemplate =context.getBean("jdbcTemplate", JdbcTemplate.class);
        String query="insert into student(id,name,city) values(?,?,?)";
        int result= jdbcTemplate.update(query,112,"Manish1 ","Indore");
        System.out.println("Rows affected...."+result);
    }
}
