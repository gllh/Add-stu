package com.example.administrator.add_stu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainshowinfoActivity extends AppCompatActivity {
    private TextView showinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainshowinfo);

        Intent intent=getIntent();
        showinfo=(TextView)findViewById(R.id.showinfo);
        Bundle bundle=intent.getExtras();
        ArrayList<Student> studentsinfo =(ArrayList<Student>) bundle.get("students");
        if(!bundle.isEmpty())
            for (Student s : studentsinfo) {
                String stuInfo = "姓名：" + s.getName() + "年龄：" + s.getAge() + "专业：" + s.getMajor()+'\n';
                showinfo.append(stuInfo);

        }
    }
}
