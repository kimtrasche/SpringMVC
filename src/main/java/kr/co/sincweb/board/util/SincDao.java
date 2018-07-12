package kr.co.sincweb.board.util;

import java.util.List;
import java.util.Map;

import kr.co.sincweb.board.model.vo.BoardVO;

public interface SincDao {

	public int registerServiceRow(Object obj);

	public List<BoardVO> listServiceRow();
	
	public BoardVO readServiceRow(Map<String, Object> map);
	
	public List<BoardVO> searchRow(Map<String, String> map);
	
}
