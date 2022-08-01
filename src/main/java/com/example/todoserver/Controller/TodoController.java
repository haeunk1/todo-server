package com.example.todoserver.Controller;

import com.example.todoserver.Service.TodoService;
import com.example.todoserver.model.TodoEntity;
import com.example.todoserver.model.TodoRequest;
import com.example.todoserver.model.TodoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin//cors이슈 막기 위해
@RestController
@AllArgsConstructor
@RequestMapping("/")
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request){
        System.out.println("Create");
        if(ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();
        if(ObjectUtils.isEmpty(request.getOrder()))
            request.setOrder(0L);
        if(ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);
        TodoEntity result = this.service.add(request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoEntity> readOne(@PathVariable Long id){
        System.out.println("Read One");
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TodoEntity>> readAll(){
        System.out.println("Read All");
        return null;
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoEntity> update(){
        System.out.println("Update");
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(){
        System.out.println("Delete");
        return null;
    }
    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        System.out.println("Delete All");
        return null;
    }
}
