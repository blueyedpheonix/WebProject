package com.friendsweb.web.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Admin {
    private String email;
    private String password;
}
