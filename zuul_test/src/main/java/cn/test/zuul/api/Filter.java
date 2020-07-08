package cn.test.zuul.api;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Filter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("token");
        if (token == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object run()   {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletResponse response =ctx.getResponse();
            response.getWriter().write("token 不可为空");
        }catch (Exception e){
        }
        return  null;
    }
}
