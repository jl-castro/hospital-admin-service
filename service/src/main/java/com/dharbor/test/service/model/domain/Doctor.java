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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "profileid")
    private String profileid;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "speciality_doctor_table",
            joinColumns = @JoinColumn(name = "doctorid", referencedColumnName = "doctorid"),
            inverseJoinColumns = @JoinColumn(name = "specialityid", referencedColumnName = "specialityid"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"doctorid", "specialityid"})})
    private List<Speciality> specialities;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hospitalid", referencedColumnName = "hospitalid", nullable = false)
    private Hospital hospital;

    @PrePersist
    void onPrePersist() {
        this.isDeleted = false;
        this.createdAt = new Date();
    }

}
