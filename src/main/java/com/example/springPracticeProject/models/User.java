package com.example.springPracticeProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @Column(name = "first_name")
    @NonNull String firstName;

    @Column(name = "last_name")
    @NonNull String lastName;

    @Column(name = "age")
    @NonNull Integer age;

    @Column(name = "user_name")
    @NonNull String userName;

    @OneToOne(mappedBy = "user")
    @NonNull Mail mail;
}

