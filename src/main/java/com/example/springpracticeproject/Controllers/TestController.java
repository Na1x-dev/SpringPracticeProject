package com.example.springpracticeproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //указывает спрингу, что это класс-контроллер
public class TestController {

    public TestController() {
    }

    @GetMapping(value = "/{number}") //указывает, что метод обрабатывает GET запросы на адрес /{любое число}
    public ResponseEntity<?> get(@PathVariable(name = "number") int number) {  //@PathVariable принимает переменную из url в {}
        return number % 2 == 0                                               //ResponseEntity - класс для возврата ответовЫ
                        ? new ResponseEntity<>(HttpStatus.OK) //200
                        : new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
    }

//    @GetMapping(value = "/{number1}/-/{number2}") //указывает, что метод обрабатывает GET запросы на адрес /{любое число}
//    public ResponseEntity<?> read(@PathVariable(name = "number1") int number1, @PathVariable(name = "number2") int number2) {  //@PathVariable принимает переменную из url в {}
//        return  new ResponseEntity<>(HttpStatus.resolve(number1 - number2 )); //200
//    }


}
