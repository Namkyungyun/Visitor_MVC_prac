package com.namkyung.prac.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.namkyung.prac.service.VisitorService;
import com.namkyung.prac.vo.VisitorVO;


@Controller
public class VisitorController {
	
	@Autowired
	private VisitorService vservice;
	
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/session")
	public String session(HttpSession session,String nickname) {
		session.setAttribute("nickname", nickname);
		return "redirect:/visitor";
	}
	
	@RequestMapping("/visitor")
	public String visitor(String nickname, Model model) {
		
		List<VisitorVO> vlist = vservice.searchVisitor();
		model.addAttribute("vlist",vlist);
		return "visitor";
	}
	@RequestMapping("/regist")
	public String regist(VisitorVO vvo) {
		int result = vservice.insertVisitor(vvo);
		
		return "redirect:/visitor";
	}
	
	@RequestMapping("/update")
	public String update(VisitorVO vvo) {
		
		int result = vservice.updateVisitor(vvo);
		
		return "redirect:/visitor";
	}
	
	@RequestMapping("/delete")
	public String delete(int vno) {
		
		int result = vservice.deleteVisitor(vno);
		
		return "redirect:/visitor";
		
	}
	@RequestMapping("/sessionOut")
	public String sessionOut(HttpSession session, String nickname) {
		session.removeAttribute(nickname);
		return "index";
	}
}
