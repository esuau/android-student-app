package io.esuau.studentapp.definition;

import android.os.Parcel;
import android.os.Parcelable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Parcelable {

    private String name;

    private String firstName;

    private String gender;

    private String email;

    private Date birthDate;

    private String group;

    private boolean status;

    public Student(Parcel in) {
        name = in.readString();
        firstName = in.readString();
        gender = in.readString();
        email = in.readString();
        birthDate = (Date) in.readSerializable();
        group = in.readString();
        status = in.readByte() != 0;
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(firstName);
        dest.writeString(gender);
        dest.writeString(email);
        dest.writeSerializable(birthDate);
        dest.writeString(group);
        dest.writeByte((byte) (status ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
