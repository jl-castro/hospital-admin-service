package com.dharbor.test.hospital.api.input;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Jorge Castro
 */
@Getter
@Setter
public class PatientInput {

    private String name;
    private String lastName;
    private String address;
    private Date birthday;

}
