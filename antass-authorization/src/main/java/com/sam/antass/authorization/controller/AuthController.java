package com.sam.antass.authorization.controller;

import com.sam.antass.authorization.service.sentinel.SentinelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/antass/auth")
public class AuthController {

    @Autowired
    private SentinelServiceImpl sentinelService;

    @GetMapping(value = "/user/{id}")
    public String getUserAuths(@PathVariable(value = "id") String id) throws SQLException {
        return sentinelService.getUserAuths(id);
    }

}
