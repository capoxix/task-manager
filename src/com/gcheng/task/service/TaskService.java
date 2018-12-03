package com.gcheng.task.service;

import java.util.List;

import com.gcheng.task.entity.Task;

public interface TaskService {
	
	public List<Task> getTasks();

	public void saveTask(Task theTask);

	public Task getTask(int theId);

	public void deleteTask(int theId);
}
