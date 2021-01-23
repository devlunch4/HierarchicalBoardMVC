package user.repository;

import java.util.List;

import common.model.PageVo;
import common.model.PageVoSearch;
import user.model.UserVo;

public interface UserDaoI {

	// ?���? ?��?��?�� ?���? 조회
	List<UserVo> selectAllUser();

	// userid?�� ?��?��?��?�� ?��?��?�� ?��명의 ?���? 조회
	UserVo selectUser(String userid);

	// ?��?���? 처리
	List<UserVo> selectPagingUser(PageVo pageVo);

	// ?��?��?�� ?��체수 조회
	int selectAllUserCnt();

	// ?��?��?�� ?���? ?��?��
	int modifyUser(UserVo userVo);

	// ?��?��?�� ?���? 추�?
	int insertUser(UserVo userVo);

	// ?��?��?�� ?��?��
	int deleteUser(String userid);

	// �??��
	// �??��
	// �??��
	// ?��?��?���? �??��
	List<UserVo> idFindUser(String userid);

	List<UserVo> idFineUserPaging(PageVoSearch pageVoSearch);

	int idFindUserCount(String userid);

	// ?��름으�? �??��
	List<UserVo> nameFindUser(String usernm);

	List<UserVo> nameFindUserPaging(PageVoSearch pageVoSearch);

	int nameFindUserCount(String usernm);

	// 별명?���? �??��
	List<UserVo> aliasFindUser(String alias);

	List<UserVo> aliasFindUserPaging(PageVoSearch pageVoSearch);

	int aliasFindUserCount(String alias);
}
