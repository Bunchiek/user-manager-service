package org.example.usermanagerservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {


    private String gender;
    private String email;
    private String phone;
    private String cell;
    private String nat;

    private NameDTO name;

    private LocationDTO location;

    private LoginDTO login;

    private PictureDTO picture;

    private DobDTO dob;

    private RegisteredDTO registered;

    private IdDTO Id;


    @Override
    public String toString() {
        return "UserDTO{" +
                "gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", nat='" + nat + '\'' +
                ", name=" + name +
                ", location=" + location +
                ", login=" + login +
                ", picture=" + picture +
                ", dob=" + dob +
                ", registered=" + registered +
                ", Id=" + Id +
                '}';
    }
}
