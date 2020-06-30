package com.cn.smart.rocketmq;

import org.springframework.stereotype.Component;

/**
 * @author ChuangLan
 */
@Component
public class MsgProducer {

    /*Logger logger = LoggerFactory.getLogger(MsgProducer.class);

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
    }*/

}
