package cn.et;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender jms;

    @GetMapping("/gsend")
    public String sendEmail(String send_to,String send_subject,String send_content) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("1960150996@qq.com");   //发送方
        message.setTo(send_to);  //接收方
        message.setSubject(send_subject);  //邮件主题
        message.setText(send_content); //邮件内容

        jms.send(message);

        return "发送成功";
    }

    
    
    @PostMapping("/psend")
    public String sendMail(@RequestBody Map<String,Object> map){
        SimpleMailMessage mailMessage  =   new  SimpleMailMessage();
        mailMessage.setFrom("1960150996@qq.com");
        mailMessage.setTo(map.get("send_to").toString());
        mailMessage.setSubject(map.get("send_subject").toString());
        mailMessage.setText(map.get("send_content").toString());
        jms.send(mailMessage);
        return "发送成功";
    }
    
    
}
