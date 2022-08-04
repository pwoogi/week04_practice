package com.sparta.week04_practice.model;

public class RegisteredUserException extends RuntimeException {
    public RegisteredUserException(String message) {
        super(message);
    }

    public RegisteredUserException() {
        super("이미 등록된 유저입니다.");
    }
}