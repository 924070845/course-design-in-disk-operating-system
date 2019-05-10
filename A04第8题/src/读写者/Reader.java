package ��д��;

import ��д��.Semaphore;;

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
            // ֻ�е�һ�����߽�����Ҫִ�� wmutex.p()
            if (readCount == 0) wmutex.p();
            readCount++;
            rmutex.v();

            // ִ�ж�����
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rmutex.p();
            readCount--;
            System.out.println(id + " �Ŷ��߽����Ķ�����ǰ��ʣ " + readCount + " λ�����ڶ�");
            if (readCount == 0) wmutex.v();
            rmutex.v();
        }
    }
}