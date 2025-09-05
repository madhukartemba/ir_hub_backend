package com.madhukartemba.irhub.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.madhukartemba.irhub.dao.UserDAO;
import com.madhukartemba.irhub.entity.User;
import com.madhukartemba.irhub.exception.AlreadyExistsException;
import com.madhukartemba.irhub.request.CreateUserRequest;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User createAdminUser(CreateUserRequest request) throws Exception {
        return createUser(request, Set.of(User.Role.ADMIN));
    }

    public User createUser(CreateUserRequest request) throws Exception {
        return createUser(request, Set.of(User.Role.USER));
    }

    @Transactional
    private User createUser(CreateUserRequest request, Set<User.Role> roles) throws Exception {
        User existing = findByEmail(request.getEmail());

        if (existing != null) {
            throw new AlreadyExistsException("User already exists!");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (request.getName() != null) {
            user.setName(request.getName());
        } else {
            user.setName(request.getEmail());
        }

        user.setRoles(new HashSet<>(roles));

        return userDAO.save(user);

    }

    public User getUserFromContext() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            return null;
        }

        User user = (User) authentication.getPrincipal();

        user = userDAO.findById(user.getId()).orElse(null);

        return user;
    }

    public User findByEmail(String email) {
        return userDAO.findByEmail(email).orElse(null);
    }

    public User findById(String id) {
        return userDAO.findById(UUID.fromString(id)).orElse(null);
    }

}
