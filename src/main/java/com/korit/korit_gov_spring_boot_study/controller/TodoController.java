package com.korit.korit_gov_spring_boot_study.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
class Todo {
    private int todoId;
    private String title;
    private String content;
}

@Controller
public class TodoController {
    private List<Todo> todoList = new ArrayList<>();

    @GetMapping("/todo")
    public String todo() {
        return "todo";
    }

    @PostMapping("/todo")
    public String todoInsert(@RequestParam String title, @RequestParam String content, Model model) {
        Todo todo = new Todo(todoList.size() + 1, title, content);
        todoList.add(todo);
        model.addAttribute("title", "제목: " + title);
        model.addAttribute("content", "내용: " + content);
        return "todo-result";
    }

    @GetMapping("/todoList")
    public String todoList(Model model) {
        model.addAttribute("todoList", todoList);
        return "todoList";
    }

}
