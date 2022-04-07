package com.example.springPracticeProject.models;



//@Entity
//@Table(name = "mails")
public class Mail {
    //@Id
    //@Column
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(name = "user_id")
    private Integer userId;

    //@Column(name = "mail_address")
    private String mailAddress;


    public Mail(){
    }

    public Mail(Integer id, Integer userId, String mailAddress){
        this.id= id;
        this.userId = userId;
        this.mailAddress = mailAddress;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", userId=" + userId +
                ", mailAddress='" + mailAddress + '\'' +
                '}';
    }
}
