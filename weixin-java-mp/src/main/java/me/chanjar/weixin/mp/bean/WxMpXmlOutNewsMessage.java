package me.chanjar.weixin.mp.bean;

import java.util.ArrayList;
import java.util.List;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class WxMpXmlOutNewsMessage extends WxMpXmlOutMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XStreamAlias("ArticleCount")
	protected int articleCount;

	@XStreamAlias("Articles")
	protected final List<Item> articles = new ArrayList<Item>();

	public WxMpXmlOutNewsMessage() {
		this.msgType = WxConsts.XML_MSG_NEWS;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void addArticle(Item item) {
		this.articles.add(item);
		this.articleCount = this.articles.size();
	}

	public List<Item> getArticles() {
		return articles;
	}

	@XStreamAlias("item")
	public static class Item {

		@XStreamAlias("Title")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String Title;

		@XStreamAlias("Description")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String Description;

		@XStreamAlias("PicUrl")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String PicUrl;

		@XStreamAlias("Url")
		@XStreamConverter(value = XStreamCDataConverter.class)
		private String Url;

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getPicUrl() {
			return PicUrl;
		}

		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}

		public String getUrl() {
			return Url;
		}

		public void setUrl(String url) {
			Url = url;
		}

	}

}
