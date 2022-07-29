package com.walab.camp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.walab.camp.service.CommentService;
import com.walab.camp.vo.CommentVO;

@Controller
public class CommentControlller {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value  ="/comment/list", method =  RequestMethod.GET)
	public String commentlist(Model model) {
		model.addAttribute("list", commentService.getCommentList());
		return "/comment/comment";
	}
	
	@RequestMapping(value  ="/comment/add", method =  RequestMethod.GET)
	public String addPost() {
		return "/comment/addform";
	}
	
	@RequestMapping(value  ="/comment/addok", method =  RequestMethod.POST)
	public String addPostOK(CommentVO vo) {
		int i = commentService.insert(vo);
		if(i==0)
			System.out.println("데이터 추가 실패");
		else
			System.out.println("데이터 추가 성공");
		return "redirect:/comment/list";
	}
	
	@RequestMapping(value  ="/comment/edit/{id}", method =  RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		CommentVO commentVO = commentService.getComment(id);
		model.addAttribute("commentVO", commentVO);
		return "/comment/editform";
	}
	
	@RequestMapping(value  ="/comment/editok", method =  RequestMethod.POST)
	public String editPostOK(CommentVO vo) {
		int i = commentService.update(vo);
		if(i==0)
			System.out.println("데이터 수정 실패");
		else
			System.out.println("데이터 수정 성공");
		return "redirect:/comment/list";
//		return "redirect:list";
	}
	
	@RequestMapping(value  ="/comment/delete/{id}", method =  RequestMethod.GET)
	public String deleteOK(@PathVariable("id") int id) {
		commentService.delete(id);
		return "redirect:/comment/list";
	}

}
