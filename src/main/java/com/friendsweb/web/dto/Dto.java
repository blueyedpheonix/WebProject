package com.friendsweb.web.dto;

import com.friendsweb.web.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Dto<T>{

    private boolean success;
    private T content;
}
