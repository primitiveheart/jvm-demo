package com.zgb.jconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 10:39 上午
 * @Created By guanbao.zhou
 */
public class TestThread {
  /**
   * 创建死循环线程
   */
  public static void createBusyThread() {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {

        }
      }
    }, "testBusyThread");
    thread.start();
  }

  /**
   * 线程锁等待演示
   * @param lock
   */
  public static void createLockThread(final Object lock) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }, "testLockWait");
    thread.start();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    createBusyThread();
    br.readLine();
    Object lock = new Object();
    createLockThread(lock);
  }
}
