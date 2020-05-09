package com.aby1993.batch;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: RocketMq
 * @ClassName: BatchProducer
 * @Description:发送批量消息
 * @Author: Aby1993
 * @Date: 2020/5/8 9:14
 */
public class BatchProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        //创建生产者 根据对应的消费者组进行区分
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");

        //设置namesrv的地址
        producer.setNamesrvAddr("192.168.211.129:9876");

        //启动producer实例
        producer.start();

        List<Message> msgs = new ArrayList<Message>();
        long sysTime = System.currentTimeMillis();
        //构建消息
        Message msg1 = new Message("TopicTest1", "TagB", "OrderID00" + sysTime, ("Hello MetaQ" + sysTime).getBytes());
        Message msg2 = new Message("TopicTest1", "TagB", "OrderID00" + sysTime, ("Hello MetaQ" + sysTime).getBytes());
        Message msg3 = new Message("TopicTest1", "TagB", "OrderID00" + sysTime, ("Hello MetaQ" + sysTime).getBytes());

        msgs.add(msg1);
        msgs.add(msg2);
        msgs.add(msg3);

        //响应体
        producer.send(msgs);

        producer.shutdown();
    }
}
