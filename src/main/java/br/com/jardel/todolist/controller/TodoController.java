package br.com.jardel.todolist.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jardel.todolist.entity.Todo;
import br.com.jardel.todolist.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;
    
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List <Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);

    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();

    }

   /* @PutMapping
    List<Todo> update( @RequestBody Todo todo){
        return todoService.update(todo);

    }
    */

    @PutMapping("{id}")
    List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
      return todoService.update(id);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);

    }
    
}
