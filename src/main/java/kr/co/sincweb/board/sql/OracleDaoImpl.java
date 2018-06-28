package kr.co.sincweb.board.sql;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sincweb.board.util.SincDao;

@Repository("oracleDao")
public class OracleDaoImpl implements SincDao {

	@Resource(name="sqlSession")	// root-context.xml에 빈객체로 등록되어있음.
	private SqlSession session;
	
	
	@Override
	public int registerServiceRow(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("OracleDaoImple > " + obj);
		
		//return session.insert("insertRow", obj);
		return session.insert("com.sinc.mybatis.mapper.board.insertRow", obj);
	}

}
