package cn.gdcp.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class EditActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_age;
    private RadioButton rb_btn1;
    private RadioButton rb_btn2;
    private RadioButton rb_btn3;
    private RadioButton rb_btn4;
    private RadioButton rb_btn5;
    private String no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("编辑学生");
        findMyView();
        getViewData();
    }
    //获取页面数据
    private void getViewData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        et_name.setText(name);
        int age = intent.getIntExtra("AGE", 0);
        et_age.setText(String.valueOf(age));
        int imageId = intent.getIntExtra("IMGID", 0);
        no=intent.getStringExtra("NO");
        switch (imageId) {
            case R.drawable.dog1:
                rb_btn1.setChecked(true);
                break;
            case R.drawable.dog2:
                rb_btn2.setChecked(true);
                break;
            case R.drawable.dog3:
                rb_btn3.setChecked(true);
                break;
            case R.drawable.dog4:
                rb_btn4.setChecked(true);
                break;
            case R.drawable.dog5:
                rb_btn5.setChecked(true);
                break;
        }
    }

    //找到页面的控件
    private void findMyView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);

        rb_btn1 = (RadioButton) findViewById(R.id.ab_btn1);
        rb_btn2 = (RadioButton) findViewById(R.id.ab_btn2);
        rb_btn3 = (RadioButton) findViewById(R.id.ab_btn3);
        rb_btn4 = (RadioButton) findViewById(R.id.ab_btn4);
        rb_btn5 = (RadioButton) findViewById(R.id.ab_btn5);
    }

    //编辑点击方法
    public void edit(View v){
        String name=et_name.getText().toString();
        int age=Integer.parseInt(et_age.getText().toString());
        int imageId=R.drawable.dog1;
        if(rb_btn1.isChecked()){
            imageId=R.drawable.dog1;
        }else if(rb_btn2.isChecked()){
            imageId=R.drawable.dog2;
        }else if(rb_btn3.isChecked()){
            imageId=R.drawable.dog3;
        }else if(rb_btn4.isChecked()){
            imageId=R.drawable.dog4;
        }else if(rb_btn5.isChecked()){
            imageId=R.drawable.dog5;
        }
        Intent intent=new Intent();
        intent.putExtra("NAME",name);
        intent.putExtra("AGE",age);
        intent.putExtra("IMAGEID",imageId);
        intent.putExtra("NO",no);
        setResult(2002,intent);
        finish();
    }
}
