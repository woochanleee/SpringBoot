package com.woochanleee.boardcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

//    @GetMapping("/test")
    @RequestMapping(method = RequestMethod.GET, path = "/test")
    public String test() {
        return "Hello World!";
    }
}

/*
    @RestController : @Controller + @ResponseBody 의 축약형으로써, 리턴값을 뷰리졸버(?)로 매핑하지 않고 그대로 출력해준다.
    - 아무튼 return 해준 값을 그대로 출력한다는 의미인것 같다.
    @GetMapping : @RequestMapping(method = RequestMethod.GET) 의 축약형으로써, 어노테이션만 보고 무슨 메소드 요청인지 바로 알아볼 수 있다.

    출처: https://countryxide.tistory.com/45 [배워서 남주자]
*/