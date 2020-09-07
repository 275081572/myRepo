package com.cn.smart.socket;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //可用于项目转xml
//        objectToXml2();

//        objectToXml();
//        System.out.println("------------");
//        xmlToObjetct();

        //可用于项目转bean
        toBean();

        //可用于项目转beanList
        toBeanList();
    }

    public static  void objectToXml(){
        MySocket mySocket = new MySocket();
        mySocket.setName("张三");
        mySocket.setCode("00012");
        mySocket.setAge("25");
        String xml = JaxbUtil.convertToXml(mySocket);
        System.out.println(xml);
    }

    public static  void objectToXml2(){
        UserReq userReq = new UserReq();
        userReq.setId("1");
        userReq.setComment("aaa");

        UserReq.User user = new UserReq.User();
        user.setDqym("我");
        user.setFwqdkh("2");
        user.setFwqdz("3");
        user.setMyzdjls("4");
        user.setNsrsbh("5");
        user.setXnsbh("6");
        user.setXnsbkl("7");
        userReq.setUser(user);

        String xml = JaxbUtil.convertToXml(userReq);
        System.out.println(xml);
    }

    public static void xmlToObjetct(){
        String xml = "<?xml version=\"1.0\" encoding=\"GBK\"?><body><Code>00011</Code><Name>李四</Name><Age>26</Age></body>";
        MySocket mySocket= JaxbUtil.converyToJavaBean(xml, MySocket.class);
        System.out.println(mySocket.toString());
    }

    public static void toBean(){
        String xmlStr = "<?xml version=\"1.0\" encoding=\"gbk\"?><business id=\"91001\" comment=\"纳税人基本信息查询\"><body><returncode>返回代码</returncode><returnmsg>返回信息</returnmsg><returndata><jbxx count=\"n\"><group xh=\"1\"><xnsbh>虚拟设备号</xnsbh><nsrsbh>纳税人识别号</nsrsbh><nsrmc>纳税人名称</nsrmc><swjgdm>税务机关代码</swjgdm><swjgmc>税务机关名称</swjgmc><fplxdm>发票类型代码</fplxdm><dqsz>当前时钟</dqsz><djsj>登记时间</djsj><bbh>版本号</bbh><kpjh>开票机号</kpjh><qylx>企业类型</qylx><djxh>登记序号</djxh><kpbz>开票标志</kpbz><tdqy>特定企业</tdqy><ncpqy>农产品企业</ncpqy><dxqy>电信企业</dxqy><xgmkjzpbs>小规模开具专票标识</xgmkjzpbs><esjdcbz>二手机动车标志</esjdcbz><cpybs>成品油标识</cpybs><cpybsyxq>成品油标识有效期</cpybsyxq><cpybmdbs>成品油白名单标识</cpybmdbs><cpybmdbsyxq>成品油白名单有效期</cpybmdbsyxq><xtqy>稀土企业</xtqy><jxsqbz>进项授权标志</jxsqbz></group></jbxx></returndata></body></business>";
        UserResp userResp = JaxbUtil.toBean(xmlStr, UserResp.class);
        UserResp.Body body = userResp.getBody();
        String returncode = body.getReturncode();
        UserResp.Group group = body.getReturnData().getJbxx().getGroup();
        System.out.println(group);
    }

    public static void toBeanList(){
        String xmlStr = "<?xml version=\"1.0\" encoding=\"gbk\"?><business id=\"91001\" comment=\"纳税人基本信息查询\"><body><returncode>返回代码</returncode><returnmsg>返回信息</returnmsg><returndata><jbxx count=\"n\"><group xh=\"1\"><xnsbh>虚拟设备号</xnsbh><nsrsbh>纳税人识别号</nsrsbh><nsrmc>纳税人名称</nsrmc><swjgdm>税务机关代码</swjgdm><swjgmc>税务机关名称</swjgmc><fplxdm>发票类型代码</fplxdm><dqsz>当前时钟</dqsz><djsj>登记时间</djsj><bbh>版本号</bbh><kpjh>开票机号</kpjh><qylx>企业类型</qylx><djxh>登记序号</djxh><kpbz>开票标志</kpbz><tdqy>特定企业</tdqy><ncpqy>农产品企业</ncpqy><dxqy>电信企业</dxqy><xgmkjzpbs>小规模开具专票标识</xgmkjzpbs><esjdcbz>二手机动车标志</esjdcbz><cpybs>成品油标识</cpybs><cpybsyxq>成品油标识有效期</cpybsyxq><cpybmdbs>成品油白名单标识</cpybmdbs><cpybmdbsyxq>成品油白名单有效期</cpybmdbsyxq><xtqy>稀土企业</xtqy><jxsqbz>进项授权标志</jxsqbz></group></jbxx></returndata></body></business>";
        UserListResp userResp = JaxbUtil.toBean(xmlStr, UserListResp.class);
        UserListResp.Body body = userResp.getBody();
        String returncode = body.getReturncode();
        List<UserListResp.Group> group = body.getReturnData().getJbxx().getGroup();
        System.out.println(group);
    }

}
