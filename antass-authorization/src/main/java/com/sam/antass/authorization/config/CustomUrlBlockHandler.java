package com.sam.antass.authorization.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CustomUrlBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        String message = null;
        if (e instanceof FlowException) {
            message = "限流了";
        }
        if (e instanceof DegradeException) {
            message = "降级了";
        }
        if (e instanceof ParamFlowException) {
            message = "热点参数限流";
        }
        if (e instanceof SystemBlockException) {
            message = "系统规则（负载/...不满足要求）";
        }
        if (e instanceof AuthorityException) {
            message = "授权规则不通过";
        }
        httpServletResponse.setHeader("Content-Type","application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(String.format("{\"code\":999,\"msg\":\"%s\"}", message));
    }
}
