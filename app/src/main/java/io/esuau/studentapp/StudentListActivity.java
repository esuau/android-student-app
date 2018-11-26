package io.esuau.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import io.esuau.studentapp.definition.StudentList;

public class StudentListActivity extends AppCompatActivity {

    private final int STUDENT_DETAILS_RESULT = 3;

    private final StudentList students = new StudentList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        students.addAll((StudentList) getIntent().getParcelableExtra("StudentList"));

        StudentAdapter adapter = new StudentAdapter(getApplicationContext(), R.layout.activity_student_list, students);
        ListView studentListView = findViewById(R.id.student_list);
        studentListView.setAdapter(adapter);
        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent(StudentListActivity.this, StudentDetailsActivity.class);
                intent.putExtra("Student", students.get(position));
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
