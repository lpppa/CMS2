package com.mashen.userService;

import java.util.List;

import com.mashen.domian.PageBean;
import com.mashen.domian.User;
import com.mashen.userDao.UserDao;
import com.mashen.userDao.UserDaoImp;

public class UserServiceImp implements UserService {
	private UserDao ud=new UserDaoImp();
	//ͷ���ŵ�¼
	@Override
	public List<User> userLogin(User user) {
		return ud.userLogin(user);
	}
	//ͷ����ע��
	@Override
	public User userRegister(User user) {
		return ud.userRegister(user);
	}
	//����ͷ����
	@Override
	public List<User> userShow(User user) {
		return ud.userShow(user);
	}
	//����
	@Override
	public int userLike(Integer articleId) {
		return ud.userLike(articleId);
	}
	//�ٱ�
	@Override
	public int userReport(Integer articleId) {
		return ud.userReport(articleId);
	}
	//�ղ�
	@Override
	public int userCollection(Integer articleId) {
		return ud.userCollection(articleId);
	}
	@Override
	public List<User> userCheck(User user) {
		return ud.userCheck(user);
	}

}
