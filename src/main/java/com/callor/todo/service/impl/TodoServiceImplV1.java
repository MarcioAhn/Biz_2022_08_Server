package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service
public class TodoServiceImplV1 implements TodoService{

	private TodoDao todoDao;

	public TodoServiceImplV1(TodoDao todoDao) {
		this.todoDao = todoDao;
	}
	
	@Autowired
	public void create_table() {
		todoDao.create_todo_table();
	}

	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		return todoDao.selectAll();
	}

	@Override
	public TodoVO findById(Long seq) {
		return todoDao.findById(seq);
	}

	@Override
	public int insert(TodoVO todo) {
		// TODO Auto-generated method stub
		return todoDao.insert(todo);
	}

	@Override
	public int update(TodoVO todo) {
		return todoDao.update(todo);
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void create_todo_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TodoVO> findByAuthor(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int complete(TodoVO todo) {
		// TODO Auto-generated method stub
		return 0;
	}


	


	
}
