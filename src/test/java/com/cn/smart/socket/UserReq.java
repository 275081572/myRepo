package com.cn.smart.socket;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 可用于构造请求参数
 */
@XmlAccessorType(XmlAccessType.FIELD)//表示使用这个类中的 private 非静态字段作为 XML 的序列化的属性或者元素,对应属性要使用get、set方法。
@XmlRootElement(name="business")
@Data
public class UserReq {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private String comment;
    @XmlElement(name="body")
    private User user;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    public static class User{
        private String fwqdz;
        private String fwqdkh;
        private String nsrsbh;
        private String xnsbh;
        private String xnsbkl;
        private String dqym;
        private String myzdjls;
    }
}
