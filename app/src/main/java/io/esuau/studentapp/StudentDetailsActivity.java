package io.esuau.studentapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import io.esuau.studentapp.definition.Student;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Student student = getIntent().getParcelableExtra("Student");
        if (student != null) {
            TextView studentName = findViewById(R.id.student_name);
            studentName.setText(student.getName());
            TextView studentFirstName = findViewById(R.id.student_first_name);
            studentFirstName.setText(student.getFirstName());
            TextView studentGender = findViewById(R.id.student_gender);
            studentGender.setText(student.getGender());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
            TextView studentBirthDate = findViewById(R.id.student_birthdate);
            studentBirthDate.setText(formatter.format(student.getBirthDate()));
            TextView studentGroup = findViewById(R.id.student_group);
            studentGroup.setText(student.getGroup());
            TextView studentStatus = findViewById(R.id.student_status);
            studentStatus.setText(student.isStatus() ? "Oui" : "Non");
        }
    }

}
