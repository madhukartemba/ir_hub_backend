package com.madhukartemba.irhub.resource;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResource {

    private String id;
    private String email;
    private String name;
    private Date created;
    private String createdBy;
    private Date lastModified;
    private String lastModifiedBy;

}
