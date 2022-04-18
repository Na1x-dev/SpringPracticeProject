package com.example.springPracticeProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Message {
    @NonNull
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name="senders_mail_id", nullable = false, referencedColumnName = "id")
    private Mail sendersMail;

    @NonNull
    @ManyToOne
    @JoinColumn(name="recipients_mail_id", nullable = false, referencedColumnName = "id")
    private Mail recipientsMail;

    @NonNull
    @Column(name = "message_content")
    private String messageContent;


    public Message() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public void setRecipientsMail(Mail recipientsMail) {
        this.recipientsMail = recipientsMail;
    }

    public void setSendersMail(Mail sendersMail) {
        this.sendersMail = sendersMail;
    }

    public Mail getSendersMail() {
        return sendersMail;
    }

    public Integer getId() {
        return id;
    }

    public Mail getRecipientsMail() {
        return recipientsMail;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
