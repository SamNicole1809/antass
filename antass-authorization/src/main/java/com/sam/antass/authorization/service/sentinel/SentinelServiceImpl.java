package com.sam.antass.authorization.service.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class SentinelServiceImpl implements SentinelService {

    @Override
    @SentinelResource(value = "getUserAuths" ,fallback = "getUserAuthsExceptionHandler")
    public String getUserAuths(String id) throws SQLException {
        if ("5".equals(id)) {
            throw new SQLException();
        }
        return String.format("User ID => %s", id);
    }

    public String getUserAuthsExceptionHandler(String id) {
        return "您的网络有问题";
    }

}
