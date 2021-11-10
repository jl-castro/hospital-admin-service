package com.dharbor.test.service.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Jorge Castro
 */
@Setter
@Getter
@Document(collection = "profile")
public class Profile {

    @Id
    private String id;

    private Binary image;

}
