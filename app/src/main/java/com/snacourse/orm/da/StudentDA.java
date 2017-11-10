package com.snacourse.orm.da;

import android.content.Context;

import com.orm.query.Condition;
import com.orm.query.Select;
import com.snacourse.orm.model.Student;
import com.snacourse.orm.utils.SharedPrefrenceHelper;

import java.util.List;

/**
 * Created by Sh-Java on 11/8/2017.
 */

public class StudentDA {
private static StudentDA instance;



    private StudentDA(){}

    public static StudentDA getInstance(){
        if(instance == null){
            instance = new StudentDA();
        }
        return instance;
    }








    public void saveStudent(Student student){

        student.save();
    }
    public void deleteStudent(Student student){

        student.delete();
    }
     public void deleteAllStudent(){
        Student.deleteAll(Student.class);
    }


  public List<Student> getAllStudent( ){
      List<Student> students = Student.listAll(Student.class);
      return students;
    }

     public Student returnStudent(long  studentID){
         Student student = Student.findById(Student.class, studentID);
         return student;
     }


     public List<Student> findByNameAndAge(String name,int age){
      List<Student> students=   Student.find(Student.class, "name = ? and age = ?", name, String.valueOf(age));
return students;

     }


    public List<Student> findByName(String name){
        List<Student> students = Student.findWithQuery(Student.class, "Select * from Student where name = ?", name);
        return students;

    }


    private List<Student> queryFilter(String name,int age){

// for finders using raw query.



   List<Student> students= Select.from(Student.class)
            .where(Condition.prop("name").eq(name),
                    Condition.prop("age").eq(age))
            .list();

return students;

}

 private List<Student> queryFilter2(String name,int age){

// for finders using raw query.



   List<Student> students= Select.from(Student.class)
            .where(Condition.prop("name").eq(name),
                    Condition.prop("age").eq(age))
            .list();

return students;

}

private List<Student> getStudentBiggerThan(String name,int age){

// for finders using raw query.



   List<Student> students= Select.from(Student.class)
            .where(Condition.prop("name").eq(name),
                    Condition.prop("age").gt(age))
            .list();

return students;

}

public List<Student> getYoungerStudent(int age){





    List <Student> students=  Select.from(Student.class)
            .where(Condition.prop("age").lt(age)).list();

return students;

}


public List<Student> getOlderStudent(int age){

// for finders using raw query.



    List <Student> students=  Select.from(Student.class)
            .where(Condition.prop("age").gt(age)).list();

return students;

}




}
