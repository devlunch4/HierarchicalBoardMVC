package user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.model.PageVo;
import common.model.PageVoSearch;
import db.MybatisUtil;
import user.model.UserVo;

public class UserDao implements UserDaoI {

	//ëª¨ë“  ?‚¬?š©? ë¦¬ìŠ¤?Š¸?™”
	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		// >> users.selectAllUser >> ?„¤?„?Š¤?˜?´?Š¤.?•„?´?””
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");

		// ??› ?•´? œ
		sqlSession.close();

		// dao >> service >> ?™”ë©?
		return userList;
	}
	
	// ?‹¨?¼ ?‚¬?š©? ì¡°íšŒ
	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		sqlSession.close();

		return user;
	}

	//?˜?´ì§? ?„ ?ƒ?— ?”°ë¥? ?‚¬?š©? ì¡°íšŒ
	@Override
	public List<UserVo> selectPagingUser(PageVo pagevo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<UserVo> pageList = sqlSession.selectList("users.selectPagingUser", pagevo);
		sqlSession.close();

		return pageList;
	}

	// ëª¨ë“  ?‚¬?š©? ?ˆ˜ ì¡°íšŒ
	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		// SELECT COUNT(*) FROM users
		sqlSession.close();

		return userCnt;
	}

	//?‚¬?š©? ?ˆ˜? •
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
	
	//?‚¬?š©? ì¶”ê?
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

	//?‚¬?š©? ?‚­? œ
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

	// ?•„?´?””ë¡? ê²??ƒ‰
	@Override
	public List<UserVo> idFindUser(String userid) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.idFindUser", userid);
		session.close();
		return list;
	}

	// ?•„?´?””ë¡? ê²??ƒ‰ ?•œ ?šŒ?› ?ˆ˜
	@Override
	public int idFindUserCount(String userid) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.idFindUserCount", userid);
		session.close();
		return cnt;
	}

	// ?•„?´?””ë¡? ê²??ƒ‰?•œ ?šŒ?› ?˜?´ì§?
	@Override
	public List<UserVo> idFineUserPaging(PageVoSearch pageVoSearch) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.idFineUserPaging", pageVoSearch);
		session.close();
		return userList;
	}

	// ?´ë¦„ìœ¼ë¡? ê²??ƒ‰
	@Override
	public List<UserVo> nameFindUser(String usernm) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.nameFindUser", usernm);
		session.close();
		return list;
	}

	// ?´ë¦„ìœ¼ë¡? ê²??ƒ‰ ?•œ ?šŒ?› ?ˆ˜
	@Override
	public int nameFindUserCount(String usernm) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.nameFindUserCount", usernm);
		session.close();
		return cnt;
	}

	// ?´ë¦„ìœ¼ë¡? ê²??ƒ‰?•œ ?šŒ?› ?˜?´ì§?
	@Override
	public List<UserVo> nameFindUserPaging(PageVoSearch pageVoSearch) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.nameFindUserPaging", pageVoSearch);
		session.close();
		return userList;
	}

	// ë³„ëª…?œ¼ë¡? ê²??ƒ‰
	@Override
	public List<UserVo> aliasFindUser(String alias) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> list = session.selectList("users.aliasFindUser", alias);
		session.close();
		return list;
	}

	// ë³„ëª…?œ¼ë¡? ê²??ƒ‰?•œ ?šŒ?› ?ˆ˜
	@Override
	public int aliasFindUserCount(String alias) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = session.selectOne("users.aliasFindUserCount", alias);
		session.close();
		return cnt;
	}

	// ë³„ëª…?œ¼ë¡? ê²??ƒ‰?•œ ?šŒ?› ?˜?´ì§?
	@Override
	public List<UserVo> aliasFindUserPaging(PageVoSearch pageVoSearch) {
		SqlSession session = MybatisUtil.getSqlSession();
		List<UserVo> userList = session.selectList("users.aliasFindUserPaging", pageVoSearch);
		session.close();
		return userList;
	}

}
