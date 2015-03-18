package org.arong.egdownloader.model;
/**
 * 搜索绅士站漫画列表任务模型
 * @author dipoo
 * @since 2015-03-11
 */
public class SearchTask extends Task {
	private String date;//发布时间
	
	private String btUrl;//bt下载地址
	
	private String uploader;//上传者

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setBtUrl(String btUrl) {
		this.btUrl = btUrl;
	}

	public String getBtUrl() {
		return btUrl;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getUploader() {
		return uploader;
	}
}