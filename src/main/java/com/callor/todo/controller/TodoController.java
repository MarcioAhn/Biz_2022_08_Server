package com.callor.todo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		List<TodoVO> todo = todoService.selectAll();
		model.addAttribute("TODO",todo);
		return null;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(TodoVO todoVO, 
			Model model) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat toTime = new SimpleDateFormat("HH:mm:SS");
		
		String tt = todoVO.getT_content();
		
		
		TodoVO todo = TodoVO.builder()
				 		.t_content(tt)
						.t_sdate(toDay.format(date))
						.t_stime(toTime.format(date))
						
						.build();
		
			todoService.insert(todo);
	
		return "redirect:/todo/insert";
	

	}

	@RequestMapping(value="/{seq}/update",method=RequestMethod.GET)
	public String update(@PathVariable("seq") long seq, Model model) {

		TodoVO todo = todoService.findById(seq);
		log.debug("여기입니다" + todo.toString());
		model.addAttribute("TODO", todo);
		return "todo/update";
	}
	@RequestMapping(value="/{seq}/update",method=RequestMethod.POST) 
	public String update(
			@PathVariable("seq") long seq,
			 String t_content) {
		TodoVO todo = todoService.findById(seq);
		
		todo.setT_content(t_content);
		todoService.update(todo);
		
		return "redirect:/todo/insert";
	}
	@RequestMapping(value="/{seq}/complete",method=RequestMethod.GET)
	public String complete(TodoVO todoVO) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat toTime = new SimpleDateFormat("HH:mm:SS");
	
		todoVO.setT_edate(toDay.format(date));
		todoVO.setT_etime(toTime.format(date));
		
		todoService.complete(todoVO);
		
	
			return "redirect:/todo/insert";
	}



}
