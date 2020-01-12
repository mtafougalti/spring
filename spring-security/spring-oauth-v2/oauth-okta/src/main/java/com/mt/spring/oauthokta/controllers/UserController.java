package com.mt.spring.oauthokta.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Api(value = "Users Management Feature")
public class UserController {

    @GetMapping("/")
    @ApiOperation(value = "Get the current user infos")
    public String helloUser(Principal principal){
        return "Hello " + principal.getName();
    }
}
