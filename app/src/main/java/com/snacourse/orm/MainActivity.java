package com.snacourse.orm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.snacourse.orm.adapter.StudentRecyclerAdapter;
import com.snacourse.orm.da.StudentDA;
import com.snacourse.orm.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

       StudentDA studentDA= StudentDA.getInstance();
        List<Student> studentList= studentDA.getAllStudent();

        StudentRecyclerAdapter studentRecyclerAdapter=new StudentRecyclerAdapter(this,studentList,recyclerView);
        recyclerView.setAdapter(studentRecyclerAdapter);
        studentRecyclerAdapter.notifyDataSetChanged();


        ////////////////////////////
       List<Student>youngStudent= studentDA.getYoungerStudent(30);
        Log.e("young student=",youngStudent.toString());
        /////////////////////////

         List<Student>oldStudent= studentDA.getOlderStudent(30);
        Log.e("old student=",oldStudent.toString());
        /////////////////////////


    }
}
