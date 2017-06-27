package com.mashen.slideShowDao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mashen.domian.SlideShow;
import com.mashen.util.C3P0Util;

public class SlideShowDaoImp implements SlideShowDao {

	@Override
	public int slideShowAdd(SlideShow slideShow) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			 return qr.update("insert into t_slideshow VALUES(null,?,?,?,?)",slideShow.getSlideShowName(),slideShow.getSlideShowSrc(),slideShow.getSlideShowUrl(),slideShow.getShow());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int slideShowDelete(Integer slideShowId) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			 return qr.update("delete from t_slideshow where slideShowId=?",slideShowId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int slideShowUpdate(SlideShow slideShow) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			 return qr.update("update t_slideshow set slideshowname=?,slideshowurl=?,slideshowsrc=?,show=?",slideShow.getSlideShowName(),slideShow.getSlideShowSrc(),slideShow.getSlideShowUrl(),slideShow.getShow());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<SlideShow> slideShowSearch(SlideShow slideShow) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			if(slideShow.getSlideShowId()!=null){
				return qr.query("select * from t_slideshow where slideshowid=?",new BeanListHandler<SlideShow>(SlideShow.class),slideShow.getSlideShowId());
			}if(slideShow.getSlideShowName()!=null){
				return qr.query("select * from t_slideshow where slideshowname=?",new BeanListHandler<SlideShow>(SlideShow.class),slideShow.getSlideShowName());
			}else{
				return qr.query("select * from t_slideshow",new BeanListHandler<SlideShow>(SlideShow.class));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<SlideShow> slideShowing(){
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			return qr.query("select count('show') showingNumber from t_slideshow where `show`=?",new BeanListHandler<SlideShow>(SlideShow.class),"showing");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SlideShow> slideShouPush(Integer slideShowId){
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("update t_slideshow set `show`='showing' where slideshowid=?",slideShowId);
			return qr.query("select * from t_slideshow ",new BeanListHandler<SlideShow>(SlideShow.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SlideShow> slideShouPushOff(Integer slideShowId){
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			qr.update("update t_slideshow set `show`='off' where slideshowid=?",slideShowId);
			return qr.query("select * from t_slideshow ",new BeanListHandler<SlideShow>(SlideShow.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
