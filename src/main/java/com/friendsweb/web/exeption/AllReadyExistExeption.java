package com.friendsweb.web.exeption;

public class AllReadyExistExeption extends Exception {
    public AllReadyExistExeption() {
        super("This User all ready exist");
    }
}
