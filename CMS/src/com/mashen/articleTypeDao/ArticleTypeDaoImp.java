package com.mashen.articleTypeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mashen.domian.Article;
import com.mashen.domian.ArticleType;
import com.mashen.domian.User;
import com.mashen.util.C3P0Util;
import com.mashen.util.myConn;
import com.mashen.util.myDate;

public class ArticleTypeDaoImp implements ArticleTypeDao {

	@Override
	public int articleTypeAdd(String articleTypeName) {
		try {
			Connection con=myConn.getCon();
			PreparedStatement ps = con.prepareStatement("insert into t_articletype set articleTypeName=?,createTime=?");
			ps.setString(1, articleTypeName);
			ps.setString(2, myDate.getDate());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int articleTypedelete(String articleTypeName) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
				return qr.update("delete from t_articleType where articleTypeName=?",articleTypeName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int articleTypeUpDate(ArticleType articleType) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
				return qr.update("update t_articleType set articleTypeName=? where articleTypeId=?",articleType.getArticleTypeName(),articleType.getArticleTypeId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ArticleType> articleTypeGet(String articleTypeName) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			if(articleTypeName==null || "".equals(articleTypeName)){
				return qr.query("select * from t_articleType", new BeanListHandler<ArticleType>(ArticleType.class));
			}else{
				return qr.query("select * from t_articleType where articleTypeName like ?", new BeanListHandler<ArticleType>(ArticleType.class),"%"+articleTypeName+"%");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<ArticleType> articleTypeCheck(String articleTypeName) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
				try {
					return qr.query("select * from t_articleType where articleTypeName = ?", new BeanListHandler<ArticleType>(ArticleType.class),articleTypeName);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return null;
	}
	public List<Article> searchByArticleTypeName(Integer articleTypeId){
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			return qr.query("select * from t_article where articletypeid=? ", new BeanListHandler<Article>(Article.class),articleTypeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
