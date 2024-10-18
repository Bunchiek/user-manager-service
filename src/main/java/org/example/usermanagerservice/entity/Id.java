package org.example.usermanagerservice.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Id {

    private String name;
    private String value;
}
