package com.intern.test.internmanagesys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="Intern")
public class InternEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    @NotEmpty(message = "CANNOT BE NULL")
    private String name;


    @Column(name = "contact", nullable = false)
    @NotNull(message = "CANNOT BE NULL")
    @Positive(message = "POSITIVE ACCEPTED")
    private long contact;

    @Column(name = "address", nullable = false)
    @NotNull(message = "{validation.address.NotNull}")
    private String address;

    @Column(name = "postal_code", nullable = false)
    @NotNull(message = "{validation.postalCode.NotNull}")
    private long postalCode;

    @Column(name = "start_date", nullable = true)
//    @CreationTimestamp
//    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date", nullable = true)
//    @UpdateTimestamp
//    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "designated_id")
    private DesignationEntity designationEntity;

}
