package com.example.springPracticeProject.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mails")
@Data
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Mail {
    @NonNull
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
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

    public Integer getId() {
        return id;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
