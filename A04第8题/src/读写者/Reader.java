package 读写者;

import 读写者.Semaphore;;

public class Reader implements Runnable {
    private static int total = 0;
    private int id;
    private Semaphore rmutex, wmutex;
    private static int readCount = 0;

    public Reader(Semaphore rmutex, Semaphore wmutex) {
        id = ++total;
        this.rmutex = rmutex;
        this.wmutex = wmutex;
    }

    @Override
    public void run() {
        while (true) {
            rmutex.p();
            // 只有第一个读者进程需要执行 wmutex.p()
            if (readCount == 0) wmutex.p();
            readCount++;
            rmutex.v();

            // 执行读操作
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rmutex.p();
            readCount--;
            System.out.println(id + " 号读者结束阅读：当前还剩 " + readCount + " 位读者在读");
            if (readCount == 0) wmutex.v();
            rmutex.v();
        }
    }
}