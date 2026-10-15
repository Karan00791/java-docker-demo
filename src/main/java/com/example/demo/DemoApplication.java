package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/tasks")
public class DemoApplication {

    private final List<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public DemoApplication() {
        tasks.add("Learn Docker Basics");
        tasks.add("Containerise a Java App");
    }

    @GetMapping
    public List<String> getTasks() {
        return tasks;
    }

    @PostMapping
    public List<String> addTask(@RequestBody String newTask) {
        // Strip quotes if passed from JS stringify
        String cleanedTask = newTask.replace("\"", "");
        tasks.add(cleanedTask);
        return tasks;
    }
}