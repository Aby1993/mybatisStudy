package com.aby1993;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version v1.0
 * @ProjectName: RocketMq
 * @ClassName: ProducerTest
 * @Description: 测试生产者
 * @Author: Aby1993
 * @Date: 2020/5/8 17:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class})
public class ProducerTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void test1() {
        rocketMQTemplate.convertAndSend("springboot-rocketmq", "springboot-rocketmq");
    }
}
