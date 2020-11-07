package com.sam.antass.authorization.service.dubbo;

import com.sam.antass.dubbo.api.service.AntassDubboService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class AuthService implements AntassDubboService {

    @Override
    public String getUser(String userId) {
        return String.format("%s ID => Sam", userId);
    }
}
