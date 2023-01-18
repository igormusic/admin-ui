package com.tvmsoftware.data.entity;

import lombok.Data;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Entity
@Data
public class SamplePerson extends AbstractEntity {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String occupation;
    private boolean important;

}
