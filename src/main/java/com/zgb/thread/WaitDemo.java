package com.zgb.thread;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/5 8:53 下午
 * @Created By guanbao.zhou
 */
public class WaitDemo implements Runnable {

  @Override
  public void run() {
    synchronized (this) {
      try {
        this.wait(50000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    WaitDemo waitDemo = new WaitDemo();
    Thread t1 = new Thread(waitDemo, "t1");
    Thread t2 = new Thread(waitDemo, "t2");
    t1.start();
    t2.start();
  }
}
