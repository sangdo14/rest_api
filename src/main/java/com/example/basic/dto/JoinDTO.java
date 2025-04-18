package com.example.basic.dto;

public class JoinDTO {
    private String uname;
    private String email;
    private String colors;

    // 인스턴스 복사하는 성성자 함수
    public JoinDTO(){}

    // 각 폼의 항목별로 getter, setter 등록
    public String getUname(){
        return uname;
    }
    public void setUname(String uname){
        this.uname = uname;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getColors(){
        return colors;
    }
    public void setColors(String colors){
        this.colors = colors;
    }
}
