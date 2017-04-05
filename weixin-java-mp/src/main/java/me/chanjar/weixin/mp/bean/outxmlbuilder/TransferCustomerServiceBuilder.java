package me.chanjar.weixin.mp.bean.outxmlbuilder;

import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTransferCustomerServiceMessage;

/**
 * 客服消息builder
 * <pre>
 * 用法: WxMpCustomMessage m = WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE().content(...).toUser(...).build();
 * </pre>
 *
 * @author chanjarster
 */
public final class TransferCustomerServiceBuilder extends BaseBuilder<TransferCustomerServiceBuilder, WxMpXmlOutTransferCustomerServiceMessage> {
  private String kfAccount;

  public TransferCustomerServiceBuilder kfAccount(String kfAccount) {
    this.kfAccount = kfAccount;
    return this;
  }


  public WxMpXmlOutTransferCustomerServiceMessage build() {
    WxMpXmlOutTransferCustomerServiceMessage m = new WxMpXmlOutTransferCustomerServiceMessage();
    setCommon(m);
    if(StringUtils.isNotBlank(kfAccount)){
      WxMpXmlOutTransferCustomerServiceMessage.TransInfo transInfo = new WxMpXmlOutTransferCustomerServiceMessage.TransInfo();
      transInfo.setKfAccount(kfAccount);
      m.setTransInfo(transInfo);
    }
    return m;
  }
}
