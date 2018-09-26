package io.esuau.studentapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import io.esuau.studentapp.definition.Student;

import java.util.Date;
import java.util.LinkedList;

public class StudentListActivity extends AppCompatActivity {

    private final int STUDENT_DETAILS_RESULT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        final LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("Suau", "Evan", "Homme", "evan.suau@etu.u-pec.fr", new Date(842997600000L), "SINCC", false));
        students.add(new Student("Doe", "Jane", "Femme", "jane@example.org", new Date(), "SID", false));
        students.add(new Student("Doe", "John", "Homme", "john@example.com", new Date(), "SID", false));
        StudentAdapter adapter = new StudentAdapter(getApplicationContext(), R.layout.activity_student_list, students);
        ListView studentListView = findViewById(R.id.student_list);
        studentListView.setAdapter(adapter);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(StudentListActivity.this, StudentDetailsActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("student", students.get(position));
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
