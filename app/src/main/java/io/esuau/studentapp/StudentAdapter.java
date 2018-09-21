package io.esuau.studentapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import io.esuau.studentapp.definition.Student;

import java.util.LinkedList;

public class StudentAdapter extends ArrayAdapter<Student> {

    private final Context context;
    private LinkedList<Student> students;

    StudentAdapter(Context context, int resource, LinkedList<Student> students) {
        super(context, resource, students);
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.picture);
        if (students.get(position).getGender().equals("Homme")) {
            imageView.setBackgroundResource(R.drawable.ic_man);
        } else if (students.get(position).getGender().equals("Femme")) {
            imageView.setBackgroundResource(R.drawable.ic_wooman);
        }
        TextView fullNameView = convertView.findViewById(R.id.name);
        String fullName = students.get(position).getFirstName() + " " + students.get(position).getName();
        fullNameView.setText(fullName);
        return convertView;
    }

}
