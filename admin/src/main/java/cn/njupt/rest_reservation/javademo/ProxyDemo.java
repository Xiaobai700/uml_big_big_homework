package cn.njupt.rest_reservation.javademo;

/**
 * Created by zhangqiao on 2019/4/8.
 */
public class ProxyDemo {
    public static void main(String[] args){
        LoggingHandler loggingHandler = new LoggingHandler();

        //HelloSpeaker是被代理对象，helloProxy是代理对象
        Hello helloProxy = (Hello) loggingHandler.bind(new HelloSpeaker());

        helloProxy.hello("张巧");
    }
}
