package ����;

import java.util.Scanner;

import ��ѧ�ҽ���.PerThread;
import ������������.ProducerConsumer;
import ��д��.ReaderWriterTest;

public class Test {

	public static void main(String[] args) {
		String str=null; 
		Scanner s;
		ProducerConsumer pc=new ProducerConsumer();
		PerThread pt=new PerThread(5);
		ReaderWriterTest rw=new ReaderWriterTest(); 
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ���еĲ���");
		System.out.println("1.������������");
		System.out.println("2.��ѧ�ҽ���");
		System.out.println("3.��д��");
		s=new Scanner(System.in);
		str=s.nextLine();
		
		switch (str) {
		case "1":pc.executeProducerConsumer();break;
		case "2":pt.executePerThread();break;
		case "3":rw.executeReaderWriterTest();;break;
		default:
			System.out.println("�������");
			
			break;
		}
	}

}
