package org.example.usermanagerservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RandomUserResponse {

    private List<UserDTO> results;
    private Info info;
}
