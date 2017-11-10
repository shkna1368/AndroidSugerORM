package com.snacourse.orm.vh;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.snacourse.orm.R;


public class StudentViewHolder extends RecyclerView.ViewHolder {




    public TextView txtId ;
    public TextView txtName ;
    public TextView txtAge ;




    public StudentViewHolder(View convertView ) {
        super(convertView);


        this. txtId= (TextView) convertView.findViewById(R.id.textViewId);
        this. txtName=(TextView) convertView.findViewById(R.id.textViewName);
        this. txtAge=(TextView) convertView.findViewById(R.id.textViewAge);




    }
}
