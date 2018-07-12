package kr.co.sincweb.user.ctrl;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.sincweb.user.model.vo.UserVO;
import kr.co.sincweb.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
//@SessionAttributes("loginUser")		// Model scope에서 session 전역으로 확장시킴
public class UserCtrl {
	
	@Inject
	private UserServiceImpl service;
	
	
	@RequestMapping("/loginForm.sinc")
	public String loginForm() {
		return "user/login";
	}
	
	@RequestMapping("/login.sinc")
	public void login(@ModelAttribute UserVO user, Model model) {	// void타입인 이유는 inserceptor post에서 처리할거기 때문임.
		
		System.out.println("/login.sin --> " + user);
		model.addAttribute("loginUser", service.login(user));
	}
	
	// 회원가입폼
	@RequestMapping("/joinForm.sinc")
	public String joinForm() {
		return "user/join";
	}
	
	
	// 회원등록
	@RequestMapping("/join.sinc")
	public String joinUser(UserVO user, RedirectAttributes rttr, Model model) {
		System.out.println("join user >> " + user.toString());
		
		// 이미 등록되어있으면, 취소시킨다.
		int existCnt = service.existUser(user);
		if(existCnt > 0 ) {
			model.addAttribute("msg", "EXIST");
			return "user/join";
		}
		
		
		// 없으면, 새로 등록 후 메인 로그인한채로 메인페이지 이동
		int flag = service.joinUser(user);
		
		System.out.println("return flag : " + flag);
		
		rttr.addFlashAttribute(user);
		
		return "redirect:/user/login.sinc";
	}
}
