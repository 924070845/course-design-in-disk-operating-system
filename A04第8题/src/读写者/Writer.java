package ��д��;

import ��д��.Semaphore;;

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
            // ִ��д����
            System.out.println(id + " ��д������д");

            wmutex.v();
        }
    }
}