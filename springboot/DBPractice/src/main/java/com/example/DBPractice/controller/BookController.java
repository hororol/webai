package com.example.DBPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    // 뷰의 요청 경로 지정, 내가 목표로 하는 view의 경로
    @RequestMapping(value = "/create", method = RequestMethod.GET) // create메소드는 브라우저에서 /create주소가 get방식으로 입력되었을때 book/create 경로의 뷰를 보여준다.
    public ModelAndView create(){
        return new ModelAndView("book/create");
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }
}

// @RequestMapping은 클래스 레벨과 메소드 둘다 맵핑할 수 있고 @GetMapping은 메소드에만 맵핑할 수 있다. 그러니깐 @GetMapping이 더 세분화되어있다고 볼수있다.
// 두 어노테이션들은 각각의 http메소드들에 맵핑되는데 @GetMapping은 Get으로 @RequestMapping한다는 뜻.

/* ModelAndView 객체는 데이터와 뷰를 동시에 설정이 가능하다. Model객체와 크게 차이가 없다.
*  뷰의 이름을 설정하는 메소드 -> setViewName("뷰의 경로")
*  데이터를 보낼때 사용하는 메소드 -> addObject("변수 이름","데이터 값")
*/
