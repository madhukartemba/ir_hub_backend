package com.madhukartemba.irhub.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madhukartemba.irhub.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);
}
