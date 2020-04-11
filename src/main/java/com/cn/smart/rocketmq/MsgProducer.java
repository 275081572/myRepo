package com.cn.smart.rocketmq;

import com.alibaba.fastjson.JSON;
import com.chuanglan.platform.rocketmqplugin.bean.Subscription;
import com.chuanglan.platform.rocketmqplugin.message.SmsRealMessageFactory;
import com.chuanglan.platform.rocketmqplugin.message.msgformat.PackedMsg;
import com.chuanglan.platform.rocketmqplugin.message.msgformat.SmsMsg;
import com.chuanglan.platform.rocketmqplugin.producer.DefaultProducerFactory;
import com.cn.smart.dto.MixDTO;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ChuangLan
 */
@Component
public class MsgProducer {

    Logger logger = LoggerFactory.getLogger(MsgProducer.class);

    @Autowired
    DefaultProducerFactory defaultProducerFactory;

    @Autowired
    @Qualifier("messageFactory")
    SmsRealMessageFactory messageFactory;

    @Value("${rocketmq.producer.topics}")
    public String topics;

    @Value("${rocketmq.producer.tags}")
    public String tags;

    @Async("sendSettleOrderToMqPool")
    public void sendSettleOrderToMq(MixDTO mixDTO) {
        Long startTime = System.currentTimeMillis();
        SmsMsg smsMsg = new SmsMsg();
        smsMsg.setMsgContent(JSON.toJSONString(mixDTO));
        Subscription subscription = new Subscription(topics, tags);
        PackedMsg<SmsMsg> packedMsg = messageFactory.getInstance(smsMsg, subscription);
        try {
            SendResult sendResult = defaultProducerFactory.getProducer().send(packedMsg);
            if(!sendResult.getSendStatus().equals(SendStatus.SEND_OK)){
                logger.error("deduction send error:" + mixDTO.toString() + ",useTime:" + (System.currentTimeMillis() - startTime));
            }else{
                logger.info("deduction send success:" + mixDTO.toString() + ",useTime:" + (System.currentTimeMillis() - startTime));
            }
        } catch (Exception e) {
            logger.warn("sendSettleOrderToMq fail!,orig msg is:{}", JSON.toJSONString(mixDTO));
            logger.error("sendSettleOrderToMq error!",e);
        }
    }


}
