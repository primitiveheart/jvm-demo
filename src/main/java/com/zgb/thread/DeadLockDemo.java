package com.zgb.thread;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/5 9:09 下午
 * @Created By guanbao.zhou
 */
public class DeadLockDemo implements Runnable {

  private Object object1 = new Object();
  private Object object2 = new Object();

  public void t1Method() {
    synchronized (object1) {
      synchronized (object2) {
        System.out.println(Thread.currentThread().getName() + " t1Method");
      }
    }
  }

  public void t2Method() {
    synchronized (object2) {
      synchronized (object1) {
        System.out.println(Thread.currentThread().getName() + " t2Method");
      }
    }
  }

  @Override
  public void run() {
    for(int i=0; i < 100; i++) {
      t1Method();
      t2Method();
    }
  }

  public static void main(String[] args) {
    DeadLockDemo deadLockDemo = new DeadLockDemo();
    Thread t1 = new Thread(deadLockDemo, "t1");
    Thread t2 = new Thread(deadLockDemo, "t2");
    t1.start();
    t2.start();
  }
}
