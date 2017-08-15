package com.fekpal.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class Message extends BasePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @Column(name = "message_title")
    private String messageTitle;

    @Column(name = "message_content")
    private String messageContent;

    @Column(name = "release_time")
    private Timestamp releaseTime;

    @ManyToOne
    @JoinTable(name = "user_id")
    private User user;

    @Column(name = "message_type")
    private int messageType;

    @Column(name = "message_annex")
    private String messageAnnex;

    @Column(name = "message_state")
    private int messageState;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getMessageAnnex() {
        return messageAnnex;
    }

    public void setMessageAnnex(String messageAnnex) {
        this.messageAnnex = messageAnnex;
    }

    public int getMessageState() {
        return messageState;
    }

    public void setMessageState(int messageState) {
        this.messageState = messageState;
    }
}
