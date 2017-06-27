package com.mashen.domian;

public class SlideShow {
	private Integer slideShowId;
	private String slideShowName;
	private String slideShowUrl;
	private String slideShowSrc;
	private String show;
	private Integer showingNumber;
	public Integer getShowingNumber() {
		return showingNumber;
	}
	public void setShowingNumber(Integer showingNumber) {
		this.showingNumber = showingNumber;
	}
	public Integer getSlideShowId() {
		return slideShowId;
	}
	public void setSlideShowId(Integer slideShowId) {
		this.slideShowId = slideShowId;
	}
	public String getSlideShowName() {
		return slideShowName;
	}
	public void setSlideShowName(String slideShowName) {
		this.slideShowName = slideShowName;
	}
	public String getSlideShowUrl() {
		return slideShowUrl;
	}
	public void setSlideShowUrl(String slideShowUrl) {
		this.slideShowUrl = slideShowUrl;
	}
	public String getSlideShowSrc() {
		return slideShowSrc;
	}
	public void setSlideShowSrc(String slideShowSrc) {
		this.slideShowSrc = slideShowSrc;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	@Override
	public String toString() {
		return "SlideShow [slideShowId=" + slideShowId + ", slideShowName=" + slideShowName + ", slideShowUrl="
				+ slideShowUrl + ", slideShowSrc=" + slideShowSrc + ", show=" + show + ", showingNumber="
				+ showingNumber + "]";
	}
	
	
	
}
