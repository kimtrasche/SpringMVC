package kr.co.shincweb;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sincweb.aop.target.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)	// 이게 Jnuit으로 실행할 놈이라는 의미
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})	// 설정파일 올려야함.
public class AopMain {

	
	@Resource(name="target")	// root-context에 등록한놈 id
	private MessageService service;
	
	
	@Test	// 이놈 붙이면 메인메서드임.
	public void testDB() {
	
		//service.addMessage();
		String result = service.selectService();
		System.out.println("result:" + result);
		
	}
}
