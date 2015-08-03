package me.chanjar.weixin.mp.bean.outxmlbuilder;

import me.chanjar.weixin.mp.bean.WxMpXmlOutTransferCustomerServiceMessage;

/**
 * 客服消息builder
 * <pre>
 * 用法: WxMpCustomMessage m = WxMpCustomMessage.TEXT().content(...).toUser(...).build();
 * </pre>
 *
 * @author chanjarster
 */
public final class TransferCustomerServiceBuilder extends BaseBuilder<TransferCustomerServiceBuilder, WxMpXmlOutTransferCustomerServiceMessage> {
    public WxMpXmlOutTransferCustomerServiceMessage build() {
        WxMpXmlOutTransferCustomerServiceMessage m = new WxMpXmlOutTransferCustomerServiceMessage();
        setCommon(m);
        return m;
    }
}
