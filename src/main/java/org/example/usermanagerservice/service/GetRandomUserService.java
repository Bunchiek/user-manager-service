package org.example.usermanagerservice.service;

import org.example.usermanagerservice.RandomUserClient;
import org.example.usermanagerservice.dto.RandomUserResponse;
import org.example.usermanagerservice.dto.UserDTO;
import org.example.usermanagerservice.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetRandomUserService {

    private final RandomUserClient randomUserClient;

    public GetRandomUserService(RandomUserClient randomUserClient) {
        this.randomUserClient = randomUserClient;
    }

    public List<User> getRandomUser(int count) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            RandomUserResponse response = randomUserClient.getRandomUser();
            userList.add(convertDtoToEntity(response.getResults().get(0)));
        }
        return userList;
    }

    private User convertDtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setGender(userDTO.getGender());

        Name name = new Name();
        name.setFirst(userDTO.getName().getFirst());
        name.setLast(userDTO.getName().getLast());
        name.setTitle(userDTO.getName().getTitle());
        user.setName(name);

        Location location = new Location();
        Street street = new Street();
        street.setNumber(userDTO.getLocation().getStreet().getNumber());
        street.setName(userDTO.getLocation().getStreet().getName());
        location.setStreet(street);
        location.setCity(userDTO.getLocation().getCity());
        location.setState(userDTO.getLocation().getState());
        location.setCountry(userDTO.getLocation().getCountry());
        location.setPostcode(userDTO.getLocation().getPostcode());

        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(userDTO.getLocation().getCoordinates().getLatitude());
        coordinates.setLongitude(userDTO.getLocation().getCoordinates().getLongitude());
        location.setCoordinates(coordinates);

        Timezone timezone = new Timezone();
        timezone.setTimezoneOffset(userDTO.getLocation().getTimezone().getOffset());
        timezone.setDescription(userDTO.getLocation().getTimezone().getDescription());
        location.setTimezone(timezone);

        user.setLocation(location);

        Login login = new Login();
        login.setUuid(userDTO.getLogin().getUuid());
        login.setUsername(userDTO.getLogin().getUsername());
        login.setPassword(userDTO.getLogin().getPassword());
        login.setSalt(userDTO.getLogin().getSalt());
        login.setMd5(userDTO.getLogin().getMd5());
        login.setSha1(userDTO.getLogin().getSha1());
        login.setSha256(userDTO.getLogin().getSha256());
        user.setLogin(login);

        Dob dob = new Dob();
        dob.setDobDate(userDTO.getDob().getDate());
        dob.setDobAge(userDTO.getDob().getAge());
        user.setDob(dob);

        Registered registered = new Registered();
        registered.setRegDate(userDTO.getRegistered().getDate());
        registered.setRegAge(userDTO.getRegistered().getAge());
        user.setRegistered(registered);

        Id userId = new Id();
        userId.setName(userDTO.getId().getName());
        userId.setValue(userDTO.getId().getValue());
        user.setUserid(userId);

        Picture picture = new Picture();
        picture.setLarge(userDTO.getPicture().getLarge());
        picture.setMedium(userDTO.getPicture().getMedium());
        picture.setThumbnail(userDTO.getPicture().getThumbnail());
        user.setPicture(picture);

        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setCell(userDTO.getCell());
        user.setNat(userDTO.getNat());

        return user;
    }


}
