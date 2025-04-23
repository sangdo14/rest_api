package com.example.basic.repository;
import com.example.basic.entity.JoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA 인터페이스만 정의
//이때 JpaRepository를 상속하면서 전달되는 데이터를 JoinEntity내용으로 강제하는 인터페이스 생성
public interface JoinRepo extends JpaRepository<JoinEntity, Long> {
    JoinEntity findByUnameAndEmail(String uname, String email);
}
