package ��д��;

import ��д��.*;


public class ReaderWriterTest {

	public void executeReaderWriterTest() {
		// ʵ��д����д�߼䡢������д�߼以��
        Semaphore wmutex = new Semaphore(1);
        // ���ڸı� readCount ����ʱʵ�ֻ���
        Semaphore rmutex = new Semaphore(1);

        for (int i = 0; i != 5; ++i) {
            new Thread(new Writer(wmutex)).start();
            new Thread(new Reader(rmutex, wmutex)).start();
        }
	}

}
