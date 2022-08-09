package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.TodoVO;

public interface TodoDao extends GenericDao<TodoVO, Long>{


	public List<TodoVO> selectAll();
	public TodoVO findById(Long seq);
	public int insert(TodoVO todo);
	public int update(TodoVO todo);
	public int delete(Long seq);
	public int complete(TodoVO todo);
	
	public void create_todo_table();
}
