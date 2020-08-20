package com.fh.exception;

import com.fh.common.ServerResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 配置一个全局的异常
 * 把需要配置的异常在这里进行配置，当抛异常时候，返回前台一个error，前台就可以根据这个返回的code进行判断
 *
 * @RestController 写上以后，下边的方法就不需要写ReponseBody
 * <p>
 * 要使注解生效，在spring-mvc-controller.xml文件需要配置
 */
@RestControllerAdvice
public class ClobleHandlerException {


    /**
     * 自定义的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ServerResponse myExceptionHandler(MyException e) {
        e.printStackTrace();
        String message = e.getMessage();
        return ServerResponse.errorMethod(message);
    }

    /**
     * 登录拦截的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(LoginException.class)
    public ServerResponse myExceptionHandler(LoginException e) {
        e.printStackTrace();
        return ServerResponse.loginErrorMethod();
    }


    /**
     * 抛所有的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ServerResponse exceptionHandler(Exception e) {
        e.printStackTrace();
        return ServerResponse.errorMethod();
    }


}
