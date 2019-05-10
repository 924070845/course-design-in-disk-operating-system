package ��д��;

import ��д��.Method;

/*
��������ģ���ź�������P,V����
ʹ�÷������£�

method.Semaphore mutex = new method.Semaphore(1);            //�ź����ĳ�ֵ��Ϊ1
mutex.p();
//�ٽ�������
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