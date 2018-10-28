package cn.gdcp.recyclerviewdemo;

import java.io.Serializable;

/**
 * Created by acer on 2018/10/24.
 */

public class Student implements Serializable {
    private String no;
    private String name;
    private int age;
    private int imgId;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
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

    public Student(String no, String name, int age, int imgId) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", imgId=" + imgId +
                '}';
    }
}
