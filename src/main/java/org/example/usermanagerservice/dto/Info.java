package org.example.usermanagerservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Info {

    private String seed;
    private int results;
    private int page;
    private String version;
}
