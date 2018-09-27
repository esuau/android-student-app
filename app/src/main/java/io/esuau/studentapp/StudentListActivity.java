package io.esuau.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import io.esuau.studentapp.definition.Student;

import java.util.LinkedList;

public class StudentListActivity extends AppCompatActivity {

    private final int STUDENT_DETAILS_RESULT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        Students application = (Students) getApplication();
        final LinkedList<Student> students = application.getStudents();

        StudentAdapter adapter = new StudentAdapter(getApplicationContext(), R.layout.activity_student_list, students);
        ListView studentListView = findViewById(R.id.student_list);
        studentListView.setAdapter(adapter);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(StudentListActivity.this, StudentDetailsActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("student", students.get(position));
                intent.putExtras(b);
                startActivityForResult(intent, STUDENT_DETAILS_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == STUDENT_DETAILS_RESULT) {
            setResult(RESULT_OK);
            finish();
        }
    }

}
