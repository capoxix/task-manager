package com.gcheng.task.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gcheng.task.entity.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Task> getTasks() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query ... sort by last name
		Query<Task> theQuery = 
				currentSession.createQuery("from Task", 
											Task.class);
		
		
		//execute query and get result list
		List<Task> tasks = theQuery.getResultList();
		
		//return the results
		return tasks;
	}


	@Override
	public void saveTask(Task theTask) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the task
		currentSession.saveOrUpdate(theTask);
		
	}


	@Override
	public Task getTask(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Task theTask = currentSession.get(Task.class, theId);
		
		return theTask;
	}


	@Override
	public void deleteTask(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery =
				currentSession.createQuery("delete from Task where id=:taskId");
		theQuery.setParameter("taskId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	

}
