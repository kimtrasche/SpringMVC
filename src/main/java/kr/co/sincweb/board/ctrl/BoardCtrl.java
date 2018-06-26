package kr.co.sincweb.board.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardCtrl {
	
	
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
}
