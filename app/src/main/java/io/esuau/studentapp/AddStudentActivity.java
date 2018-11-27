package io.esuau.studentapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import io.esuau.studentapp.definition.Student;
import io.esuau.studentapp.definition.StudentList;

import java.util.Calendar;
import java.util.Date;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener {

    private final int STUDENT_LIST_ACTIVITY_RESULT = 4;

    private final StudentList students = new StudentList();

    private Button datePickerButton;
    private Button addStudentButton;
    private TextView textDate;
    private Date birthDate = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        students.addAll((StudentList) getIntent().getParcelableExtra("StudentList"));

        textDate = findViewById(R.id.textdate);

        datePickerButton = findViewById(R.id.datepickerbutton);
        datePickerButton.setOnClickListener(this);

        addStudentButton = findViewById(R.id.addstudentbutton);
        addStudentButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == datePickerButton) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            String dateStr = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                            textDate.setText(dateStr);
                            birthDate.setYear(year);
                            birthDate.setMonth(monthOfYear);
                            birthDate.setDate(dayOfMonth);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } else if (v == addStudentButton) {
            EditText inputName = findViewById(R.id.input_name);
            String name = inputName.getText().toString();

            EditText inputFirstName = findViewById(R.id.input_first_name);
            String firstName = inputFirstName.getText().toString();

            RadioGroup inputGenderGroup = findViewById(R.id.input_gender);
            RadioButton inputGender = findViewById(inputGenderGroup.getCheckedRadioButtonId());
            String gender = inputGender.getText().toString();

            EditText inputEmail = findViewById(R.id.input_email);
            String email = inputEmail.getText().toString();

            EditText inputGroup = findViewById(R.id.input_group);
            String group = inputGroup.getText().toString();

            Switch inputStatus = findViewById(R.id.input_status);
            boolean status = inputStatus.isChecked();

            students.add(new Student(name, firstName, gender, email, birthDate, group, status));

            Intent intent = new Intent(AddStudentActivity.this, StudentListActivity.class);
            intent.putExtra("StudentList", (Parcelable) students);
            startActivityForResult(intent, STUDENT_LIST_ACTIVITY_RESULT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == STUDENT_LIST_ACTIVITY_RESULT) {
            if (resultCode == RESULT_OK && null != data) {
                students.clear();
                students.addAll((StudentList) data.getParcelableExtra("StudentList"));
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddStudentActivity.this, MainActivity.class);
        intent.putExtra("StudentList", (Parcelable) students);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }

}
