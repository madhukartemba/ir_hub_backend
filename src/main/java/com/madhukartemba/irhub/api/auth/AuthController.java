package com.madhukartemba.irhub.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhukartemba.irhub.assembler.UserResourceAssembler;
import com.madhukartemba.irhub.entity.User;
import com.madhukartemba.irhub.request.CreateUserRequest;
import com.madhukartemba.irhub.request.UserLoginRequest;
import com.madhukartemba.irhub.resource.AccessTokenResource;
import com.madhukartemba.irhub.resource.UserResource;
import com.madhukartemba.irhub.service.UserService;
import com.madhukartemba.irhub.utils.JWTUtils;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/auth", produces = "application/json")
@Slf4j
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserResourceAssembler userResourceAssembler;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<UserResource> createNewUser(@Valid @RequestBody CreateUserRequest request) throws Exception {

        log.info("Creating new user with email: {}", request.getEmail());

        User user = userService.createUser(request);
        UserResource userResource = userResourceAssembler.toModel(user);

        return ResponseEntity.ok(userResource);
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResource> userLogin(@Valid @RequestBody UserLoginRequest request)
            throws Exception {

        log.info("User login attempt with email: {}", request.getEmail());

        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        User user = (User) auth.getPrincipal();

        String token = jwtUtils.generateToken(user.getEmail());

        return ResponseEntity.ok(new AccessTokenResource(token, "placeholder"));
    }

}
