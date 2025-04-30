package com.dhapplications.TodoApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	static int id=0;
	static {
	todos.add(new Todo(id+=1,"dileepaa","Learn Java", LocalDate.now().plusYears(1),false));
	todos.add(new Todo(id+=1,"dileep","Learn spring", LocalDate.now().plusYears(1),false));
	todos.add(new Todo(id+=1,"dileep","Learn mvc", LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate= todo->todo.getUserName().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String userName, String description, LocalDate targetdate){
		todos.add(new Todo(id+=1, userName, description, targetdate, false));
	}
	
	public void deleteTodoById(int id){
		
		Predicate<? super Todo> predicate= todo->todo.getId() == id;
		todos.removeIf(predicate);
	}
	

	public Todo getTodoById(int id) {
		Predicate<? super Todo> predicate= todo->todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodoById(todo.getId());
		todos.add(todo);
		
	}
}
