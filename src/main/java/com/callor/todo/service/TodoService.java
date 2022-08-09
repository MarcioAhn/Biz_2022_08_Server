package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;

public interface TodoService extends TodoDao{
	public List<TodoVO> findByAuthor(String username);
}
	
