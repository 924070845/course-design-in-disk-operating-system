package 读写者;

import 读写者.Method;

/*
该类用于模拟信号量及其P,V操作
使用方法如下：

method.Semaphore mutex = new method.Semaphore(1);            //信号量的初值赋为1
mutex.p();
//临界区代码
mutex.v();
*/

public class Semaphore implements Method {
private int semValue;
public Semaphore(int semValue) {
    this.semValue = semValue;
}
public synchronized void p() {
    semValue--;
    if (semValue < 0) {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public synchronized void v(){
    semValue++;
    if (semValue <= 0) {
        this.notify();
    }
}
}