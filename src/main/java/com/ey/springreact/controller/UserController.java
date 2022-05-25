package com.ey.springreact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.springreact.UserService;
import com.ey.springreact.exception.ResourceNotFoundException;
import com.ey.springreact.model.Task;

//Resource Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/restapi/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * get all user tasks
	 */
	@GetMapping
	public List<Task> getAllUserTasks() {
	return userService.findAll();
	}
	
	/*
	 *  create the task method
	 */
	@PostMapping
	public Task saveUserTask(@RequestBody Task task) {
		
		task.setUpdatedDate(task.getCreatedDate());
		 userService.saveOrUpdate(task);
	     return task;
	}
	
	/*
	 * get the task by id
	 */
	@GetMapping("{id}")
	public ResponseEntity<Task> getUserTaskById(@PathVariable long id){
		Task task = userService.getTaskById(id).
				orElseThrow(()->new ResourceNotFoundException("The Task "+ id + " does not Exits"));
				return ResponseEntity.ok(task);
	}
	
	/*
	 * update the task 
	 */
	@PutMapping("{id}")
	public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task taskDetails){
		Task taskUpdate = userService.getTaskById(id).
		orElseThrow(()->new ResourceNotFoundException("Task does not exist with id"+id));
		taskUpdate.setDescription(taskDetails.getDescription());
		taskUpdate.setUpdatedDate(taskDetails.getUpdatedDate());
		
		userService.saveOrUpdate(taskUpdate);
		return ResponseEntity.ok(taskUpdate);
		
	}
	/*
	 * delete the method 
	 */
	
	@DeleteMapping("{taskId}")
	public ResponseEntity<HttpStatus> deleteTask(@PathVariable long taskId){
		
		Task task =userService.getTaskById(taskId).orElseThrow(()->new ResourceNotFoundException("The task does not exist with id: "+taskId));
		userService.delete(task.getId());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
	}

}
