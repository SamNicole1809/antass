package com.sam.antass.personnel.controller;

import com.sam.antass.dubbo.api.service.AntassDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/antass/personnel")
public class UserController {

    @DubboReference
    AntassDubboService antassDubboService;

    @GetMapping(value = "/user/{id}")
    public String getUser(@PathVariable(value = "id") String id) {
        return antassDubboService.getUser(id);
    }

}
