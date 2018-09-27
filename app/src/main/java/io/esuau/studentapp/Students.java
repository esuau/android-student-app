package io.esuau.studentapp;

import android.app.Application;
import io.esuau.studentapp.definition.Student;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

public class Students extends Application {

    private final LinkedList<Student> students = new LinkedList<>(Arrays.asList(
            new Student("Suau", "Evan", "Homme", "evan.suau@etu.u-pec.fr", new Date(842997600000L), "SINCC", false),
            new Student("Doe", "Jane", "Femme", "jane@example.org", new Date(), "SID", false),
            new Student("Doe", "John", "Homme", "john@example.com", new Date(), "SID", false)
    ));

    LinkedList<Student> getStudents() {
        return this.students;
    }

    void addStudent(Student value) {
        this.students.add(value);
    }

}
