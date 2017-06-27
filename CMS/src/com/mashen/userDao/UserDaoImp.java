package com.mashen.userDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mashen.domian.PageBean;
import com.mashen.domian.User;
import com.mashen.util.C3P0Util;
import com.mashen.util.myConn;

public class UserDaoImp implements UserDao {

	@Override
	public List<User> userLogin(User user) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			 List<User> query = qr.query("select * from t_user where userAccount=? and userPassword=?",new BeanListHandler<User>(User.class),user.getUserAccount(),user.getUserPassword());
			 return query;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User userRegister(User user) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			 List<User> query = qr.query("insert into t_user set userAccount=? and userPassword=? and username=? and usersex=? and userbirthday=? and useremail=? and userphone=? and useraddress=?",new BeanListHandler<User>(User.class),user.getUserAccount(),user.getUserPassword(),user.getUserName(),user.getUserSex(),user.getUserBirthday(),user.getUserEmail(),user.getUserPhone(),user.getUserAddress());
			 return query.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> userShow(User user) {
		System.out.println(user);
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try {
			if(user.getUserId()!=null){
				return qr.query("select * from t_user where userid=?", new BeanListHandler<User>(User.class),user.getUserId());
			}
			if(user.getUserName()==null){
				return qr.query("select * from t_user", new BeanListHandler<User>(User.class));
			}else{
				return qr.query("select * from t_user where userName like ?", new BeanListHandler<User>(User.class),user.getUserName()+"%");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int userLike(Integer articleId) {
		return 0;
	}

	@Override
	public int userReport(Integer articleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userCollection(Integer articleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> userCheck(User user) {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			try {
				if(user.getUserAccount()!=null){
					return qr.query("select useraccount from t_user where useraccount=?", new BeanListHandler<User>(User.class),user.getUserAccount());
				}else{
					return qr.query("select username from t_user where username=?", new BeanListHandler<User>(User.class),user.getUserName());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
		}
}
