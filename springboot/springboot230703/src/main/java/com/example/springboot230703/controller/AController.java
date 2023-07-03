package com.example.springboot230703.controller;

import com.example.springboot230703.dto.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Controller
public class AController {
    @Autowired
    DataSource ds;

    @GetMapping("/")
    public String index(Model model){
        ArrayList<People> al = new ArrayList<>();

        try{
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from people");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("이름: " + rs.getString("name") + "\n나이: " + rs.getString("age"));
                String name = rs.getString("name");
                String age = rs.getString("age");
                People p = new People(name, age);
//                p.setName(name);
//                p.setAge(age);
                al.add(p);
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("al", al);
        return "index";
    }
}
