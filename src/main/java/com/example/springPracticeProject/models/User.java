package com.example.springPracticeProject.models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @NonNull
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "age")
    private Integer age;

    @NonNull
    @Column(name = "user_name")
    private String userName;

    @OneToOne(mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Mail mail;

    public User(){
    }
}
