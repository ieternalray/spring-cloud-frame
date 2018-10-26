package com.eternalray.filter;

import com.alibaba.fastjson.JSONObject;
import com.eternalray.common.CustomUtils;
import com.eternalray.common.Result;
import com.eternalray.user.UserAuthClient;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Eternalray
 */
@Configuration
@Slf4j
public class AccessGatewayFilter extends ZuulFilter {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserAuthClient userAuthClient;

    /**
     *  FILTER_TYPE 枚举值：pre, routing, post, error
     */
    final private String FILTER_TYPE="pre";
    /**
     *  FILTER_ORDER 优先级， 0是最高优先级即最先执行
     */
    final private int FILTER_ORDER=0;
    /**
     *  SHOULD_FILTER 写逻辑，是否需要执行过滤。true会执行run函数，false不执行run函数
     */
    final private boolean SHOULD_FILTER=true;
    /**
     *  /user/login 用户服务登陆接口
     */
    final private String LOGIN_PATH="/user/login";
    /**
     *  RELEASE_PATH 放行路径 多个路径以,分割
     *  /user/register 普通用户注册
     *  /user/usePhoneRegister 手机用户注册
     */
    final private String RELEASE_PATH="/user/register,/user/usePhoneRegister";

    @Override
    public String filterType() {
        return FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run(){
        RequestContext ctx = null;
        try {
            ctx = RequestContext.getCurrentContext();
            HttpServletRequest req = ctx.getRequest();
            String requestURI = req.getRequestURI();
            //登陆路径不进行拦截
            if (CustomUtils.isStartWith(requestURI,LOGIN_PATH)){
                String userName = req.getParameter("userName");
                String password = req.getParameter("password");
                Object loginResult = userAuthClient.login(userName, password);
                // TODO: 业务逻辑在此处理
                //返回响应数据
                ctx.setResponseStatusCode(200);
                ctx.setResponseBody(JSONObject.toJSONString(loginResult));
            }//放行路径不进行拦截
            else if(CustomUtils.isStartWith(requestURI,RELEASE_PATH)){
                ctx.setSendZuulResponse(true);
            }//非放行路径则需要进行鉴权
            else{
                String token = req.getHeader("Authorization");
                Object authResultObj = userAuthClient.verifyToken(token);
                Result authResult = (Result) authResultObj;
                //判断鉴权是否通过
                if (authResult.isSuccess()) {
                    // TODO:  业务逻辑在此处理
                    ctx.setSendZuulResponse(true);
                }else{
                    ctx.setResponseStatusCode(404);
                }
            }
        } catch (Exception e) {
            log.error("认证网关过滤器错误",e);
            ctx.setResponseStatusCode(500);
        }
        return null;
    }
}
