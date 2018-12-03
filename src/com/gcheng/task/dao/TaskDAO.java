package com.gcheng.task.dao;

import java.util.List;

import com.gcheng.task.entity.Task;

public interface TaskDAO {

	public List<Task> getTasks();

	public void saveTask(Task theTask);

	public Task getTask(int theId);

	public void deleteTask(int theId);
}
