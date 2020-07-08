package cn.a.test.api.fallback;

import cn.a.test.api.feign.UserFeigns;
import org.springframework.stereotype.Component;

@Component
public class UserFeignsFallback implements UserFeigns {
    @Override
    public String getUsers() {
        return "user is null";
    }
}
