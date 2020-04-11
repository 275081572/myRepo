package com.cn.smart.rocketmq;

import com.chuanglan.platform.rocketmqplugin.message.SmsRealMessageFactory;
import com.chuanglan.platform.rocketmqplugin.producer.DefaultProducerFactory;
import com.chuanglan.platform.rocketmqplugin.serialize.kryo.DefaultKryoFactory;
import com.chuanglan.platform.rocketmqplugin.serialize.kryo.KryoSerializer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ${DESCRIPTION}
 *
 * @author duanzm
 * @create 2019-06-17 13:40
 **/
@Configuration
public class RocketmqConfig {

    @Value(value = "${rocketmq.namesrv.ipaddress}")
    public String nameserver="";
    @Value(value = "${rocketmq.producer.groupname}")
    public String groupname;
    @Value(value = "${rocketmq.producer.instancename}")
    public String instancename;



    @Bean
    public DefaultKryoFactory defaultKryoFactory(){
        return new DefaultKryoFactory();
    }


    @Bean
    public KryoSerializer KryoSerializer(@Autowired DefaultKryoFactory defaultKryoFactory) {
        return new KryoSerializer(defaultKryoFactory);
    }

    @Bean("messageFactory")
    public SmsRealMessageFactory messageFactory(@Autowired KryoSerializer kryoSerializer){
        return new SmsRealMessageFactory(kryoSerializer);
    }

    @Bean("defaultProducerFactory")
    public DefaultProducerFactory createMsgProducer() throws MQClientException {
        DefaultProducerFactory defaultProducerFactory = new DefaultProducerFactory(nameserver, groupname, instancename);
        defaultProducerFactory.init();
        return defaultProducerFactory;
    }







}