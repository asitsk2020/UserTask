package com.ey.springreact.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true)
	private long id;
	@Column
	private String description;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="created_date")
	private Date createdDate;
	
	
	public Task() {}
	
	public Task(long id, String description, Date updatedDate, Date createdDate) {
		super();
		this.id = id;
		this.description = description;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}