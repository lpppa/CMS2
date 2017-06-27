package com.mashen.articleService;

import java.util.List;

import com.mashen.articleDao.ArticleDao;
import com.mashen.articleDao.ArticleDaoImp;
import com.mashen.domian.Article;
import com.mashen.domian.PageBean;

public class ArticleServiceImp implements ArticleService{
	private ArticleDao ad=new ArticleDaoImp();

	@Override
	public int articleWriter(Article article) {
		return ad.articleWriter(article);
	}

	@Override
	public int articleDelete(Integer articleId) {
		return ad.articleDelete(articleId);
	}

	@Override
	public List<Article> articleShow(Article article) {
		return ad.articleShow(article);
	}
	public List<Article> articleMore(PageBean pageBean){
		return ad.articleMore(pageBean);
	}

	@Override
	public List<Article> articleRepoertShow(Article article) {
		return ad.articleRepoertShow(article);
	}

	@Override
	public List<Article> reportPass(Integer articleId) {
		return ad.reportPass(articleId);
	}

	@Override
	public List<Article> articleLike(Integer articleId) {
		return ad.articleLike(articleId);
	}

	@Override
	public List<Article> articleRepoert(Integer articleId) {
		return ad.articleRepoert(articleId);
	}
	
}
