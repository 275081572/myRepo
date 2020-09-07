package com.cn.smart.socket;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.xpath.XPathConstants;
import java.util.List;

public class HutoolXml {
    public static void main(String[] args) {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"gbk\"?><business id=\"91001\" comment=\"纳税人基本信息查询\"><body><returncode>返回代码</returncode><returnmsg>返回信息</returnmsg><returndata><jbxx count=\"n\"><group xh=\"1\"><xnsbh>虚拟设备号</xnsbh><nsrsbh>纳税人识别号</nsrsbh><nsrmc>纳税人名称</nsrmc><swjgdm>税务机关代码</swjgdm><swjgmc>税务机关名称</swjgmc><fplxdm>发票类型代码</fplxdm><dqsz>当前时钟</dqsz><djsj>登记时间</djsj><bbh>版本号</bbh><kpjh>开票机号</kpjh><qylx>企业类型</qylx><djxh>登记序号</djxh><kpbz>开票标志</kpbz><tdqy>特定企业</tdqy><ncpqy>农产品企业</ncpqy><dxqy>电信企业</dxqy><xgmkjzpbs>小规模开具专票标识</xgmkjzpbs><esjdcbz>二手机动车标志</esjdcbz><cpybs>成品油标识</cpybs><cpybsyxq>成品油标识有效期</cpybsyxq><cpybmdbs>成品油白名单标识</cpybmdbs><cpybmdbsyxq>成品油白名单有效期</cpybmdbsyxq><xtqy>稀土企业</xtqy><jxsqbz>进项授权标志</jxsqbz></group></jbxx></returndata></body></business>";
        Document docResult= XmlUtil.readXML(xmlStr);
        Object value = XmlUtil.getByXPath("//business/body/returncode",
                docResult, XPathConstants.STRING);
        System.out.println(value);

        List<Element> returndata = XmlUtil.getElements(docResult.getDocumentElement(), null);
        System.out.println(returndata);

//        XmlUtil.parseXml(xmlStr);
//        XmlUtil.readXML(xmlStr);
    }

}
