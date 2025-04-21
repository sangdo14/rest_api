package com.example.basic.dto;
import lombok.*;

// lombok 라이브러리로부터 아래 어노테이션을 활성화 시키면
// 매번 동일한 getter, setter, 생성자 함수 반환값 문자열 변환 코드를 작성할 필요 없음
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JoinDTO {
    private String uname;
    private String email;
    private String colors;

//    // 인스턴스 복사하는 성성자 함수
//    public JoinDTO(){}

//    // 각 폼의 항목별로 getter, setter 등록
//    public String getUname(){ return uname; }
//    public void setUname(String uname){ this.uname = uname; }
//
//    public String getEmail(){ return email; }
//    public void setEmail(String email){ this.email = email; }
//
//    public String getColors(){ return colors; }
//    public void setColors(String colors){ this.colors = colors; }
}
