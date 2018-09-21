package io.esuau.studentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import io.esuau.studentapp.definition.Student;

import java.util.Date;
import java.util.LinkedList;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("Suau", "Evan", "Homme", "evan.suau@etu.u-pec.fr", new Date(842997600000L), "SINCC", false));
        students.add(new Student("Doe", "Jane", "Femme", "jane@example.org", new Date(), "SID", false));
        students.add(new Student("Doe", "John", "Homme", "john@example.com", new Date(), "SID", false));
        StudentAdapter adapter = new StudentAdapter(getApplicationContext(), R.layout.activity_student_list, students);
        ListView studentListView = findViewById(R.id.student_list);
        studentListView.setAdapter(adapter);
    }

}
