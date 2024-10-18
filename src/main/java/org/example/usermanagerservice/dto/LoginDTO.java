package org.example.usermanagerservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginDTO {


    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

}
