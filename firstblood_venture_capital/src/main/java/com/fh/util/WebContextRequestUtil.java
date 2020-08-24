package com.fh.util;

import javax.servlet.http.HttpServletRequest;

public class WebContextRequestUtil {

    static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<>();

    /**
     * 把request放到当前线程中
     *
     * @param request
     */
    public static void setThreadLocal(HttpServletRequest request) {
        threadLocal.set(request);
    }

    /**
     * 获取request对象
     *
     * @return
     */
    public static HttpServletRequest getThreadLocal() {
        return threadLocal.get();
    }

    /**
     * 当前线程走完，需要remove掉
     */
    public static void remove() {
        threadLocal.remove();
    }
}
