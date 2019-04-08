package cn.njupt.rest_reservation;

/**
 * Created by zhangqiao on 2019/4/5.
 */
class  ThreadZy implements Runnable{
    private int ticket = 8;

    @Override
    public void run() {
        System.out.println("1.进入Run方法");
        try {
          Thread.sleep(10000);
          System.out.println("2.线程已经完成休眠！");
        }catch (Exception e){
            System.out.println("3.休眠被终止！");
        }
    }
}
public class MyThread {
    public static  void main(String args[]){

        ThreadZy threadZy1 = new ThreadZy();
        Thread t1 = new Thread(threadZy1);
        t1.start();
        /*try{
            Thread.sleep(10000);
        }catch (Exception e){

        }*/
        t1.interrupt();
    }



}
