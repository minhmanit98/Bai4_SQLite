package com.example.truonghuynh.bai4_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.truonghuynh.bai4_sqlite.adapter.CustomAdapter;
import com.example.truonghuynh.bai4_sqlite.data.DBManager;
import com.example.truonghuynh.bai4_sqlite.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtAddress;
    private EditText edtPhoneNumber;
    private EditText edtEmail;
    private Button btnSave;
    private ListView lvStudent;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DBManager(this);
        initWidget();
        studentList = dbManager.getAllStudent();

        setAdapter();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = createStudent();
                if (student!=null){
                    // kiem tra de tranh bi loi, mac du khong xay ra
                    dbManager.addStudent(student);
                }
                studentList.clear(); // du lieu la 0 khong phai null
                studentList.addAll(dbManager.getAllStudent());
                setAdapter();
            }
        });
    }

    private Student createStudent(){
        // 3 kieu text sang String pho bien hien nay
        String name = edtName.getText().toString(); // cach 1
        String address = String.valueOf(edtAddress.getText()); // cach 2
        String phoneNumber = edtPhoneNumber.getText() + ""; // cach 3
        String email = edtEmail.getText().toString();
        // dat ten bien model se co chu m o truoc, con o day khong co

        Student student = new Student(name, address,phoneNumber,email);
        return student;
    }

    private void initWidget(){
        edtName = (EditText) findViewById(R.id.edit_name);
        edtAddress = (EditText) findViewById(R.id.edit_address);
        edtPhoneNumber = (EditText) findViewById(R.id.edit_number);
        edtEmail = (EditText) findViewById(R.id.edit_email);
        btnSave = (Button) findViewById(R.id.btn_save);
        lvStudent= (ListView) findViewById(R.id.lv_student);
    }

    private void setAdapter(){
        if(customAdapter==null){
            customAdapter= new CustomAdapter(this,R.layout.item_list_student,studentList);
            lvStudent.setAdapter(customAdapter);
        } else{
            customAdapter.notifyDataSetChanged();
            lvStudent.setSelection(customAdapter.getCount()-1);
        }

    }
}
