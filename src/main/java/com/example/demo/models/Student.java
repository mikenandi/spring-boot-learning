package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table
public class Student  extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;

    @Column(length = 40)
    private String firstname;

    @Column(length = 40)
    private String lastname;

    @Column(length = 100, unique = true)
    private String email;

    @Column(length = 9)
    private String phone;

    @Column(length = 9)
    private String dob;

    @Column(length = 100)
    private String address;

    @Column(length = 100)
    private String city;

//    @CreationTimestamp
//    @Column(nullable = false, updatable = false)
//    private Date createdAt;

//    @UpdateTimestamp
//    @Column()
//    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;
}
