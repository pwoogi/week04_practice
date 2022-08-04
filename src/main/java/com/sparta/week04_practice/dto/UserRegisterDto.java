package com.sparta.week04_practice.dto;


import lombok.*;

/**
 * 유저 회원가입용 Dto
 */
@Getter
@Setter
//접근제어자 설정해주기..진짜 폭풍 구글링..
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class UserRegisterDto {

    private String username;
    private String password;
}