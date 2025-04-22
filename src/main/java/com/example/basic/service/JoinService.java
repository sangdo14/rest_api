package com.example.basic.service;

import com.example.basic.dto.JoinDTO;
import com.example.basic.entity.JoinEntity;
import com.example.basic.repository.JoinRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final JoinRepo joinRepo;

    public void processJoin(JoinDTO dto) {
        JoinEntity user = new JoinEntity(null, dto.getUname(), dto.getEmail(), dto.getColors() );
        joinRepo.save(user);
    }

    public List<JoinEntity> getAllUsers(){
        return joinRepo.findAll();
    }

    public void delete(Long id){
        joinRepo.deleteById(id);
    }

    public JoinEntity getUserById(Long id){
        return joinRepo.findById(id).orElseThrow(()-> new RuntimeException("해당 아이디의 유저 없음"));
    }

    public void updateUser(JoinEntity user){
        joinRepo.save(user);
    }

    //페이지 번호에 따라 유저 데이터 가져오는 메서드
    public Page<JoinEntity> getUsersByPage(int page, int size){
        //page: 페이지 번호,  size: 한페이지에 불어올 데이터 갯수
        return joinRepo.findAll(PageRequest.of(page, size));
    }
}