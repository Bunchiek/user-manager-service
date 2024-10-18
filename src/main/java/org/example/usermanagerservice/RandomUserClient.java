package org.example.usermanagerservice;

import org.example.usermanagerservice.dto.RandomUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "randomUserClient", url = "https://api.randomuser.me/")
public interface RandomUserClient {

    @GetMapping("/")
    RandomUserResponse getRandomUser();
}
