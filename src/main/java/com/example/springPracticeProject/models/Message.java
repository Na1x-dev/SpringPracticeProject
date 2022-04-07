package com.example.springPracticeProject.models;


//@Entity
//@Table(name = "messages")
public class Message {
    //@Id
    //@Column
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(name = "senders_mail_id")
    private Integer sendersMailId;

    //@Column(name = "recipients_mail_id")
    private Integer recipientsMailId;

    //@Column(name = "message_content")
    private String messageContent;

    public Message(){}

    public Message(Integer id, Integer sendersMailId, Integer recipientsMailId, String messageContent){
        this.id = id;
        this.sendersMailId = sendersMailId;
        this.recipientsMailId = recipientsMailId;
        this.messageContent = messageContent;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSendersMailId() {
        return sendersMailId;
    }

    public Integer getRecipientsMailId() {
        return recipientsMailId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSendersMailId(Integer sendersMailId) {
        this.sendersMailId = sendersMailId;
    }

    public void setRecipientsMailId(Integer recipientsMailId) {
        this.recipientsMailId = recipientsMailId;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", sendersMailId=" + sendersMailId +
                ", recipientsMailId=" + recipientsMailId +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }
}
