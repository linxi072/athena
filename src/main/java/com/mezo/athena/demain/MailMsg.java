package com.mezo.athena.demain;

import java.io.File;
import java.util.List;

/**
 * @author qzrs
 */
public class MailMsg {

    /**
     * 群发
     */
    private boolean FSend;
    /**
     * 邮件发送者
     */
    private String sender;
    /**
     * 邮件接收者
     */
    private String recipient;
    private String[] recipientList;
    /**
     * 主题
     */
    private String subject;
    /**
     * 正文
     */
    private String text;
    /**
     *
     */
    private boolean html;
    /**
     * 文件
     */
    private List<File> files;
    public MailMsg() {
        FSend = false;
        html = false;
    }

    public boolean isFSend() {
        return FSend;
    }

    public void setFSend(boolean FSend) {
        this.FSend = FSend;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String[] getRecipientList() {
        return recipientList;
    }

    public void setRecipientList(String[] recipientList) {
        this.recipientList = recipientList;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
