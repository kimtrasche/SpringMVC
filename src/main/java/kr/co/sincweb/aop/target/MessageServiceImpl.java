package kr.co.sincweb.aop.target;

import org.springframework.stereotype.Service;

@Service("target")
public class MessageServiceImpl implements MessageService {

	@Override
	public void addMessage() {
		System.out.println("dao.create()");
		System.out.println("dao.updatePoint()");
	}

	@Override
	public String selectService() {

		System.out.println("dao.selectRow()");
		
		return "유기찬님 안뇽";
	}

}
