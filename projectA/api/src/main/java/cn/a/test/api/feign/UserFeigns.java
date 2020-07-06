package cn.a.test.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("projectB")
public interface UserFeigns {

    @GetMapping("/getUser")
    String getUsers();
}
