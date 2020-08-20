package com.fh.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 把request作为一个全局的，用的时候，直接调用，而不需要每次都创建
 * <p>
 * 项目运行时，先过滤器 再拦截器
 */
public class WebContextRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        WebContextRequestUtil.setThreadLocal((HttpServletRequest) request);

        try {
            chain.doFilter(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } finally {
            WebContextRequestUtil.remove();
        }
    }

    @Override
    public void destroy() {

    }
}
