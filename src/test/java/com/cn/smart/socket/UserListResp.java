package com.cn.smart.socket;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

@Data
@XStreamAlias("business")
public class UserListResp {

    @XStreamAsAttribute
    private String id;
    @XStreamAsAttribute
    private String comment;
    @XStreamAlias("body")
    private Body body;

    @Data
    @XStreamAlias("body")
    public static class Body{
        private String returncode;
        private String returnmsg;
        @XStreamAlias("returndata")
        private ReturnData returnData;
    }

    @Data
    @XStreamAlias("returndata")
    public static class ReturnData{
        @XStreamAlias("jbxx")
        private Jbxx jbxx;
    }

    @Data
    @XStreamAlias("jbxx")
    public static class Jbxx{
        @XStreamAsAttribute
        private String count;
        @XStreamImplicit(itemFieldName="group")
        private List<Group> group;
    }

    @Data
    @XStreamAlias("group")
    public static class Group{
        @XStreamAsAttribute
        private String xh;
        private String xnsbh;
        private String nsrsbh;
        private String nsrmc;
        private String swjgdm;
        private String swjgmc;
        private String fplxdm;
        private String dqsz;
        private String djsj;
        private String bbh;
        private String kpjh;
        private String qylx;
        private String djxh;
        private String kpbz;
        private String tdqy;
        private String ncpqy;
        private String dxqy;
        private String xgmkjzpbs;
        private String esjdcbz;
        private String cpybs;
        private String cpybsyxq;
        private String cpybmdbs;
        private String cpybmdbsyxq;
        private String xtqy;
        private String jxsqbz;
    }

}
