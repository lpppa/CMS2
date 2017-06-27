package com.mashen.domian;

public class Advertisement {
	private Integer advertisementId;
	private String advertisementName;
	private String advertisementUrl;
	private String advertisementImg;
	public Integer getAdvertisementId() {
		return advertisementId;
	}
	public void setAdvertisementId(Integer advertisementId) {
		this.advertisementId = advertisementId;
	}
	public String getAdvertisementName() {
		return advertisementName;
	}
	public void setAdvertisementName(String advertisementName) {
		this.advertisementName = advertisementName;
	}
	public String getAdvertisementUrl() {
		return advertisementUrl;
	}
	public void setAdvertisementUrl(String advertisementUrl) {
		this.advertisementUrl = advertisementUrl;
	}
	
	public String getAdvertisementImg() {
		return advertisementImg;
	}
	public void setAdvertisementImg(String advertisementImg) {
		this.advertisementImg = advertisementImg;
	}
	@Override
	public String toString() {
		return "Advertisement [advertisementId=" + advertisementId + ", advertisementName=" + advertisementName
				+ ", advertisementUrl=" + advertisementUrl + ", advertisementImg=" + advertisementImg + "]";
	}
	
}
