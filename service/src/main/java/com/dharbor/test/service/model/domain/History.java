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

/**
 * @author Jorge Castro
 */
@Setter
@Getter
@Entity
@Table(name = "history_table")
@Inheritance(strategy = InheritanceType.JOINED)
public class History implements Serializable {

    @Id
    @Column(name = "historyid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctorid", referencedColumnName = "doctorid", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patientid", referencedColumnName = "patientid", nullable = false)
    private Patient patient;

    @PrePersist
    void onPrePersist() {
        this.isDeleted = false;
        this.createdAt = new Date();
    }

}
