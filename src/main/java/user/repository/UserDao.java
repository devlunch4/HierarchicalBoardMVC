package user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.MybatisUtil;
import user.model.UserVo;

public class UserDao implements UserDaoI {

	// 전체 사용자 정보 조회
	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		sqlSession.close();

		return userList;
	}

	// userid에 해당하는 사용자 한명의 정보 조회
	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		sqlSession.close();

		return user;
	}
}
