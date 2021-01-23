package user.repository;

import java.util.List;

import common.model.PageVo;
import common.model.PageVoSearch;
import user.model.UserVo;

public interface UserDaoI {

	// ? „ì²? ?‚¬?š©? ? •ë³? ì¡°íšŒ
	List<UserVo> selectAllUser();

	// userid?— ?•´?‹¹?•˜?Š” ?‚¬?š©? ?•œëª…ì˜ ? •ë³? ì¡°íšŒ
	UserVo selectUser(String userid);

	// ?˜?´ì§? ì²˜ë¦¬
	List<UserVo> selectPagingUser(PageVo pageVo);

	// ?‚¬?š©? ? „ì²´ìˆ˜ ì¡°íšŒ
	int selectAllUserCnt();

	// ?‚¬?š©? ? •ë³? ?ˆ˜? •
	int modifyUser(UserVo userVo);

	// ?‚¬?š©? ? •ë³? ì¶”ê?
	int insertUser(UserVo userVo);

	// ?‚¬?š©? ?‚­? œ
	int deleteUser(String userid);

	// ê²??ƒ‰
	// ê²??ƒ‰
	// ê²??ƒ‰
	// ?•„?´?””ë¡? ê²??ƒ‰
	List<UserVo> idFindUser(String userid);

	List<UserVo> idFineUserPaging(PageVoSearch pageVoSearch);

	int idFindUserCount(String userid);

	// ?´ë¦„ìœ¼ë¡? ê²??ƒ‰
	List<UserVo> nameFindUser(String usernm);

	List<UserVo> nameFindUserPaging(PageVoSearch pageVoSearch);

	int nameFindUserCount(String usernm);

	// ë³„ëª…?œ¼ë¡? ê²??ƒ‰
	List<UserVo> aliasFindUser(String alias);

	List<UserVo> aliasFindUserPaging(PageVoSearch pageVoSearch);

	int aliasFindUserCount(String alias);
}
