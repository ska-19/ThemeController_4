//package com.example.demo;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.List;
////@Controller
//@RestController
//public class UserController {
//
//    private List<User> UserList = new ArrayList<>();
//
//    // d) Выводит список пользователей
//    /* curl -X GET http://localhost:8080/userList -H 'Content-Type: application/json' */
//    @GetMapping("userList")
//    public List<User> getMessages() {
//        return UserList;
//    }
//
//    // a) Добавляет пользователя в список
//    /* curl -X POST http://localhost:8080/userList -H 'Content-Type: application/json' -d '{"name":"Kirill","age": 17}' */
//    @PostMapping("userList")
//    public void addUser(@RequestBody User user) {
//        UserList.add(user);
//    }
////    @RequestMapping(method = RequestMethod.PUT)
//
//
//    // c) Выводит пользователя по индексу
//    /* curl -X GET http://localhost:8080/userList/0 -H 'Content-Type: application/json' */
//    @GetMapping("userList/{index}")
//    public User getUser(@PathVariable("index") Integer index) {
//        return UserList.get(index);
//    }
//
//    // b) Удаляет пользователя по индексу
//    /* curl -X DELETE http://localhost:8080/userList/0 -H 'Content-Type: application/json' */
//    @DeleteMapping("userList/{index}")
//    public void deleteUser(@PathVariable("index") Integer index) {
//        UserList.remove((int) index);
//    }
//
//    // e) Обновляет возраст пользователя по индексу
//    /* curl -X PUT http://localhost:8080/userList/0 -H 'Content-Type: application/json' -d '10' */
//    @PutMapping("userList/{index}")
//    public void updateUserAge(
//            @PathVariable("index") Integer index,
//            @RequestBody Integer age) {
//        UserList.get( index).setAge(age);
//    }
//
////    // e) Обновляет пользователя по индексу
////    /* curl -X PUT http://localhost:8080/userList/1 -H 'Content-Type: application/json' -d '{"name":"Dima","age": 11}' */
////    @PutMapping("userList/{index}")
////    public void updateUser(
////            @PathVariable("index") Integer i,
////            @RequestBody User user) {
////        UserList.remove((int) i);
////        UserList.add(i, user);
////    }
//}