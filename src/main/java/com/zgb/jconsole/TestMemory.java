package com.zgb.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * 虚拟参数为：-Xms100m -Xmx100m -XX:+UseSerialGC
 * @author xmly
 * @email guanbao.zhou@ximalaya.com
 * @Date 2020/2/2 10:08 上午
 * @Created By guanbao.zhou
 */
public class TestMemory {
  static class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];
  }

  public static void fillHeap(int num) throws InterruptedException {
    List<OOMObject> list = new ArrayList<>();
    for (int i=0; i< num; i++) {
      Thread.sleep(500);
      list.add(new OOMObject());
    }
    System.gc();
  }

  public static void main(String[] args) throws InterruptedException {
    fillHeap(1000);
  }
}
