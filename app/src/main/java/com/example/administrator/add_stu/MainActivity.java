package com.example.administrator.add_stu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.Serializable;
import java.util.ArrayList;
import android.widget.Toast;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText inputname;
    private EditText inputage;
    private EditText inputmajor;

    private Button handup;
    private Button addinfo;

    public static String stuinfo = "stuinfo";
    public static  String passstuinfo = "passstuinfo";

    ArrayList<Student> studentList=new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handup=(Button) findViewById(R.id.handup);
        addinfo=(Button) findViewById(R.id.addinfo);

        inputname=(EditText)findViewById(R.id.inputname);
        inputage=(EditText)findViewById(R.id.inputage);
        inputmajor=(EditText)findViewById(R.id.inputmajor);

        handup.setOnClickListener(this);
        addinfo.setOnClickListener(this);

        textChange tc1=new textChange();
        inputname.addTextChangedListener(tc1);
        inputmajor.addTextChangedListener(tc1);
        inputage.addTextChangedListener(tc1);

    }
class textChange implements TextWatcher{
    @Override
    public void afterTextChanged(Editable arg0) {
    }
    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                  int arg3) {
    }
    @Override
    public void onTextChanged(CharSequence cs, int start, int before,
                              int count) {
        boolean Sign1 = inputname.getText().length() > 0;
        boolean Sign2 = inputmajor.getText().length() > 0;
        boolean Sign3 = inputage.getText().length() > 0;
        if (Sign1 & Sign2 & Sign3) {
            addinfo.setText("李怿欣的添加");
            addinfo.setEnabled(true);
        } else {
            addinfo.setText("李怿欣的请输入");
            addinfo.setEnabled(false);
        }
    }
}
    public void onClick(View view){
        final Intent intend=new Intent();
         String name=inputname.getText().toString();
         String age=inputage.getText().toString();
         String major=inputmajor.getText().toString();
        Student stu =new Student(name,age,major);
        stu.setName(name);
        stu.setAge(age);
        stu.setMajor(major);
        switch (view.getId())
        {
            case R.id.addinfo:
                studentList.add(stu);
                inputname.getText().clear();
                inputage.getText().clear();
                inputmajor.getText().clear();
                break;
            case R.id.handup:
                if(studentList.isEmpty()) return;
                Intent intent =new Intent();
                intent.putExtra("students",(Serializable)studentList);
                intent.setClass(MainActivity.this,MainshowinfoActivity.class);
                startActivity(intent);
                break;
        }
    }

}
