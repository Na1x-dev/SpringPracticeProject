package com.example.springPracticeProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mails")
@Data
@NoArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Mail {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    @NonNull
    User user;

    @Column(name = "mail_address")
    @NonNull
    String mailAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "recipientsMail", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    List<Message> receivedMessages;

    @JsonIgnore
    @OneToMany(mappedBy = "sendersMail", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    List<Message> sentMessages;
}
