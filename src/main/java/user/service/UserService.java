package user.service;

import java.util.List;

import user.model.UserVo;
import user.repository.UserDao;
import user.repository.UserDaoI;

public class UserService implements UserServiceI {
	private UserDaoI userDao = new UserDao();

	@Override
	public List<UserVo> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}
}
