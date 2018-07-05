package kr.co.sincweb.user.ctrl;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	public void login(UserVO user, Model model) {	// void타입인 이유는 inserceptor post에서 처리할거기 때문임.
		
		model.addAttribute("loginUser", service.login(user));
	}
}
