package com.ey.springreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.springreact.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	

}
