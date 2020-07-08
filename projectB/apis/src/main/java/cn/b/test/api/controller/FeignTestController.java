package cn.b.test.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

//@RequestMapping("/feign")
@RestController
public class FeignTestController {

    @GetMapping("/getUser")
    public String getUser() throws Exception {

//        throw new Exception("");

        TimeUnit.SECONDS.sleep(3);

        System.out.println("======================");
        return "userFeign.getUser()";
    }

}
