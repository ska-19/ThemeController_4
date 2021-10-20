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

    private List<String> themes = new ArrayList<>();

    // 3) Выводит список тем
    /* curl -X GET http://localhost:8080/themes -H 'Content-Type: text/plain' */
    @GetMapping("themes")
    public List<String> getThemes() {
        return themes;
    }

    // 1) Добавляет тему в список
    /* curl -X POST http://localhost:8080/themes -H 'Content-Type: text/plain' -d 'aaaaa' */
    @PostMapping("themes")
    public void addThemes(@RequestBody String text) {
        themes.add(text);
    }

    // 2) Удаляет тему по индексу
    /* curl -X DELETE http://localhost:8080/themes/0 -H 'Content-Type: text/plain' */
    @DeleteMapping("themes/{index}")
    public void deleteThemes(@PathVariable("index") Integer index) {
        themes.remove((int) index);
    }

    // 4) Обновляет тему по индексу
    /* curl -X PUT http://localhost:8080/themes/1 -H 'Content-Type: text/plain' -d 'ttttttt' */
    @PutMapping("themes/{index}")
    public void updateThemes(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        themes.remove((int) i);
        themes.add(i, message);
    }

    // 5) возвращает количество тем
    /* curl -X GET http://localhost:8080/themes/count -H 'Content-Type: text/plain' */
    @GetMapping("themes/count")
    public Integer getCount() {
        return themes.size();
    }

    //6) Удаляет все темы
    /* curl -X DELETE http://localhost:8080/themes/delete -H 'Content-Type: text/plain' */
    @DeleteMapping("themes/delete")
    public void deleteTextSearchText() {
        for (int i = 0; i < themes.size(); i++) {
            themes.remove(i);
        }
     }

    // 7) Выводит тему по индексу
    /* curl -X GET http://localhost:8080/themes/1 -H 'Content-Type: text/plain' */
    @GetMapping("themes/{index}")
    public String getThemes(@PathVariable("index") Integer index) {
        return themes.get(index);
    }


//    // 1. возвращает индекс первого текста с подстрокой text
//    /* curl -X GET http://localhost:8080/messages/search/tt -H 'Content-Type: text/plain' */
//    @GetMapping("messages/search/{text}")
//    public Integer getIndexSearch(@PathVariable("text") String text) {
//        for (int i = 0; i < themes.size(); i++) {
//            String E = themes.get(i);
//            if(E.contains(text)){
//                return i;
//            }
//        }
//        return -1;
//    }


//    // 3. Добавляет сообщение с порядковым номером index
//    /* curl -X POST http://localhost:8080/messages/1/create -H 'Content-Type: text/plain' -d 'ffffff' */
//    @PostMapping("messages/{index}/create")
//    public void addMessageToIndex(
//            @PathVariable("index") Integer index,
//            @RequestBody String text) {
//        themes.add(index, text);
//    }

//    // 4. Удаляет все сообщения в которых есть подстрока text
//    /* curl -X DELETE http://localhost:8080/messages/search/aaa -H 'Content-Type: text/plain' */
//    @DeleteMapping("messages/search/{text}")
//    public void deleteTextSearchText(@PathVariable("text") String text) {
//        for (int i = 0; i < themes.size(); i++) {
//            String E = themes.get(i);
//            if(E.contains(text)){
//                themes.remove(i);
//            }
//        }
//     }


}