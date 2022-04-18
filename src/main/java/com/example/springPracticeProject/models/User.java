package com.example.springPracticeProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.*;
import javax.persistence.*;
import java.beans.Transient;

@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties("hibernateLazyInitializer")
public class User {
    @NonNull
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    @Column(name = "first_name")
    String firstName;

    @NonNull
    @Column(name = "last_name")
    String lastName;

    @NonNull
    @Column(name = "age")
    Integer age;

    @NonNull
    @Column(name = "user_name")
    String userName;

    @NonNull
    @OneToOne(mappedBy = "user")
    Mail mail;


    public User() {
    }
}

