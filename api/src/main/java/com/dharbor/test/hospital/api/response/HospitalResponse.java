package com.dharbor.test.hospital.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Jorge Castro
 */
@Getter
@Setter
public class HospitalResponse {

    private Long hospitalId;
    private String name;
    private String address;
    private Boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
    private Long createdBy;
    private Long updatedBy;

}
