package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.ArrayList;
import java.util.List;
//@Controller
@RestController
public class ApiController {

    private List<String> messages = new ArrayList<>();

    // d) Выводит список сообщений Выводит сообщение по индексу
    /*  */
    @GetMapping("messages")
    public List<String> getMessages() {
        return messages;
    }

    // a) Добавляет сообщение в список
    /* curl -X POST http://localhost:8080/messages -H 'Content-Type: text/plain' -d 'aaaaa' */
    @PostMapping("messages")
    public void addMessage(@RequestBody String text) {
        messages.add(text);
    }

    // c) Выводит сообщение по индексу
    /* curl -X GET http://localhost:8080/messages/1 -H 'Content-Type: text/plain' */
    @GetMapping("messages/{index}")
    public String getMessage(@PathVariable("index") Integer index) {
        return messages.get(index);
    }

    // b) Удаляет сообщение по индексу
    /* curl -X DELETE http://localhost:8080/messages/0 -H 'Content-Type: text/plain' */
    @DeleteMapping("messages/{index}")
    public void deleteText(@PathVariable("index") Integer index) {
        messages.remove((int) index);
    }

    // e) Обновляет сообщение по индексу
    /* curl -X PUT http://localhost:8080/messages/0 -H 'Content-Type: text/plain' -d 'ttttttt' */
    @PutMapping("messages/{index}")
    public void updateMessage(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        messages.remove((int) i);
        messages.add(i, message);
    }
}