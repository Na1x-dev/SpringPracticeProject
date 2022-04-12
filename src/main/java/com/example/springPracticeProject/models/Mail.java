package com.example.springPracticeProject.models;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mails")
@Data
public class Mail {
    @NonNull
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NonNull
    @Column(name = "mail_address")
    private String mailAddress;

    @OneToMany(mappedBy = "recipientsMail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> receivedMessages;

    @OneToMany(mappedBy = "sendersMail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> sentMessages;


    public Mail() {
    }
}
