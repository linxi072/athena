package com.mezo.athena;

import com.mezo.athena.common.util.FreeMarkerUtils;
import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.mapper.AthenaRoleMapper;
import com.mezo.athena.mapper.AthenaUserMapper;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApplicationTest {
    @Autowired(required = false)
    JavaMailSender javaMailSender;
    public static String PROJECT_PATH = System.getProperty("user.dir");
    @Autowired(required = false)
    AthenaRoleMapper athenaRoleMapper;
    @Autowired(required = false)
    AthenaUserMapper athenaUserMapper;
    @Autowired
    StringRedisTemplate template;
    @Test
    public void test01() {
        AthenaUser athenaUser = athenaUserMapper.selectByPrimaryKey(1);
        Assert.assertNotNull(athenaUser);
    }
    @Test
    public void test02() throws IOException, TemplateException {
        HashMap map = new HashMap();
        map.put("hello", "Hello FreeMarker!");
        HashMap c = new HashMap();
        c.put("name","张三");
        c.put("age","21");
        map.put("c",c);
        String binding = FreeMarkerUtils.binding(PROJECT_PATH + "/src/main/resources/freemarker", "baojia.ftl",map);
        System.out.println(binding);
    }

    @Test
    public void test03() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("linxi072@163.com");
        mailMessage.setTo("897203456@qq.com");
        mailMessage.setSubject("主题");
        mailMessage.setText("内容");
        javaMailSender.send(mailMessage);
    }

    @Test
    public void test04() {
       //使用JavaMail的MimeMessage,支持更加复杂的邮件格式和内容
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("linxi072@163.com");
            helper.setTo("897203456@qq.com");
            helper.setSubject("主题");
            helper.setText("<h1>这是富文本邮件内容</h1>" +
                    "<div style＝'color:red'>你好,Spring boot!我是 Kotlin。</div>",true);
            ClassPathResource file = new ClassPathResource("application.yml");
            helper.addAttachment("file1",file);
            helper.addAttachment("file2",file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test05() {
        template.afterPropertiesSet();
        template.opsForValue().set("111","222");
    }
}