package com.bravebe.bravebe.domain;

import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class Report {

    @Id
    private String postId;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;
    private String sendId;
    private String receiveId;

    public Report(String postId, String title, String content, LocalDateTime createTime, LocalDateTime deleteTime, String sendId, String receiveId) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.deleteTime = null;
        this.sendId = sendId;
        this.receiveId = receiveId;
    }
}
