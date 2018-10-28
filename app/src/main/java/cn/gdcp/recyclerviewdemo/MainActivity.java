package cn.gdcp.recyclerviewdemo;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOnLisener{

    private RecyclerView recyclerView;
    private Button btn_add_stu;
    private ArrayList<Student> studentList=new ArrayList<>();
    private StudentAdater adater;
    private ImageView edit_image;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initStudentData();
        recyclerView=(RecyclerView)findViewById(R.id.re_list);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adater=new StudentAdater(studentList,MainActivity.this);
        recyclerView.setAdapter(adater);
        //初始化添加按钮
        initAddData();
        edit_image=(ImageView)findViewById(R.id.stu_edit);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (resultCode == 2001) {
            String name = data.getStringExtra("NAME");
            int age = data.getIntExtra("AGE", 0);
            int imgId = data.getIntExtra("IMG", R.drawable.dog1);

            Student s = new Student("18006", name, age, imgId);
            studentList.add(s);
            adater.notifyDataSetChanged();
        } else if(resultCode == 2002) {
            String name = data.getStringExtra("NAME");
            int age = data.getIntExtra("AGE", 0);
            int imgId = data.getIntExtra("IMAGEID", R.drawable.dog1);
            String no = data.getStringExtra("NO");

            for (int i = 0; i < studentList.size(); i++) {
                Student s = studentList.get(i);

                if (s.getNo().equals(no)) {
                    s.setName(name);
                    s.setAge(age);
                    s.setImgId(imgId);
                    adater.notifyDataSetChanged();
                }
            }
        }

        }

    private void initAddData() {
        btn_add_stu=(Button)findViewById(R.id.btn_add);
        btn_add_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                        AddManiActivity.class);
                startActivityForResult(intent, 1001);
            }
        });
    }

    private void initStudentData() {
        Student s1=new Student("10001","张一",17,R.drawable.dog1);
        Student s2=new Student("10002","张二",18,R.drawable.dog2);
        Student s3=new Student("10003","张三",19,R.drawable.dog3);
        Student s4=new Student("10004","张四",20,R.drawable.dog4);
        Student s5=new Student("10005","张五",21,R.drawable.dog5);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
    }

    @Override
    public void delete(int i) {
        studentList.remove(i);
    }

    @Override
    public void edit(int i) {
        Intent intent=new Intent(this,EditActivity.class);
        Student s=studentList.get(i);
        intent.putExtra("NAME", s.getName());
        intent.putExtra("AGE", s.getAge());
        intent.putExtra("IMGID",s.getImgId());
        intent.putExtra("NO", s.getNo());
        startActivityForResult(intent, 1002);
    }


}
