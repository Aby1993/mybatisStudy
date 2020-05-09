package com.aby1993;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;

/**
 * @version v1.0
 * @ProjectName: RocketMq
 * @ClassName: Producer
 * @Description: TODO(一句话描述该类的功能)
 * @Author: Aby1993
 * @Date: 2020/4/30 19:47
 */
public class Producer {
    private static DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

    private static int initialState = 0;

    private Producer() {

    }

    public static DefaultMQProducer getDefaultMQProducer(){
        if(producer == null){
            producer = new DefaultMQProducer("ProducerGroupName");
        }

        if(initialState == 0){
            producer.setNamesrvAddr("192.168.211.129:9876");
            try {
                producer.start();
            } catch (MQClientException e) {
                e.printStackTrace();
                return null;
            }
            initialState = 1;
        }

        return producer;
    }
}
