package com.example.truonghuynh.bai4_sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.truonghuynh.bai4_sqlite.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by Truong Huynh on 25/03/2018.
 */

public class DBManager extends SQLiteOpenHelper{
    private final String TAG = "DBManager";
    private static final String DATABASE_NAME="students_manager";
    private static final String TABLE_NAME="students";
    private static final String ID ="id";
    private static final String NAME="name";
    private static final String ADDRESS="address";
    private static final String PHONE_NUMBER="phone";
    private static final String EMAIL="email";
    private static int VERSON = 1;

    private Context context;

    private String SQLQuery="CREATE TABLE " + TABLE_NAME +" (" +
            ID + " integer primary key, "+
            NAME + " TEXT, "+
            EMAIL + " TEXT, "+
            PHONE_NUMBER + " TEXT, "+
            ADDRESS + " TEXT)";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSON);
        this.context=context;
        Log.d(TAG,"DBManage: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG,"onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"onUpdate: ");
    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,student.getmName());
        values.put(ADDRESS,student.getmAddress());
        values.put(PHONE_NUMBER,student.getmPhoneNumber());
        values.put(EMAIL,student.getmEmail());
        db.insert(TABLE_NAME,null, values);
        db.close(); // mo phai dong cho an toan
        Log.d(TAG,"addStudent Successfuly");
    }

    public List<Student> getAllStudent(){
        List<Student> listStudent = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null); //Cursor dung de hung ket qua tra ve
        if (cursor.moveToFirst()){ // phuong thuc nay false la danh sach khong co gi (rong)
            do{
                Student student = new Student();
                student.setmID(cursor.getInt(0));
                student.setmName(cursor.getString(1));
                student.setmEmail(cursor.getString(2));
                student.setmPhoneNumber(cursor.getString(3));
                student.setmAddress(cursor.getString(4));
                listStudent.add(student);

            }while(cursor.moveToNext()); // sau ket qua co it nhat mot ket qua
        }
        db.close();
        return listStudent;
    }
}
