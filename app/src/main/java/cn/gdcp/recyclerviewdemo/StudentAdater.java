package cn.gdcp.recyclerviewdemo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static cn.gdcp.recyclerviewdemo.StudentAdater.ViewHolder.delete_imageView;
import static cn.gdcp.recyclerviewdemo.StudentAdater.ViewHolder.edit_imageView;

/**
 * Created by acer on 2018/10/25.
 */

public class StudentAdater extends RecyclerView.Adapter<StudentAdater.ViewHolder>{

    private ArrayList<Student> studentList;
    private IOnLisener lisener;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView stuentImage;
        TextView et_name;
        TextView et_age;
        static ImageView delete_imageView;
        static ImageView edit_imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            stuentImage=(ImageView)itemView.findViewById(R.id.stu_image);
            et_name=(TextView)itemView.findViewById(R.id.stu_name);
            et_age=(TextView)itemView.findViewById(R.id.stu_age);
            delete_imageView=(ImageView)itemView.findViewById(R.id.stu_delete);
            edit_imageView=(ImageView)itemView.findViewById(R.id.stu_edit);
        }
    }
    public StudentAdater(ArrayList<Student> studentList,IOnLisener lisener){
        this.studentList=studentList;
        this.lisener=lisener;
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
       final Student s=studentList.get(position);
        holder.stuentImage.setImageResource(s.getImgId());
        holder.et_name.setText(s.getName());
        holder.et_age.setText(String.valueOf(s.getAge()));
       delete_imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               studentList.remove(position);
               notifyDataSetChanged();
           }
       });
        edit_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               lisener.edit(position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return studentList.size();
    }


}
