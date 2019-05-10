package 读写者;

import 读写者.Semaphore;;

public class Writer implements Runnable {
    private static int total = 0;
    private int id;
    private Semaphore wmutex;

    public Writer(Semaphore wmutex) {
        id = ++total;
        this.wmutex = wmutex;
    }

    @Override
    public void run() {
        while (true) {
            wmutex.p();
            // 执行写操作
            System.out.println(id + " 号写者正在写");

            wmutex.v();
        }
    }
}