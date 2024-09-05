package com.example.TodoListBackend.controllers;

import com.example.TodoListBackend.models.Task;
import com.example.TodoListBackend.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/add")
    public String addTask(@RequestBody Task task){
        int id = taskService.addTask(task);
        return ("Task created with id: " + id);
    }

    @GetMapping("/list")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @DeleteMapping("/delete")
    public String deleteTask(@RequestParam int task_id){
        taskService.deleteTask(task_id);
        return ("Task with id: " + task_id + " deleted");
    }

    @PutMapping("update/status")
    public Task updateStatus(@RequestBody Task task){
        return taskService.updateStatus(task);
    }
}
