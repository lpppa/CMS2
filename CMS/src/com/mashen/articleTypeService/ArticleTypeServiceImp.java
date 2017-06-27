package com.mashen.articleTypeService;

import java.util.List;

import com.mashen.articleService.ArticleService;
import com.mashen.articleTypeDao.ArticleTypeDao;
import com.mashen.articleTypeDao.ArticleTypeDaoImp;
import com.mashen.domian.Article;
import com.mashen.domian.ArticleType;

public class ArticleTypeServiceImp implements ArticleTypeService {
	private ArticleTypeDao ad=new ArticleTypeDaoImp();

	@Override
	public List<ArticleType> articleTypeGet(String articleTypeName) {
		return ad.articleTypeGet(articleTypeName);
	}
	
	public List<ArticleType> articleTypeCheck(String articleTypeName) {
		return ad.articleTypeCheck(articleTypeName);
	}

	@Override
	public int articleTypeAdd(String articleTypeName) {
		return ad.articleTypeAdd(articleTypeName);
	}

	@Override
	public int articleTypedelete(String articleTypeName) {
		return ad.articleTypedelete(articleTypeName);
	}

	@Override
	public int articleTypeUpDate(ArticleType articleType) {
		return ad.articleTypeUpDate(articleType);
	}
	
	public List<Article> searchByArticleTypeName(Integer articleTypeId){
		return ad.searchByArticleTypeName(articleTypeId);
	}
	
}
