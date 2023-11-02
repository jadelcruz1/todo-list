package br.com.jardel.todolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.jardel.todolist.entity.Todo;
import br.com.jardel.todolist.repository.TodoRepository;

@Service
public class TodoService {
    private TodoRepository todorepository;

    public TodoService(TodoRepository todorepository) {
        this.todorepository = todorepository;
    }

    public List<Todo> create(Todo todo){
        todorepository.save(todo);
        return list();

    }

    public List<Todo> list(){
        // ordenação da lista de tarefa primeiro por prioridade de forma descedente e depois por nome.
       Sort sort =  Sort.by("prioridade").descending().and( Sort.by("nome").ascending()); 
       return todorepository.findAll(sort);
        
    }

    public List<Todo> update( Todo todo){
        todorepository.save(todo);
        return list();
        
    }   

    public List<Todo> delete( Long id){
        todorepository.deleteById(id);
        return list();
        
    }

    public List<Todo> update(long id) {
        return null;
    }
    
}
