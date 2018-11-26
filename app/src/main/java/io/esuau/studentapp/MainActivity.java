package io.esuau.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import io.esuau.studentapp.definition.Student;
import io.esuau.studentapp.definition.StudentList;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final int ADD_STUDENT_RESULT = 1;
    private final int SHOW_STUDENTS_RESULT = 2;

    private final StudentList students = new StudentList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentList list = getIntent().getParcelableExtra("StudentList");
        if (null == list) {
            students.add(new Student("Suau", "Evan", "Homme", "evan.suau@etu.u-pec.fr", new Date(842997600000L), "SINCC", false));
            students.add(new Student("Doe", "Jane", "Femme", "jane@example.org", new Date(), "SID", false));
            students.add(new Student("Doe", "John", "Homme", "john@example.com", new Date(), "SID", false));
        } else {
            students.addAll(list);
        }

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                intent.putExtra("StudentList", (Parcelable) students);
                startActivityForResult(intent, ADD_STUDENT_RESULT);
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
                intent.putExtra("StudentList", (Parcelable) students);
                startActivityForResult(intent, SHOW_STUDENTS_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ADD_STUDENT_RESULT || resultCode == SHOW_STUDENTS_RESULT) {
            setResult(RESULT_OK);
            finish();
        }
    }

}
