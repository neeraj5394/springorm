package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.omg.CORBA.INTERNAL;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {

    public HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    //save 1 student;
    @Transactional
    public int insert(Student student) {
        Integer integer = (Integer) this.hibernateTemplate.save(student);
        return integer;
    }

    //get single student data
    public Student getStudent(int id)
    {
        Student student = this.hibernateTemplate.get(Student.class, id);
        return student;
    }

    //get all students
    public List<Student> getAll ()
    {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }


    //delete
    @Transactional
    public  void delete(int studentId)
    {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(student);
    }

    @Transactional
    public void updateStudent(Student student)
    {
        this.hibernateTemplate.update(student);
    }

}
