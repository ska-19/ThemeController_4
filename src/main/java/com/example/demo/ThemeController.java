package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ThemeController {
    private List<Theme> themes = new ArrayList<>();

    // 3) Выводит список тем +
    /* curl -X GET http://localhost:8080/themes -H 'Content-Type: application/json' */
    @GetMapping("themes")
    public List<String> getThemes() {
        List<String> names = new ArrayList<>();
        for (int i =0; i<themes.size() ;i++) {
            names.add(themes.get(i).getName());
        }
        return names;
    }

    // 1) Добавляет тему в список +
    /* curl -X POST http://localhost:8080/themes -H 'Content-Type: application/json' -d '{"name":"game","comments":null}' */
    @PostMapping("themes")
    public void addThemes(@RequestBody Theme theme) {
        themes.add(theme);
    }

    // 2) Удаляет тему по индексу +
    /* curl -X DELETE http://localhost:8080/themes/0 -H 'Content-Type: application/json' */
    @DeleteMapping("themes/{index}")
    public void deleteThemes(@PathVariable("index") Integer index) {
        themes.remove((int) index);
    }

//    public void updateUserAge(
//            @PathVariable("index") Integer index,
//            @RequestBody Integer age) {
//        UserList.get( index).setAge(age);
//    }
    // 4) Обновляет тему по индексу +
    /* curl -X PUT http://localhost:8080/themes/0 -H 'Content-Type: application/json' -d 'ttttttt' */
    @PutMapping("themes/{index}")
    public void updateThemeName(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        themes.get( i).setName(message);
    }

    // 5) возвращает количество тем +
    /* curl -X GET http://localhost:8080/themes/count -H 'Content-Type: application/json' */
    @GetMapping("themes/count")
    public Integer getCount() {
        return themes.size();
    }

    //6) Удаляет все темы +
    /* curl -X DELETE http://localhost:8080/themes/deleteAll -H 'Content-Type: application/json' */
    @DeleteMapping("themes/deleteAll")
    public void deleteAllTheme() {
      themes.clear();
    }

    // 7) Выводит тему по индексу +
    /* curl -X GET http://localhost:8080/themes/1 -H 'Content-Type: application/json' */
    @GetMapping("themes/{index}")
    public String getThemes(@PathVariable("index") Integer index) {
        if(themes!=null) {
            return themes.get(index).getName();
        }
        return "";
    }


    //ДАЛЬШЕ НА 4 НО пока НЕ РАБОТАЕТ

    // 8) Создать комментарий в определенной теме
    /* curl -X POST http://localhost:8080/themes/0/comment -H 'Content-Type: application/json' -d 'TerrariaGG' */
    @PostMapping("themes/{index}/comment")
    public void addComment(
            @PathVariable("index") Integer i,
            @RequestBody String message) {
        themes.get(i).setComment(message);

    }
    //9) Удаляет комменарий темы
    /* curl -X DELETE http://localhost:8080/themes/0/comment/0 -H 'Content-Type: application/json' */
    @DeleteMapping("themes/{index}/comment/{index2}")
    public void deleteComment(@PathVariable("index") Integer i1,@PathVariable("index2") Integer i2) {
        themes.get(i1).deleteComment(i2);
    }
    //9) Обновляет комменарий темы
    /* curl -X PUT http://localhost:8080/themes/0/comment/0 -H 'Content-Type: application/json' -d 'ttttttt'*/
    @PutMapping("themes/{index}/comment/{index2}")
    public void updComment(
            @PathVariable("index") Integer i1,
            @PathVariable("index2") Integer i2,
            @RequestBody String message
            ) {
        themes.get(i1).updComment(i2,message);
    }

    //10) Выдать список комментариев определенной темы
    /* curl -X GET http://localhost:8080/themes/1/comment -H 'Content-Type: application/json' */
    @GetMapping("themes/{index}/comment")
    public List<String> getThemesComment(@PathVariable("index") Integer i) {
        return themes.get(i).getComments();
    }





//    // 4) Обновляет тему по индексу
//    /* curl -X PUT http://localhost:8080/themes/1 -H 'Content-Type: application/json' -d 'ttttttt' */
//    @PutMapping("themes/{index}")
//    public void updateThemes(
//            @PathVariable("index") Integer i,
//            @RequestBody String message) {
//        themes.remove((int) i);
//        themes.add(i, message);
//    }
}
