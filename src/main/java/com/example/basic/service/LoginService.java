package com.example.basic.service;

import com.example.basic.entity.JoinEntity;
import com.example.basic.repository.JoinRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final JoinRepo joinRepo;

    public JoinEntity checkUser(String uname, String email){
        //인수로 전달된 사용자 이름과 email 항목으로 매칭되는 DB데이터가 있는지 찾아서 반환
        //아래 함수는 우리가 repository계층에 이름만 등록한 메서드임에도 불구하고 실제 동작 가능
        //함수명에 들어가 있는 키워드를 자동 인지해서 로직을 짜줌
        //findBy.uname, email 등의 실제 기존 DB함수명과 실제 entity에 등록되어 있는 필드명을 활용
        // SELECT j FROM JoinEntity j WHERE j.uname = :uname AND J.email = :email
        return joinRepo.findByUnameAndEmail(uname, email);
    }
}
