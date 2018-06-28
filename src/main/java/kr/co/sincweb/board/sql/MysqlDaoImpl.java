package kr.co.sincweb.board.sql;

import org.springframework.stereotype.Repository;

import kr.co.sincweb.board.util.SincDao;

@Repository("mysqlDao")
public class MysqlDaoImpl implements SincDao {

	@Override
	public int registerServiceRow(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("MysqlDaoImpl > " + obj);
		return 0;
	}

}
