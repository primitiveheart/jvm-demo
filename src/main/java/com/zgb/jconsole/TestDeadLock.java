package com.zgb.jconsole;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 10:52 上午
 * @Created By guanbao.zhou
 */
public class TestDeadLock {
  static class SyncAddRunnable implements Runnable {

    int a,b;
    public SyncAddRunnable(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public void run() {
      synchronized (Integer.valueOf(a)) {
        synchronized (Integer.valueOf(b)) {
          System.out.println(a + b);
        }
      }
    }
  }

  public static void main(String[] args) {
    for (int i=0;i<1000;i++) {
      new Thread(new SyncAddRunnable(1,2));
      new Thread(new SyncAddRunnable(2,1));
    }
  }
}
