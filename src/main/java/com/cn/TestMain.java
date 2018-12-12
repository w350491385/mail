package com.cn;

import com.cn.mail.EmailSend;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class TestMain
{
    public static void main( String[] args ){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmailSend sender = (EmailSend)ac.getBean("simpleMail");
//        sender.send("测试主题。。。。","测试内容");

        sender.sendHtml("测试主题","<b>测试内容</b><br/><u>测试内容2</>");
    }
}
