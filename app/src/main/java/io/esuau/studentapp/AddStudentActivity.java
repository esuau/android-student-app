package io.esuau.studentapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import io.esuau.studentapp.definition.Student;

import java.util.Calendar;
import java.util.Date;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener {

    Button datePickerButton;
    Button addStudentButton;

    private TextView textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

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

            Students application = (Students) getApplication();
            application.addStudent(new Student(name, firstName, gender, email, new Date(), group, status));
        }
    }

}
