package com.snacourse.orm.model;

import com.orm.SugarRecord;

/**
 * Created by Sh-Java on 11/8/2017.
 */

public class Student extends SugarRecord<Student> {

    private long studentId;
    private String name;
    private int age;

    public Student() {

    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id="+studentId+'\n'+
        "name="+name+'\n'+
        "age="+age+'\n';
    }
}
