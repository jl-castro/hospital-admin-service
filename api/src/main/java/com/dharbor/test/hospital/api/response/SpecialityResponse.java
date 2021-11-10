package com.dharbor.test.hospital.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Jorge Castro
 */
@Getter
@Setter
public class SpecialityResponse {

    private Long specialityId;
    private String name;
    private String description;
    private Long avatarId;
    private Long hospitalId;
    private Boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
    private Long createdBy;
    private Long updatedBy;

}
