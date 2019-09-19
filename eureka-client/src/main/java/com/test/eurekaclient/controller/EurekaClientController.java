package com.test.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：XuQiangsheng
 * @date ：Created in 2019/9/18 8:53
 */
@RestController
public class EurekaClientController {

    @Value("${server.port}")
    private String port;

    /**
     * 提供的一个restful服务，返回内容格式：服务协议://服务器地址:服务端口/服务uri
     *
     * @param request
     * @return
     */
    @RequestMapping("/info")
    public String info(HttpServletRequest request) {
        String message = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        return message;
    }
}
