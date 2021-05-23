package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.WeakHashMap;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Config.xml");
        StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag)
        {
            System.out.println("********************** WELCOME TO SPRING ORM PROJECT ********************");
            System.out.println("PRESS 1 TO ADD STUDENT");
            System.out.println("PRESS 2 TO GET SINGLE STUDENT DETAIL");
            System.out.println("PRESS 3 TO GET ALL STUDENTS DETAIL");
            System.out.println("PRESS 4 TO UPDATE THE STUDENT DETAIL");
            System.out.println("PRESS 5 TO DELETE A STUDENT");
            System.out.println("PRESS 6 TO EXIT THE PROGRAM");

            try {
                int option = Integer.parseInt(br.readLine());
                switch (option){
                    case 1:
                        System.out.println("Enter user id:");
                        int uid = Integer.parseInt(br.readLine());
                        System.out.println("Enter user name");
                        String uname = br.readLine();
                        System.out.println("Enter user city");
                        String ucity = br.readLine();
                        Student student = new Student(uid, uname, ucity);
                        int r = studentDao.insert(student);
                        System.out.println(r + " is added");
                        break;
                    case 2:
                        System.out.println("Enter user id to get details");
                        int userId = Integer.parseInt(br.readLine());
                        student = studentDao.getStudent(userId);
                        System.out.println(student);
                        break;
                    case 3:
                        List<Student> students = studentDao.getAll();
                        for (Student s: students) {
                            System.out.println(s);
                        }
                        break;
                    case 4:

                        break;
                    case 5:
                        break;
                    case 6:
                        flag=false;
                        break;
                    default:
                }
            }catch (Exception e){
                System.out.println("Invalid input");
                System.out.println(e.getMessage());
            }
        }


        //                        insert entry into table
//        Student student = new Student(20, "Rajdeep", "Bharuch");
//        int r = studentDao.insert(student);
//        System.out.println(r);

        //get student from table
//        Student singleStudent = studentDao.getStudent(20);
//        System.out.println(singleStudent);

        //get all students
//        List<Student> students = studentDao.getAll();
//        for(Student student: students)
//        {
//            System.out.println(student);
//        }

        //delete single student
//        studentDao.delete(20);
    }

}
