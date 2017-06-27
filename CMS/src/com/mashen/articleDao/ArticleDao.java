package com.mashen.articleDao;

import java.util.List;

import com.mashen.domian.Article;
import com.mashen.domian.PageBean;

public interface ArticleDao {
	public int articleWriter(Article article);
	public int articleDelete(Integer articleId);
	public List<Article> articleShow(Article article);
	public List<Article> articleMore(PageBean pageBean);
	public List<Article> articleRepoertShow(Article article);
	public List<Article> reportPass(Integer articleId);
	public List<Article> articleLike(Integer articleId);
	public List<Article> articleRepoert(Integer articleId);
	
}
