package com.walab.camp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.walab.camp.dao.UserDAO;
import com.walab.camp.vo.UserVO;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	UserDAO userService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "/login/login";
	}

	@RequestMapping(value = "loginOk", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO vo, Model model) {
		String returnURL = "";
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}

		String msg = " ";
		UserVO loginvo = userService.getUser(vo);
		if (loginvo != null) { // 로그인 성공
			System.out.println("로그인 성공!");
			session.setAttribute("login", loginvo);
			returnURL = "redirect:/comment/list";
			
		} else {
			System.out.println("로그인 실패!");
			msg = "로그인 실패: 존재하지 않는 아이디입니다.";
			model.addAttribute("msg", msg);
			return "/login/signinAlert";
		}
		return returnURL;
		
	}

	// 로그아웃 하는 부분
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "signin", method = RequestMethod.GET)
	public String signin() {
		return "/login/signin";
	}
	
	
	@RequestMapping(value = "signinok", method = RequestMethod.POST)
	public String signinoK(HttpSession session, UserVO vo, Model model) {
		System.out.println("중복체크 들어옴!");
		String msg = " ";
		UserVO signinvo = userService.getDuplicatedUser(vo);
		if (signinvo != null) { // 중복 데이터 존재
			System.out.println("중복 데이터 존재!");
			msg = "회원가입 실패: 이미 사용 중인 아이디나 닉네임 입니다.";
		} else {// 중복 데이터 없음
			int i = userService.insertUser(vo);
			if (i==0) {
				System.out.println("회원 추가 실패!");
				msg = "회원가입 실패: 다시 회원가입을 진행해주세요.";
			}	
			else {
				System.out.println("회원 추가 성공!!!");
				msg = "축하합니다! 회원가입을 완료했습니다.";
			}	
		}
		model.addAttribute("msg", msg);
		return "/login/signinAlert";
	}
}
