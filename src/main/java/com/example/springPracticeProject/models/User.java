package com.example.springPracticeProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @Column(name = "password")
    @NonNull String password;

    @OneToOne(mappedBy = "user")
    @NonNull Mail mail;

    @ManyToMany
    private Set<Role> roles;

    @Transient
    private String passwordConfirm;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

