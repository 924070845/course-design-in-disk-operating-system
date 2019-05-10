package ������������;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import ����.Test;

 
/**
 * �������ߡ��������ߵ����
 * 
 * @author alanzhangyx
 *
 */
public class ProducerConsumer {
	
	Test test=new Test();
 
    //����һ�����л�����������ΪInteger
    LinkedList<Integer> list = new LinkedList<Integer>();
 
    //���û������������
    static final int MAX_SIZE = 6;
 
    /**
     * �����ߡ�
     * 
     * <p>�����߽���Vԭ�����</p>
     * <ul>
     * <li>��ȡ�����������������û�дﵽMAX_SIZE��������һ����Ʒ��n��Ҳ�У����뻺�����������������߳�</li>
     * <li>����������ʹ�Լ����ߣ�������wait��</li>
     * </ul>
     *
     * @version  1.0.0
     * @author   alanzhangyx
     */
    class Producer implements Runnable{
        @Override
        public void run() {
            while (true) {
                synchronized (list){
                	
                    if (list.size() < MAX_SIZE) {
                        int num = new Random().nextInt(6);
                        list.add(num);
                        list.notifyAll();
                        System.out.println("������" + Thread.currentThread().getName() + "�����˲�Ʒ��" + num + "��----��ʱ����������Ϊ" + list.size());
 
                    }
 
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
 
    /**
     * �����ߡ�
     * 
     * <p>�����߽���Pԭ�����</p>
     * <ul>
     * <li>��ȡ����������������������ݣ���ӻ�����ȡ��һ����Ʒ��n��Ҳ�У��������������߳�</li>
     * <li>����������ʹ�Լ����ߣ�������wait��</li>
     * </ul>
     *
     * @version  1.0.0
     * @author   alanzhangyx
     */
    class Consumer implements Runnable{
        @Override
        public void run() {
            while (true) {
                synchronized (list){
                	
                    if (list.size() > 0) {
                        int num = list.poll();//poll��Queue�Ĳ�����ɾ������ͷԪ��
                        System.out.println("������" + Thread.currentThread().getName() + "�����˲�Ʒ��" + num + "��----��ʱ����������Ϊ" + list.size());
                        list.notifyAll();
                    }
 
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
 
 
    public void executeProducerConsumer() {
        ProducerConsumer pc = new ProducerConsumer();
 
        //Thread���캯����Ҫһ��Runnable���󼴿ɹ���һ���µ��̣߳�Runnable��������ظ����ã�����new���
        //һ�������ߣ�һ��������
        Consumer c = pc.new Consumer();
        Producer p = pc.new Producer();
 
        //�����ߺ�������˭��start��һ��
      
        
        for(int i=0;i<=100;i++){

       Thread t1 =  new Thread(c);
       t1.start();
       
       // new Thread(c).start();

 
       Thread t2 = new Thread(p);
       t2.start();
       // new Thread(p).start();
      
       
        while(true){
            
            Scanner sc = new Scanner(System.in);
         
            if("0".equals(sc.nextLine())){
          	  Test.main(null);

            	 System.exit(0);

            	  
            	}
            }
        
        
        

        }

     
    }
 
}
