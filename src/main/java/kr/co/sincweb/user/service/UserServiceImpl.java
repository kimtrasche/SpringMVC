package kr.co.sincweb.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.sincweb.user.model.sql.UserDaoImpl;
import kr.co.sincweb.user.model.vo.UserVO;

@Service("userService")
public class UserServiceImpl {

	@Resource(name="userDao")
	private UserDaoImpl dao;
	
	public UserVO login(UserVO user) {
		return dao.loginRow(user);
	}

	// 회원등록
	public int joinService(UserVO user) {
		return dao.joinRow(user);
	}
	
	// 기 등록 유저 체크
	public int existUser(UserVO user) {
		return dao.existUser(user);
	}

}
