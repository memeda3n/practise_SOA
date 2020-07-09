package cn.test.zuul.api;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

@Component
public class PreFilter extends ZuulFilter {


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
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        String token = request.getHeader("token");
//        if (token == null) {
//            return true;
//        }
        return true;
    }

    @Override
    public Object run() {
//        try {
//            RequestContext ctx = RequestContext.getCurrentContext();
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            HttpServletResponse response = ctx.getResponse();
//            response.setCharacterEncoding("utf8");
//            response.getWriter().write("token 不可为空");
//        } catch (Exception e) {
//        }

        System.out.println("pre ======");
        return null;
    }


}
