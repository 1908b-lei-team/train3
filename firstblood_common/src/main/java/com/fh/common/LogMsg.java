package com.fh.common;


import java.lang.annotation.*;

@Documented //它的作用是能够将注解中的元素包含到 Javadoc 中去
@Target(ElementType.METHOD) //表示我们的注解作用的范围就比较具体了，可以是类，方法，方法参数变量
@Retention(RetentionPolicy.RUNTIME)//它表示注解存在阶段是保留在源码（编译期）,注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface LogMsg {
    String value();

}
