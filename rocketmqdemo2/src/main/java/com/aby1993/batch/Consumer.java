package com.aby1993.batch;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @version v1.0
 * @ProjectName: RocketMq
 * @ClassName: Consume
 * @Description: 消费消息
 * @Author: Aby1993
 * @Date: 2020/5/8 10:18
 */
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        //创建消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");

        //指定namesrv地址
        consumer.setNamesrvAddr("192.168.211.129:9876");

        //订阅主题和tag
        consumer.subscribe("TopicTest1", "TagB");

        //消息消费模式   默认是负载均衡  可以手动修改成广播模式
        consumer.setMessageModel(MessageModel.CLUSTERING);


        //注册监听器 处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            //接受消息内容
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

                for (MessageExt message : list) {
                    System.out.println(new String(message.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //启动
        consumer.start();
    }
}
