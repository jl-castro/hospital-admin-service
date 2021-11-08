package com.dharbor.test.service.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Jorge Castro
 */
@Setter
@Getter
@Entity
@Table(name = "patient_table")
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient implements Serializable {

    @Id
    @Column(name = "patientid", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "isdeleted", nullable = false)
    private Boolean isDeleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdat", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedat")
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "createdby", nullable = false, updatable = false)
    @CreatedBy
    private Long createdBy;

    @Column(name = "updatedby")
    @LastModifiedBy
    private Long updatedBy;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors;

    @PrePersist
    void onPrePersist() {
        this.isDeleted = false;
        this.createdAt = new Date();
    }

}
