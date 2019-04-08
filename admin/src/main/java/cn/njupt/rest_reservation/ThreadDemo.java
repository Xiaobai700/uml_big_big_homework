package cn.njupt.rest_reservation;

/**
 * Created by zhangqiao on 2019/4/5.
 */

class Info{
    private String name = "张巧";
    private String content = "学生";
    private boolean flag = false;

    public synchronized void set(String name,String content){
        if(!flag){
            try {
                super.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(300);
            flag = false;
            super.notify();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.setContent(content);
    }

    public synchronized void get(){
        if(flag){
            try {
                super.wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(this.getName()+"->"+this.getContent());
        flag = true;
        super.notify();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Producer implements Runnable{
    private Info info = null;
    public Producer(Info info){
        this.info = info;
    }

    @Override
    public void run() {
        boolean flag = false;
        for(int i = 0;i < 50;i++){
            if(flag){
                this.info.set("张巧","学生");
                flag = false;
            }else{
                this.info.set("张云","研究生");
                flag = true;
            }
        }

    }
}

class Consumer implements Runnable{
    private Info info = null;
    public Consumer(Info info){
        this.info = info;
    }

    @Override
    public void run() {
        for(int i = 0;i < 50;i++){
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
           this.info.get();
        }
    }
}
public class ThreadDemo {
    public static void main(String args[]){

        Info i = new Info();
        Producer producer = new Producer(i);
        Consumer consumer = new Consumer(i);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
