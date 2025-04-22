package com.example.basic.service;
import com.example.basic.dto.JoinDTO;
import com.example.basic.entity.JoinEntity;
import com.example.basic.repository.JoinRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinRepo joinRepo;

    public void processJoin(JoinEntity dto) {
        // Entity클래스로 부터 각 항목에 맞는 데이터를 인자로 전달하여 실제 db에 저장할 모델 인스턴스생성
        JoinEntity user = new JoinEntity(null, dto.getUname(), dto.getEmail(), dto.getColors());

        //위에서 생성한 user라는 인스턴스를 joinRepo의 save메서드로 전달하기만 하면 DB에 데이터 저장됨
        //save() 리포지토리에서 JPA구현체가 자동으로 생성 DB저장 전용 메서드
        joinRepo.save(user);

        // 컨트롤러를 통해 실제 템플릿에 전달된 데이터가 매핑된 태그 문자열 반환
//        String result = "</br><ul><li>name: " + dto.getUname() + "</li>"
//                + "<li>email: " + dto.getEmail() + "</li>"
//                + "<li>my color: " + dto.getColors() + "</li></ul></br>";
//        return result;
    }

    //모든 db데이터 조회해서 반환
    public List<JoinEntity> getAllUsers(){ return joinRepo.findAll();}

    //데이터 삭제하는 jpo메서드 호출
    public void delete(Long id){ joinRepo.deleteById(id); }

    //id값으로 해당 데이터만 가져오는 메서드
    public JoinEntity getUserById(Long id){
        //초기 에러를 피하기 위해서 onElseThrow룰 통해 예외처리
        return joinRepo.findById(id).orElseThrow(()->new RuntimeException("해당 아이디의 유저 없음"));
    }

    public void updateUser(JoinEntity user){
        joinRepo.save(user);
    }
}
/*
    JPA Respository의 dirty che
 */