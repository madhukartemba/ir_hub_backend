package com.madhukartemba.irhub.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenResource {

    private String token;
    private String refreshToken;
}
