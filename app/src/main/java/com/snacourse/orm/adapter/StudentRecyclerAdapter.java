package com.snacourse.orm.adapter;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.snacourse.orm.MainActivity;
import com.snacourse.orm.R;
import com.snacourse.orm.model.Student;
import com.snacourse.orm.vh.StudentViewHolder;

import java.util.List;


public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private List<Student> students;
    private MainActivity mContext;
    int heightSize;
    RecyclerView recyclerView;
    public StudentRecyclerAdapter(MainActivity context, List<Student> studentList, RecyclerView recyclerView) {
        this.students = studentList;
        this.mContext = context;
        this.recyclerView=recyclerView;
setListener();
        //Log.e   ("const adapter","");
    }

 /*   @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       // View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, parent, false);



        CustomViewHolder viewHolder = new CustomViewHolder(view,heightSize);
        Log.e   ("CustomViewHolder adapter","");
        return viewHolder;
    }*/
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.st_row, parent, false);


        return new StudentViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final StudentViewHolder viewHolder, final int i) {
        final Student student = students.get(i);
        viewHolder.txtId.setText(student.getStudentId()+"");
        viewHolder.txtName.setText(student.getName());
        viewHolder.txtAge.setText(student.getAge()+"");







    }
    public void setListener(){
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(mContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                  Student st=  students.get(i);

                        Toast.makeText(mContext, st.getStudentId()+"-"+st.getName()+"-"+st.getAge(), Toast.LENGTH_SHORT).show();

                    }
                })
        );


    }

    @Override
    public int getItemCount() {
        return (null != students ? students.size() : 0);

    }


}
