package user.repository;

import java.util.List;

import user.model.UserVo;

public interface UserDaoI {

	// 전체 사용자 정보 조회
	List<UserVo> selectAllUser();

	// userid에 해당하는 사용자 한명의 정보 조회
	UserVo selectUser(String userid);

}
