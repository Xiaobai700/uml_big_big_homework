package cn.njupt.rest_reservation.javademo;

/**
 * Created by zhangqiao on 2019/4/8.
 */
public class ReflectDemo {
    public static void main(String[] args){
        try {
            Class clz = Class.forName(args[0]);
            System.out.println(clz.getName());
            System.out.println(clz.isInterface());
            System.out.println(clz.isPrimitive());
            System.out.println(clz.isArray());
            System.out.println(clz.getSuperclass().getName());
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("没有指定类名称");
        }catch (ClassNotFoundException e){
            System.out.println("找不到指定的类"+args[0]);
        }
    }
}
