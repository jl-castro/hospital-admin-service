package com.dharbor.test.hospital.api.input;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Jorge Castro
 */
@Getter
@Setter
public class DoctorInput {

    private String name;
    private String lastName;
    private Date birthday;
    private String address;

}
