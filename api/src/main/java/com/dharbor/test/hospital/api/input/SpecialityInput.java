package com.dharbor.test.hospital.api.input;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Jorge Castro
 */
@Getter
@Setter
public class SpecialityInput {

    private String name;
    private String description;
    private Long avatarId;

}
