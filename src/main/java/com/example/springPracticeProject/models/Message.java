package com.example.springPracticeProject.models;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @NonNull
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Mail sendersMail;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Mail recipientsMail;

    @NonNull
    @Column(name = "message_content")
    private String messageContent;


    public Message() {
    }
}
