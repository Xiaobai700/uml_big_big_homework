package cn.njupt.rest_reservation.javademo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.*;
import java.util.logging.*;

/**
 * Created by zhangqiao on 2019/4/8.
 */
public class LoggingHandler implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target = target;

        //动态建立代理对象，指定类加载器，告知要代理的接口，以及接口上定义方法被调用时的处理者
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    /*代理对象的方法被调用时会调用此方法*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try{
            log(String.format("%s()呼叫开始。。。",method.getName()));
            result = method.invoke(target,args);
            log(String.format("%s()呼叫结束。。。",method.getName()));
        }catch (IllegalAccessException | IllegalArgumentException |InvocationTargetException e){
            log(e.toString());
        }
        return result;
    }

    private void log(String message){
        Logger.getLogger(LoggingHandler.class.getName()).log(Level.INFO,message);
    }
}
