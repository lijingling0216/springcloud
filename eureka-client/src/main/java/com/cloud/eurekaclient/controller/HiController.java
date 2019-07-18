package com.cloud.eurekaclient.controller;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam String name){
        return "hi "+name+",i'm from port:"+port;
    }

    @RequestMapping("/stop")
    public String stop(){
        //服务下线，客户端的实例信息将从Eureka service的服务列表中删除(服务下线)
        DiscoveryManager.getInstance().shutdownComponent();
        return "success";
    }
}
