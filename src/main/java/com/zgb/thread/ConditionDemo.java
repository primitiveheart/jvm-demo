package com.zgb.thread;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/5 9:42 下午
 * @Created By guanbao.zhou
 */
public class ConditionDemo implements Runnable{
  @Override
  public void run() {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    ConditionDemo conditionDemo = new ConditionDemo();
    Thread t1 = new Thread(conditionDemo, "t1");
    t1.start();
  }
}
