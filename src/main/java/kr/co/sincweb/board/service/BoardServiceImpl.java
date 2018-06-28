package kr.co.sincweb.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sincweb.board.util.SincDao;
import kr.co.sincweb.board.util.SincService;

@Service("boardService")
public class BoardServiceImpl implements SincService {

	@Autowired
	private SincDao oracleDao, mysqlDao;
	
	/*
	@Autowired
	public void setDao(SincDao oracleDao, SincDao mysqlDao) {
		this.oracleDao = oracleDao;
		this.mysqlDao = mysqlDao;
	}
	*/
	
	
	@Override
	public int registerServiceRow(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("Service registerService");
		return oracleDao.registerServiceRow(obj);
	}

}
