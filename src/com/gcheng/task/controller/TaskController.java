package com.gcheng.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcheng.task.dao.TaskDAO;
import com.gcheng.task.entity.Task;
import com.gcheng.task.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	// inject our task service
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/list")
	public String listTasks(Model theModel) {
		
		// get task from the dao
		List<Task> theTasks = taskService.getTasks();
		
		// add the tasks to the model
		theModel.addAttribute("tasks", theTasks);
		
		return "list-tasks";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data;
		Task theTask = new Task();
		
		theModel.addAttribute("task", theTask);
		
		return "task-form";
	}
	
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") Task theTask) {
		
		// save the task using our service
		taskService.saveTask(theTask);
		
		
		return "redirect:/task/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("taskId")int theId,
										Model theModel) {
		
		//get the task from our service
		Task theTask = taskService.getTask(theId);
		
		//set task as a model attribute to pre-populate the form
		theModel.addAttribute("task", theTask);
		
		// send over to our form
		return "task-form";
	}
	
	@GetMapping("/delete")
	public String deleteTask(@RequestParam("taskId") int theId) {
		
		//delete the task
		taskService.deleteTask(theId);
		return "redirect:/task/list";
	}
	

}
