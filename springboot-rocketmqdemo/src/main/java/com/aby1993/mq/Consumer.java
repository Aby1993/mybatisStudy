package com.aby1993.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @version v1.0
 * @ProjectName: RocketMq
 * @ClassName: Consumet
 * @Description: 支撑
 * @Author: Aby1993
 * @Date: 2020/5/8 17:40
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "springboot-rocketmq", consumerGroup = "springboot-mq-consumer-1")
public class Consumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("Receive message：" + message);
    }

}
