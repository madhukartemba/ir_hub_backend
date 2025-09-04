package com.madhukartemba.irhub.api.priv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhukartemba.irhub.assembler.UserResourceAssembler;
import com.madhukartemba.irhub.entity.User;
import com.madhukartemba.irhub.resource.UserResource;
import com.madhukartemba.irhub.service.UserService;

@RestController
@RequestMapping(value = "/api/private/users", produces = "application/json")
public class PrivateUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserResourceAssembler assembler;

    @GetMapping("/currentUser")
    public ResponseEntity<UserResource> getCurrentUser() {
        User user = userService.getUserFromContext();

        return ResponseEntity.ok(assembler.toModel(user));
    }

}
