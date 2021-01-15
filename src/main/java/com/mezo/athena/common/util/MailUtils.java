package com.mezo.athena.common.util;

import com.mezo.athena.common.demain.MailMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

/**
 * @author qzrs
 */
public class MailUtils {

    @Autowired(required = false)
    static JavaMailSender javaMailSender;

    public static void sendMail(MailMsg mailMsg) {

        try {
            //使用JavaMail的MimeMessage,支持更加复杂的邮件格式和内容
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(mailMsg.getSender());
            helper.setSubject(mailMsg.getSubject());
            helper.setText(mailMsg.getText(), mailMsg.isHtml());
            if (!mailMsg.isFSend()) {
                helper.setTo(mailMsg.getRecipient());
            } else {
                helper.setTo(mailMsg.getRecipientList());
            }
            List<File> files = mailMsg.getFiles();
            if (files.isEmpty()) {
                for (File file : files) {
                    helper.addAttachment(file.getName(), file);
                }
            }
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
