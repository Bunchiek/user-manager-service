package org.example.usermanagerservice.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Street {

    private int number;
    private String name;
}
