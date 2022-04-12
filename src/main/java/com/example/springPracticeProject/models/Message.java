package com.example.springPracticeProject.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mail sendersMail;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mail recipientsMail;

    @Column(name = "message_content")
    private String messageContent;





}
