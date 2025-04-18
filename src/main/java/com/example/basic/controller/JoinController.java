package com.example.basic.controller;

import com.example.basic.dto.JoinDTO;
import com.example.basic.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//Model: 컨트롤러에서 템플릿에 데이터를 전달시 필요한 스프링 내장 객체
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JoinController {

    @Autowired
    private JoinService joinService;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join/create")
    public String create(
            // 매개변수 용도의 객체
            @ModelAttribute JoinDTO formDTO,
             // return에 사용하는 라이브러리 객체
            Model model
    ) {
        // 서비스 메서드로 부터 전달받은 문자열을 전달 받음
        String msg = joinService.processJoin(formDTO);
        System.out.println(model);
        model.addAttribute("data", msg);
        System.out.println(model);
        return "index";
    }
}