package 测试;

import java.util.Scanner;

import 哲学家进餐.PerThread;
import 生产者消费者.ProducerConsumer;
import 读写者.ReaderWriterTest;

public class Test {

	public static void main(String[] args) {
		String str=null; 
		Scanner s;
		ProducerConsumer pc=new ProducerConsumer();
		PerThread pt=new PerThread(5);
		ReaderWriterTest rw=new ReaderWriterTest(); 
		// TODO Auto-generated method stub
		System.out.println("请输入所要进行的操作");
		System.out.println("1.生产者消费者");
		System.out.println("2.哲学家进餐");
		System.out.println("3.读写者");
		s=new Scanner(System.in);
		str=s.nextLine();
		
		switch (str) {
		case "1":pc.executeProducerConsumer();break;
		case "2":pt.executePerThread();break;
		case "3":rw.executeReaderWriterTest();;break;
		default:
			System.out.println("输入错误");
			
			break;
		}
	}

}
