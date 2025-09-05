package com.madhukartemba.irhub.assembler;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.madhukartemba.irhub.entity.User;
import com.madhukartemba.irhub.resource.UserResource;

@Component
public class UserResourceAssembler implements BaseAssembler<User, UserResource> {

    @Override
    public UserResource toModel(User user) {
        UserResource resource = new UserResource();
        BeanUtils.copyProperties(user, resource);
        return resource;
    }

}
