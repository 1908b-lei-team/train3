package com.fh.resolver;

import com.alibaba.fastjson.JSONObject;
import com.fh.User.User;
import com.fh.common.SystemConstant;
import com.fh.common.UserAnnotation;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class UserResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if(methodParameter.hasParameterAnnotation(UserAnnotation.class)){
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        //Member member = (Member) request.getSession().getAttribute(SystemConstant.SESSION_KEY);
        String header = request.getHeader(SystemConstant.SESSION_KEY);
        User user = JSONObject.parseObject(header, User.class);
        return user;
    }
}
