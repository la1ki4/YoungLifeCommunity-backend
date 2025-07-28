package org.yl.YoungLifeCommunity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yl.YoungLifeCommunity.entities.YLUserEntity;
import org.yl.YoungLifeCommunity.services.YLUserService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/yl-users")
public class YLUserController {
    private final YLUserService ylUserService;

    @GetMapping("/")
    public Optional<List<YLUserEntity>> findAllYLUsers() {
        return ylUserService.getAllYLUsers();
    }
}
