package com.test.eurekaribbon.controller;

import com.test.eurekaribbon.service.EurekaRibbonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：XuQiangsheng
 * @date ：Created in 2019/9/18 14:14
 */
@RestController
public class EurekaRibbonController {

    @Resource
    private EurekaRibbonService eurekaRibbonService;

    @RequestMapping("/ribbonInfo")
    public String ribbonInfo() {
        String message = eurekaRibbonService.getInfo();
        return "获取的信息:" + message;
    }

}
