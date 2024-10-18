package org.example.usermanagerservice.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class Timezone {

    private String timezoneOffset;
    private String description;
}
