package kr.co.sincweb.board.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.sincweb.board.model.vo.BoardVO;
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


	@Override
	public List<BoardVO> listServiceRow() {
		// TODO Auto-generated method stub
		return session.selectList("com.sinc.mybatis.mapper.board.listRow");
	}


	@Override
	public BoardVO readServiceRow(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("com.sinc.mybatis.mapper.board.readRow", map);
	}

	@Override
	public List<BoardVO> searchRow(Map<String, String> map) {
		// TODO Auto-generated method stub
		return session.selectList("com.sinc.mybatis.mapper.board.searchRow", map);
	}}
