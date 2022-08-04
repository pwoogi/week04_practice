package com.sparta.week04_practice.model;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("유저를 찾을 수 없습니다.");
    }
}
