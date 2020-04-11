package com.cn.smart.rocketmq;

/**
 * @author ChuangLan
 */
public class MqProducerDemo {
    /*public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("mq-group");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("producer");
        producer.start();
        try {
            for (int i = 0; i < 7; i++) {
                //MQ每隔一秒发送一条消息
                Thread.sleep(1000);
                // topic
                Message msg = new Message("TopicA-test",
                        "TagA",
                        ("RocketMQ xuwei"+i)
                                .getBytes()// body
                );
                //发送消息
                SendResult sendResult = producer.send(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();//关闭消息生产者
    }*/
}