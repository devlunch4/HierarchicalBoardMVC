package user.repository;

import java.util.List;

import common.model.PageVo;
import common.model.PageVoSearch;
import user.model.UserVo;

public interface UserDaoI {

	// ? μ²? ?¬?©? ? λ³? μ‘°ν
	List<UserVo> selectAllUser();

	// userid? ?΄?Ή?? ?¬?©? ?λͺμ ? λ³? μ‘°ν
	UserVo selectUser(String userid);

	// ??΄μ§? μ²λ¦¬
	List<UserVo> selectPagingUser(PageVo pageVo);

	// ?¬?©? ? μ²΄μ μ‘°ν
	int selectAllUserCnt();

	// ?¬?©? ? λ³? ?? 
	int modifyUser(UserVo userVo);

	// ?¬?©? ? λ³? μΆκ?
	int insertUser(UserVo userVo);

	// ?¬?©? ?­? 
	int deleteUser(String userid);

	// κ²??
	// κ²??
	// κ²??
	// ??΄?λ‘? κ²??
	List<UserVo> idFindUser(String userid);

	List<UserVo> idFineUserPaging(PageVoSearch pageVoSearch);

	int idFindUserCount(String userid);

	// ?΄λ¦μΌλ‘? κ²??
	List<UserVo> nameFindUser(String usernm);

	List<UserVo> nameFindUserPaging(PageVoSearch pageVoSearch);

	int nameFindUserCount(String usernm);

	// λ³λͺ?Όλ‘? κ²??
	List<UserVo> aliasFindUser(String alias);

	List<UserVo> aliasFindUserPaging(PageVoSearch pageVoSearch);

	int aliasFindUserCount(String alias);
}
