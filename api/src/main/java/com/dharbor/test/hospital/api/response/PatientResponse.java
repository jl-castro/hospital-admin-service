package com.dharbor.test.hospital.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Jorge Castro
 */
@Getter
@Setter
public class PatientResponse {

    private Long patientId;
    private String name;
    private String lastName;
    private String address;
    private Date birthday;
    private Boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
    private Long createdBy;
    private Long updatedBy;

}
