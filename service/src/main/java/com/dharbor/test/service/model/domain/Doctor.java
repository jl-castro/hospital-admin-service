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
@Table(name = "doctor_table")
@Inheritance(strategy = InheritanceType.JOINED)
public class Doctor implements Serializable {

    @Id
    @Column(name = "doctorid", nullable = false)
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
    @Column(name = "updatedat", nullable = true)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "createdby", nullable = false, updatable = false)
    @CreatedBy
    private Long createdBy;

    @Column(name = "updatedby", nullable = true)
    @LastModifiedBy
    private Long updatedBy;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patient_doctor_table",
            joinColumns = @JoinColumn(name = "doctorid", referencedColumnName = "doctorid"),
            inverseJoinColumns = @JoinColumn(name = "patientid", referencedColumnName = "patientid"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"doctorid", "patientid"})})
    private List<Patient> patients;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "speciality_doctor_table",
            joinColumns = @JoinColumn(name = "doctorid", referencedColumnName = "doctorid"),
            inverseJoinColumns = @JoinColumn(name = "specialityid", referencedColumnName = "specialityid"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"doctorid", "specialityid"})})
    private List<Speciality> specialities;

    @PrePersist
    void onPrePersist() {
        this.isDeleted = false;
        this.createdAt = new Date();
    }

}
