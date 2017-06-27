package com.mashen.domian;

import java.util.Date;

public class Article {
	private Integer articleId;
	private String articleTitle;
	private Integer userAccountId;
	private String articlepicture;
	private String articleContent;
	private Integer hits;
	private Integer likeNumber;
	private Integer reportNumber;
	private Integer aricleTypeId;
	private String userName;
	private String articleTypeName;
	private Integer typeId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getArticleTypeName() {
		return articleTypeName;
	}
	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public Integer getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(Integer userAccountId) {
		this.userAccountId = userAccountId;
	}
	
	public String getarticlepicture() {
		return articlepicture;
	}
	public void setarticlepicture(String articlepicture) {
		this.articlepicture = articlepicture;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getLikeNumber() {
		return likeNumber;
	}
	public void setLikeNumber(Integer likeNumber) {
		this.likeNumber = likeNumber;
	}
	public Integer getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(Integer reportNumber) {
		this.reportNumber = reportNumber;
	}
	public Integer getAricleTypeId() {
		return aricleTypeId;
	}
	public void setAricleTypeId(Integer aricleTypeId) {
		this.aricleTypeId = aricleTypeId;
	}
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle=" + articleTitle + ", userAccountId=" + userAccountId
				+ ", articlepicture=" + articlepicture + ", articleContent=" + articleContent + ", hits=" + hits
				+ ", likeNumber=" + likeNumber + ", reportNumber=" + reportNumber + ", aricleTypeId=" + aricleTypeId
				+ ", userName=" + userName + ", articleTypeName=" + articleTypeName + ", typeId=" + typeId + "]";
	}
	
	
	
	
}
