package cn.njupt.rest_reservation.javademo;

/**
 * Created by zhangqiao on 2019/4/8.
 */
public class HelloSpeaker implements Hello {
    @Override
    public void hello(String name) {
        System.out.println("哈喽，"+name);
    }
}
