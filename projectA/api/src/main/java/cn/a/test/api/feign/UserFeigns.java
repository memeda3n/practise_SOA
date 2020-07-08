package cn.a.test.api.feign;

import cn.a.test.api.fallback.UserFeignsFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "projectB", fallback = UserFeignsFallback.class)
public interface UserFeigns {

    @GetMapping("/getUser")
    String getUsers();

}
