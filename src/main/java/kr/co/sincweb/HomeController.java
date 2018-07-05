package kr.co.sincweb;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main.sinc")
	public String home(Locale locale, Model model) {
		
		System.out.println("homeCtrl main");
		
		return "home";
	}
	
	// INterceptor 테스트
	@RequestMapping(value = "/pre.sinc")
	public String pre(Locale locale, Model model) {
		
		System.out.println("homeCtrl pre");
		
		model.addAttribute("msg","로그인되었습니다.");
		
		return "home";
	}
	
	
	@RequestMapping(value = "/session.sinc")
	public String session(Locale locale, Model model) {
		
		System.out.println("homeCtrl  session");
		
		return "result";
	}
	
	// INterceptor 테스트
	@RequestMapping(value = "/post.sinc")
	public String post(Locale locale, Model model) {
		
		System.out.println("homeCtrl post");
		
		return "home";
	}
}
