package cn.a.test.api;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class ProjectA_application {
    @Value("${server.port}")
    private String port;
    @Autowired
    private EurekaClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(ProjectA_application.class, args);
    }

    @RequestMapping("/hi")
    public String hello(@RequestParam String name) {
        return "hello world," + name + "," + "I am from port:" + port;
    }

    @RequestMapping("/info")
    public String info() {
        return "hello, I am eureka client, i am from prot:" + port;
    }

    @RequestMapping("/health")
    public String health() {
        return "i am health,I am from port:" + port;
    }

    @RequestMapping("/instance")
    public String instance() {
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("TEST-EUREKA", false);
        return instanceInfo.getHomePageUrl();
    }

    @RequestMapping("/testZuul")
    public String testZuul() {

        System.out.println("路由进来了");
        return "success";
    }
}