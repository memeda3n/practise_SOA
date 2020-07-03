package cn.test.api;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@EnableEurekaClient
@EnableAutoConfiguration
@ComponentScan(basePackages = "cn.test.api")
public class ProjectB_application {

    @Value("${server.port}")
    private String port;

    public static void main(String[] args) {
        SpringApplication.run(ProjectB_application.class, args);
    }
    @Autowired
    private EurekaClient discoveryClient;

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
