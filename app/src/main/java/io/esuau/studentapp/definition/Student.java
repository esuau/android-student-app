package io.esuau.studentapp.definition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private String name;

    private String firstName;

    private String gender;

    private String email;

    private Date birthDate;

    private String group;

    private boolean status;

}
