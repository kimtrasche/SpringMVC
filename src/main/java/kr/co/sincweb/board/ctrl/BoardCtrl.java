package kr.co.sincweb.board.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sincweb.board.model.vo.BoardVO;
import kr.co.sincweb.board.util.SincService;

@Controller
@RequestMapping("/board")
public class BoardCtrl {
	
	@Resource(name="boardService")
	private SincService service;
	
	
	
	
	@RequestMapping(value="/registerBoard.sinc", method=RequestMethod.GET)
	public String registerForm(BoardVO obj) {
		
		return "/board/register";
	}
	
	
	
	@RequestMapping(value="/registerBoard.sinc", method=RequestMethod.POST)
	/* 파라미터 처리 유형 3가지
		// public String register(BoardVO obj) {		// 1번 유형
		// public String register(int sqq, String .~~) { // 2번 유형
		// public String register(@RequestParam(value="title") String title) { // 3번 유형
		//  public String register(@ModelAttribute("board") BoardVO obj) { // MODEL객체로 받아서 다시 리턴페이지에 MODEL객체로 전달할떄
	*/	
	public String register(BoardVO obj) {
		
		System.out.println(">> " + obj);
	
		/*
		obj.setTitle("수업 끝");
		obj.setContent("뻥입니다.");
		obj.setWriter("임섭순");
		*/
		
		int flag = service.registerServiceRow(obj);
		
		System.out.println("return flag : " + flag);
		
		return "redirect:/board/list.sinc";
	}

	
	
	@RequestMapping("/list.sinc")
	public String list(Model model) {
		
		List<BoardVO> list = service.listService();
		
		model.addAttribute("boardlists", list);
		
		System.out.println("list > " + list.size());
		
		return "/board/listAll";
	}
	
	
	@RequestMapping("/read.sinc")
	//public String read(BoardVO vo) {
	//public String read(int seq) {	
	//public String read(@RequestParam(value="seq") int seq) {
	public String read(@RequestParam(value="seq") int seq, Model model) {
		
		Object obj = service.readService(seq);
		model.addAttribute("board", obj);
		
		return "/board/read";
	}
	
	
	/*
	@RequestMapping(value="/a.sinc", method=RequestMethod.GET)
	public void doA() {
		System.out.println("BoardCtrl doA");
	}
	
	@RequestMapping("/b.sinc")
	public String doB() {
		System.out.println("BoardCtrl doB");
		return "a";
	}
	
	// 올드한 스똬일
	@RequestMapping("/c.sinc")
	public ModelAndView doC() {
		System.out.println("BoardCtrl doC");
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", "hello~");
		mv.setViewName("result");
		
		return mv;
	}

	
	// 요즘 추렌드
	@RequestMapping("/d.sinc")
	public String doD(Model model) {
		System.out.println("BoardCtrl doD");
		
		model.addAttribute("msg","model 에 심은 값");
		
		//return "result"; 
		return "redirect:/result.jsp";	// 사용자의 새로고침시 반복적 submit방지용. 의도적 에러남.
	}

	// 응답 후 다른 리퀘스트를 하고 싶을때
	@RequestMapping("/e.sinc")
	public String doE(Model model, RedirectAttributes rttr) {
		System.out.println("BoardCtrl doE");
		
		//model.addAttribute("msg","bye~");	// 리다이렉트로 하면, model 값이 전달안됨.
		rttr.addFlashAttribute("msg","bye~");
		
		return "redirect:/f.sinc"; 
	}
	
	@RequestMapping("/f.sinc")
	public String doF(@ModelAttribute String msg) {
		System.out.println("BoardCtrl doF");
		
		return "bye"; 
	}
	*/
	
	@RequestMapping("/ajax.sinc")
	@ResponseBody
	public List<BoardVO> ajaxTest() {
		System.out.print("ctrl ajax");
		
		BoardVO vo = new BoardVO();
		vo.setTitle("ajaxTest");
		vo.setContent("집에가고 싶다.");
		vo.setWriter("김경태");
		
		List<BoardVO> list = new ArrayList<>();
		list.add(vo);
		list.add(vo);
		list.add(vo);
		
		return list;
	}
	
	@RequestMapping("/search.sinc")
	@ResponseBody
	public List<BoardVO> search(String searchType, String searchKeyword) {
		System.out.println("csearch ajax: " + searchType + " | " + searchKeyword);
		
		List<BoardVO> list =service.searchService(searchType, searchKeyword);
		
		return list;
	}
	
	
}
