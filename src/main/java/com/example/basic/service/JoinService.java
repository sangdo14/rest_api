package com.example.basic.service;

import com.example.basic.dto.JoinDTO;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    public String processJoin(JoinDTO dto) {
        // 컨트롤러를 통해 실제 템플릿에 전달된 데이터가 매핑된 태그 문자열 반환
        String result = "</br><ul><li>name: " + dto.getUname() + "</li>"
                + "<li>email: " + dto.getEmail() + "</li>"
                + "<li>my color: " + dto.getColors() + "</li></ul></br>";
        return result;
    }
}