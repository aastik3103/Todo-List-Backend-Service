package com.example.TodoListBackend.services;

import com.example.TodoListBackend.models.Task;
import com.example.TodoListBackend.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    UserService userService;

    public int addTask(Task task) {
        task.setUsername(userService.getCurrentUser());
        return taskRepo.save(task).getTaskId();
    }

    public List<Task> getTasks() {
        String currentUser = userService.getCurrentUser();
        return taskRepo.findByUsername(currentUser);
    }

    public void deleteTask(int taskId) {
        taskRepo.deleteById(taskId);
    }

    public Task updateStatus(Task task) {
        Task db_task = taskRepo.findById(task.getTaskId()).orElse(null);
        db_task.setStatus(task.getStatus());
        return taskRepo.save(db_task);
    }
}
