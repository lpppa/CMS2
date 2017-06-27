package com.mashen.articleTypeService;

import java.util.List;

import com.mashen.domian.Article;
import com.mashen.domian.ArticleType;

public interface ArticleTypeService {
	public int articleTypeAdd(String articleTypeName);
	public int articleTypedelete(String articleTypeName);
	public int articleTypeUpDate(ArticleType articleType);
	public List<ArticleType> articleTypeGet(String articleTypeName);
	public List<Article> searchByArticleTypeName(Integer articleTypeId);
}
