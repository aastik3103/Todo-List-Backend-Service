package com.example.TodoListBackend.repos;

import com.example.TodoListBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    public User findByUsername(String username);
}
