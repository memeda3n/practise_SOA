package cn.b.test.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/feign")
@RestController
public class FeignTestController {

    @GetMapping("/getUser")
    public String getUser() {
        return "userFeign.getUser()";
    }


}
