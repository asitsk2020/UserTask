package com.ey.springreact;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.springreact.model.Task;
import com.ey.springreact.repository.TaskRepository;

@Service
public class UserService {

	    @Autowired
	    TaskRepository taskRepository;

	    public List<Task> findAll() {
	        return taskRepository.findAll();
	    }

	    public Optional<Task> getTaskById(long id) {
	        return taskRepository.findById(id);
	    }

	    public void saveOrUpdate(Task person) {
	    	taskRepository.save(person);
	    }

	    public void delete(long id) {
	    	taskRepository.deleteById(id);
	    }
	}

