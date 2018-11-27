package io.esuau.studentapp.definition;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedList;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StudentList extends LinkedList<Student> implements Parcelable {

    public StudentList(Parcel in) {
        in.readList(this, Student.class.getClassLoader());
    }

    public static final Parcelable.Creator<StudentList> CREATOR = new Parcelable.Creator<StudentList>() {
        @Override
        public StudentList createFromParcel(Parcel source) {
            return new StudentList(source);
        }

        @Override
        public StudentList[] newArray(int size) {
            return new StudentList[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
