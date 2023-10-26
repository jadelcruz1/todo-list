package br.com.jardel.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jardel.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
