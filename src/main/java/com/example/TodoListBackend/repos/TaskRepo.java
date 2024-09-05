package com.example.TodoListBackend.repos;

import com.example.TodoListBackend.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Integer> {
    public List<Task> findByUsername(String username);
}
