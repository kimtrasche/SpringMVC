package kr.co.sincweb.board.sql;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.sincweb.board.model.vo.BoardVO;
import kr.co.sincweb.board.util.SincDao;

@Repository("mysqlDao")
public class MysqlDaoImpl implements SincDao {

	@Override
	public int registerServiceRow(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MysqlDaoImpl > " + obj);
		return 0;
	}

	@Override
	public List<BoardVO> listServiceRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO readServiceRow(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
