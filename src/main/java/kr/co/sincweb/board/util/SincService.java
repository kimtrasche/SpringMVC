package kr.co.sincweb.board.util;

import java.util.List;

import kr.co.sincweb.board.model.vo.BoardVO;

public interface SincService {

	public int registerServiceRow(Object obj);
	
	
	public List<BoardVO> listService();
	
	public Object readService(int seq);
}
