package org.example.usermanagerservice.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class Dob {

    private LocalDateTime dobDate;

    private int dobAge;

}

