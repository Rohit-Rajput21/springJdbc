package org.StudentDao;

import org.entites.Student;

public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
}