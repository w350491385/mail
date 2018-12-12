package com.cn.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * @Description: $description$
 * @Author: huangdb002
 * @Date: 2018/10/31 16:20
 */
public class EmailSend {

    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;
    /**
     * 方法名: sendMail
     * 参数名：@param subject  邮件主题
     * 参数名：@param content 邮件主题内容
     * 描述语: 发送邮件
     */
    public void send(String subject, String content) {
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        mailSender.send(simpleMailMessage);
    }

    public void sendHtml(String subject,String html){
        //使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容  
        MimeMessage msg = ((JavaMailSenderImpl)mailSender).createMimeMessage();
        try {
            //创建MimeMessageHelper对象，处理MimeMessage的辅助类  
            MimeMessageHelper helper = new MimeMessageHelper(msg,"UTF-8");
            helper.setTo(simpleMailMessage.getTo());
            helper.setFrom(simpleMailMessage.getFrom());
            helper.setSubject(subject);
            helper.setText(html,true);
            ((JavaMailSenderImpl) mailSender).send(msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}
