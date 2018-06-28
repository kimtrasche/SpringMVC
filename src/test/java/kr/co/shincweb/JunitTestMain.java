package kr.co.shincweb;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sincweb.board.model.vo.BoardVO;
import kr.co.sincweb.board.util.SincDao;

@RunWith(SpringJUnit4ClassRunner.class)	// 이게 Jnuit으로 실행할 놈이라는 의미
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})	// 설정파일 올려야함.
public class JunitTestMain {

	
	@Resource(name="oracleDao")
	private SincDao dao;
	
	
	@Test	// 이놈 붙이면 메인메서드임.
	public void testDB() {
	
		BoardVO obj = new BoardVO();

		obj.setTitle("수업 끝");
		obj.setContent("레알");
		obj.setWriter("김경태");

		int flag = dao.registerServiceRow(obj);
		
		System.out.println("falg:" + flag);
	}
}
