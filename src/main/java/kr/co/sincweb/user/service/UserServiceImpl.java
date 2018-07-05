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
	
}
