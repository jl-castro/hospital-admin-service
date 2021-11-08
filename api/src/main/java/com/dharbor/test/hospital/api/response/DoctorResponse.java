package com.dharbor.test.hospital.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author Jorge Castro
 */
@Getter
@Setter
public class DoctorResponse {

    private Long doctorId;
    private String name;
    private String lastName;
    private String address;
    private Date birthday;
    private Boolean isDeleted;
    private List<SpecialityResponse> specialities;
    private Date createdAt;
    private Date updatedAt;
    private Long createdBy;
    private Long updatedBy;

}
