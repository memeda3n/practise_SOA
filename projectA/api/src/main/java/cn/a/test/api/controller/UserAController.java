package cn.a.test.api.controller;


import cn.a.test.api.feign.UserFeigns;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class UserAController {

    @Resource
    UserFeigns feigns;

    @GetMapping("/getUser")
    public String getUser() {
        System.out.println("getUser dddddddddddddddd");
        return feigns.getUsers();
    }

}
