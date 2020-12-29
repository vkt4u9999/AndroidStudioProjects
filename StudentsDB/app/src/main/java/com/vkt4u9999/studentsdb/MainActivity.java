package com.vkt4u9999.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Students.Student;
import Utils.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler =new DatabaseHandler(this);

        /*databaseHandler.addStudent(new Student("Экономики и управления", "Плешков", "Игорь", "7.8"));
        databaseHandler.addStudent(new Student("Экономика и менеджмент", "Плешкова", "Александра", "8.1"));
        databaseHandler.addStudent(new Student("Бухгалтерский учет", "Алиев", "Тынгиз", "6.2"));
        databaseHandler.addStudent(new Student("Машиностроение", "Долгошей", "Сергей", "7.8"));
        databaseHandler.addStudent(new Student("Машиностроение", "Мищенко", "Вадим", "7.2"));*/


       List<Student> studentList= databaseHandler.getAllStudents();

        for (Student student: studentList){
            Log.i("Student info", "ID "+ student.getId()+ ", faculty "+ student.getDepartment()
                    + ", surname "+ student.getFirstName()+ ", name "+ student.getLastName()+ ", average score "+ student.getAverageMark());
        }
    }
}