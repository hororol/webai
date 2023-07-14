package com.jpa.jpa.controller;

import com.jpa.jpa.dto.FreeBoardDto;
import com.jpa.jpa.entity.FreeBoard;
import com.jpa.jpa.repository.FreeBoardRepository;
import com.jpa.jpa.service.FreeBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/FreeBoard")
public class FreeBoardController {

    @Autowired
    FreeBoardService freeBoardService;

    @GetMapping("")
    public String index(Model model){
        List<FreeBoardDto> list = freeBoardService.list();
        System.out.println(list);
        model.addAttribute("list", list);
        return "freeboard/index";
    }
}

// controller -> service-> repository -> form(유효성검사-> 로그인여부등등), entity