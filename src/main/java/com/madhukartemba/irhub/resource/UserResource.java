package com.madhukartemba.irhub.resource;

import java.time.Instant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResource {

    private String email;
    private String name;
    private Instant created;
    private String createdBy;
    private Instant lastModified;
    private String lastModifiedBy;

}
