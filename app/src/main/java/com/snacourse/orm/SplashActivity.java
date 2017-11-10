package com.snacourse.orm;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import com.snacourse.orm.da.StudentDA;
import com.snacourse.orm.model.Student;
import com.snacourse.orm.utils.SharedPrefrenceHelper;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);


        startTimer();
    }


  private void   startTimer(){
      new CountDownTimer(3000, 1000) {

          public void onTick(long millisUntilFinished) {

              //here you can have your logic to set text to edittext
          }

          public void onFinish() {
              checkAlreadyLogin();
          }

      }.start();


  }

  private  void goToMainActivity(){
      startActivity(new Intent(SplashActivity.this,MainActivity.class));

  }
private  void insertData(){

    StudentDA studentDA=StudentDA.getInstance();

    Student st1=new Student();
    st1.setStudentId(1l);
    st1.setName("هیوا");
    st1.setAge(22);
    studentDA.saveStudent(st1);


    Student st2=new Student();
    st2.setStudentId(2l);
    st2.setName("ئه وین");
    st2.setAge(29);
    studentDA.saveStudent(st2);

    Student st3=new Student();
    st3.setStudentId(3l);
    st3.setName("ریبوار");
    st3.setAge(32);
    studentDA.saveStudent(st3);


    Student st4=new Student();
    st4.setStudentId(4l);
    st4.setName("ژینا");
    st4.setAge(35);
    studentDA.saveStudent(st4);





  }



  private void checkAlreadyLogin(){
    boolean alreadyLogin=  SharedPrefrenceHelper.getInstance(this).alreadyLogin();
      if (alreadyLogin){
goToMainActivity();
      }
      else {
          insertData();
          SharedPrefrenceHelper.getInstance(this).Login();
          goToMainActivity();

      }
  }
}
