package com.example.basic.controller;

import com.example.basic.dto.LoginDTO;
import com.example.basic.entity.JoinEntity;
import com.example.basic.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// 요청에 따라 템플릿을 반환하는 것이 아닌 JSON 반환
@RestController
@RequiredArgsConstructor
// 클라이언트에서 요청시 api요청이라는 구분자 패스명 등록(기존 URL/api/login)
@RequestMapping("/api")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login/check")
    public Map<String, Object> checkLogin(@ModelAttribute LoginDTO loginDTO, Model model, HttpSession session) {
        // 브라우저에서 반환되는 데이터를 사용하기 편하도록 빈 맵 인스턴스 생성(객체 생성)
        Map<String, Object> response = new HashMap<>();
        JoinEntity user = loginService.checkUser(loginDTO.getUname(), loginDTO.getEmail());

        if (user != null) {
            session.setAttribute("loginUser", user);
            response.put("message", "로그인 성공");
            response.put("user", user);
        } else {
            response.put("message","일치하는 사용자가 없습니다.");
        }
        return response;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 초기화 (로그아웃)
        return "redirect:/login";
    }
}

/*
    현재 까지 로그인 작업단계에서의 문제점
    - 현재의 로그인 인증은 DB에 저장된 데이터 매칭되는 유저 정보가 있는지만 확인
    - 로그인 성공시 유저 정보를 저장하지 않음
    - 때문에 이후 특정 사용자 요청이 와도 누가 로그인된 상태인지 기억할 방법이 없음
    - 결론 : 로그인 인증 이후에 현재 사용자가 인증된 사용자 인지 확인할 브라우저, 서버간의 정보공유 필요
    - 이때 필요한 것이 바로 쿠키, 세션, (세션활용 : 보안이슈)
 */