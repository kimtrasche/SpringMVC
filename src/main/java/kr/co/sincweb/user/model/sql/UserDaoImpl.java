package kr.co.sincweb.user.model.sql;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sincweb.user.model.vo.UserVO;

@Repository("userDao")
public class UserDaoImpl {

	@Resource(name="sqlSession")	
	private SqlSession session;
	
	public UserVO loginRow(UserVO user) {
		// TODO Auto-generated method stub
		return session.selectOne("com.sinc.mybatis.mapper.user.loginRow", user);
	}
	
	// 회원등록
	public int joinRow(UserVO user) {
		return session.insert("com.sinc.mybatis.mapper.user.joinRow", user);
	}
	
	// 기 유저정보 체크
	public int existUser(UserVO user) {
		return session.selectOne("com.sinc.mybatis.mapper.user.existUser", user);
	}
}
