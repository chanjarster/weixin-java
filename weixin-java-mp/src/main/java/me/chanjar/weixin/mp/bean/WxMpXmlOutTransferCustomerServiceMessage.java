package me.chanjar.weixin.mp.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.util.xml.XStreamMediaIdConverter;

@XStreamAlias("xml")
public class WxMpXmlOutTransferCustomerServiceMessage extends WxMpXmlOutMessage {

    public WxMpXmlOutTransferCustomerServiceMessage() {
        this.msgType = WxConsts.CUSTOM_MSG_TRANSFER_CUSTOMER_SERVICE;
    }
}
