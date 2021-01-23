package user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.model.PageVo;
import common.model.PageVoSearch;
import db.MybatisUtil;
import user.model.UserVo;

public class UserDao implements UserDaoI {

	//λͺ¨λ  ?¬?©? λ¦¬μ€?Έ?
	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		// >> users.selectAllUser >> ?€??€??΄?€.??΄?
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");

		// ?? ?΄? 
		sqlSession.close();

		// dao >> service >> ?λ©?
		return userList;
	}
	
	// ?¨?Ό ?¬?©? μ‘°ν
	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		sqlSession.close();

		return user;
	}

	//??΄μ§? ? ?? ?°λ₯? ?¬?©? μ‘°ν
	@Override
	public List<UserVo> selectPagingUser(PageVo pagevo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<UserVo> pageList = sqlSession.selectList("users.selectPagingUser", pagevo);
		sqlSession.close();

		return pageList;
	}

	// λͺ¨λ  ?¬?©? ? μ‘°ν
	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		// SELECT COUNT(*) FROM users
		sqlSession.close();

		return userCnt;
	}

	//?¬?©? ?? 
	@Override
	public int modifyUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("users.modifyUser", userVo);
		if (updateCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}
	
	//?¬?©? μΆκ?
	@Override
	public int insertUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = sqlSession.update("users.insertUser", userVo);
		if (insertCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return insertCnt;
	}

	//?¬?©? ?­? 
	@Override
	public int deleteUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("users.deleteUser", userid);
		if (deleteCnt == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	// ??΄?λ‘? κ²??
	@Override
	public List<UserVo> idFindUser(String userid) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.idFindUser", userid);
		session.close();
		return list;
	}

	// ??΄?λ‘? κ²?? ? ?? ?
	@Override
	public int idFindUserCount(String userid) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.idFindUserCount", userid);
		session.close();
		return cnt;
	}

	// ??΄?λ‘? κ²??? ?? ??΄μ§?
	@Override
	public List<UserVo> idFineUserPaging(PageVoSearch pageVoSearch) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.idFineUserPaging", pageVoSearch);
		session.close();
		return userList;
	}

	// ?΄λ¦μΌλ‘? κ²??
	@Override
	public List<UserVo> nameFindUser(String usernm) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.nameFindUser", usernm);
		session.close();
		return list;
	}

	// ?΄λ¦μΌλ‘? κ²?? ? ?? ?
	@Override
	public int nameFindUserCount(String usernm) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.nameFindUserCount", usernm);
		session.close();
		return cnt;
	}

	// ?΄λ¦μΌλ‘? κ²??? ?? ??΄μ§?
	@Override
	public List<UserVo> nameFindUserPaging(PageVoSearch pageVoSearch) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.nameFindUserPaging", pageVoSearch);
		session.close();
		return userList;
	}

	// λ³λͺ?Όλ‘? κ²??
	@Override
	public List<UserVo> aliasFindUser(String alias) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.aliasFindUser", alias);
		session.close();
		return list;
	}

	// λ³λͺ?Όλ‘? κ²??? ?? ?
	@Override
	public int aliasFindUserCount(String alias) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.aliasFindUserCount", alias);
		session.close();
		return cnt;
	}

	// λ³λͺ?Όλ‘? κ²??? ?? ??΄μ§?
	@Override
	public List<UserVo> aliasFindUserPaging(PageVoSearch pageVoSearch) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.aliasFindUserPaging", pageVoSearch);
		session.close();
		return userList;
	}

}
