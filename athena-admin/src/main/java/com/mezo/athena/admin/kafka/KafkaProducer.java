package com.mezo.athena.admin.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {
    @Autowired
    private KafkaTemplate template;

    /**
     * 发送消息到Kafka
     * @param topic 主题，如果主题不存在，会自动创建主题
     * @param message　消息
     * @return
     */
    @RequestMapping("/sendMsg")
    public String sendMsg(String topic, String message){
        template.send(topic,message);//消息就被发送到kafka服务器上存起来了
        return "success";
    }
}
