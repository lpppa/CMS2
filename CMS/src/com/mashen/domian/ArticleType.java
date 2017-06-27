package com.mashen.domian;

import java.util.Date;

public class ArticleType {
	private Integer articleTypeId;
	private String articleTypeName;
	private Integer articleNumber;
	public Integer getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(Integer articleNumber) {
		this.articleNumber = articleNumber;
	}
	private Date createTime;
	private Integer typeId;
	public Integer getArticleTypeId() {
		return articleTypeId;
	}
	public void setArticleTypeId(Integer articleTypeId) {
		this.articleTypeId = articleTypeId;
	}
	public String getArticleTypeName() {
		return articleTypeName;
	}
	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "ArticleType [articleTypeId=" + articleTypeId + ", articleTypeName=" + articleTypeName
				+ ", articleNumber=" + articleNumber + ", createTime=" + createTime + ", typeId=" + typeId + "]";
	}
	
}
