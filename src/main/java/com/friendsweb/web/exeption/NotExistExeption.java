package com.friendsweb.web.exeption;

public class NotExistExeption extends Exception {
    public NotExistExeption() {
        super("There is no user with this email");
    }
}
