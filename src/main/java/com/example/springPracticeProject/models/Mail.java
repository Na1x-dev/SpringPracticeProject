package com.example.springPracticeProject.models;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "mails")
@Data
public class Mail {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "mail_address")
    private String mailAddress;

    @OneToMany(mappedBy = "recipientsMail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> receivedMessages;

    @OneToMany(mappedBy = "sendersMail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> sentMessages;


}
