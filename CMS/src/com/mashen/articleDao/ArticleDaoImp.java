package com.mashen.articleDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mashen.domian.Article;
import com.mashen.domian.ArticleType;
import com.mashen.domian.PageBean;
import com.mashen.util.C3P0Util;
import com.mashen.util.myConn;
import com.mashen.util.myDate;
import com.mashen.util.myProperties;

public class ArticleDaoImp implements ArticleDao {

	@Override
	public int articleWriter(Article article) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		System.out.println("dao:"+article);
		try {
			return qr.update("insert into t_article set articletitle=?,useraccountid=?,articlepicture=?,articlecontent=?,articletypeid=?",
					article.getArticleTitle(),
					article.getUserAccountId(),
					article.getarticlepicture(),
					article.getArticleContent(),
					article.getAricleTypeId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return 0;
	}
	@Override
	public int articleDelete(Integer articleId) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			try {
				return qr.update("delete from t_article where articleid=?",articleId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}

	@Override
	public List<Article> articleShow(Article article) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			if(article.getArticleId()!=null){
				return qr.query("select * from t_article,t_user where t_article.useraccountid=t_user.userid and articleid=?", new BeanListHandler<Article>(Article.class),article.getArticleId());
			}else if(article.getArticleTitle()!=null){
				return qr.query("select * from t_article,t_user where t_article.useraccountid=t_user.userid and articletitle like ?", new BeanListHandler<Article>(Article.class),"%"+article.getArticleTitle()+"%");
			}else{
				return qr.query("select * from t_article,t_user where t_article.useraccountid=t_user.userid  LIMIT 0,5", new BeanListHandler<Article>(Article.class));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Article> articleMore(PageBean pageBean){
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			return qr.query("select * from t_article LIMIT ?,?",new BeanListHandler<Article>(Article.class),pageBean.getCurrentPage(),pageBean.getPageNum());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Article> reportPass(Integer articleId){
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("UPDATE t_article SET reportnumber=0 where articleid=?",articleId);
			return qr.query("select * from t_article where reportnumber!=0", new BeanListHandler<Article>(Article.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Article> articleLike(Integer articleId){
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("UPDATE t_article SET likenumber=likenumber+1 where articleid=?",articleId);
			return qr.query("select likenumber from t_article where articleid=?", new BeanListHandler<Article>(Article.class),articleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Article> articleRepoert(Integer articleId){
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("UPDATE t_article SET reportnumber=reportnumber+1 where articleid=?",articleId);
			return qr.query("select reportnumber from t_article where articleid=?", new BeanListHandler<Article>(Article.class),articleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Article> articleRepoertShow(Article article){
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			if(article.getArticleId()!=null){
				return qr.query("select * from t_article,t_user where t_article.useraccountid=t_user.userid and articleid=? and reportnumber!=0", new BeanListHandler<Article>(Article.class),article.getArticleId());
			}else if(article.getArticleTitle()!=null || "".equals(article.getArticleTitle())){
				return qr.query("select * from t_article,t_user where t_article.useraccountid=t_user.userid and reportnumber!=0 and articletitle=?", new BeanListHandler<Article>(Article.class),article.getArticleTitle());
			}else{
				return qr.query("select * from t_article,t_user where t_article.useraccountid=t_user.userid and reportnumber!=0", new BeanListHandler<Article>(Article.class));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
