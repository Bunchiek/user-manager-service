package org.example.usermanagerservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {


    private StreetDTO street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private CoordinatesDTO coordinates;
    private TimezoneDTO timezone;
}
