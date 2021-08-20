package com.mezo.athena.admin.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    /**
     * 订阅指定主题的消息
     * @param record 消息记录
     */
    //通过topics指定订阅的主题
    //@KafkaListener(topics = {"aaa","ccc"})
    @KafkaListener(topics = {"athena"})
    //加了 @KafkaListener这个注解的方法，可以通过ConsumerRecord获取订阅主题的消息
    public void listen(ConsumerRecord record){
        // System.out.println(record);
        System.out.println(record.topic()+":"+record.value());
    }
}
