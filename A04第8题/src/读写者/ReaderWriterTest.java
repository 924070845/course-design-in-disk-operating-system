package 读写者;

import 读写者.*;


public class ReaderWriterTest {

	public void executeReaderWriterTest() {
		// 实现写者与写者间、读者与写者间互斥
        Semaphore wmutex = new Semaphore(1);
        // 用于改变 readCount 变量时实现互斥
        Semaphore rmutex = new Semaphore(1);

        for (int i = 0; i != 5; ++i) {
            new Thread(new Writer(wmutex)).start();
            new Thread(new Reader(rmutex, wmutex)).start();
        }
	}

}
