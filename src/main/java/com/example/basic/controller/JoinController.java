package com.example.basic.controller;
import com.example.basic.dto.JoinDTO;
import com.example.basic.entity.JoinEntity;
import com.example.basic.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//Model: 컨트롤러에서 템플릿에 데이터를 전달시 필요한 스프링 내장 객체
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// 인스턴스를 담을 멤버변수에 final 지정 가능케 함
@RequiredArgsConstructor
public class JoinController {
    // 서비스 계층으로부터 joinService라는 인스턴스 @Autowired라는 어노테이션을 통해 바로 해당 인스턴스 객체를 바로 가져올 수 있음 (new 연산자 호출 필요없음)
    // @Autowired
    private final JoinService joinService;

    // 처음 조인을 화면 출력하는 get방식 유형
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    // 해당 조인폼 화면에서 폼의 전송 이벤트 발생시 데이터 가공하는 post 방식 요청
    // 이때 폼의 모든 요소를 일일이 전달하는 것이 아닌 DTO파일로 감싸서 전달
    // Model타입의 파라미터, 서비스에 전달된 데이터를 뷰템플릿에 저달하기 위한 전용 클래스
    @PostMapping("/join/create")
    public String create( @ModelAttribute JoinDTO formDTO, Model model ) {
        joinService.processJoin(formDTO);
//        String msg = joinService.processJoin(formDTO);
//        model.addAttribute("data", msg);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model){
        List<JoinEntity> users = joinService.getAllUsers();
        System.out.println(users);
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/admin/del/{id}")
    public String delUser(@PathVariable Long id){
        joinService.delete(id);
        return "redirect:/admin";
    }
}