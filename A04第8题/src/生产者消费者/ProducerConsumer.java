package 生产者消费者;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import 测试.Test;

 
/**
 * 多生产者、多消费者的情况
 * 
 * @author alanzhangyx
 *
 */
public class ProducerConsumer {
	
	Test test=new Test();
 
    //定义一个队列缓冲区，数据为Integer
    LinkedList<Integer> list = new LinkedList<Integer>();
 
    //设置缓冲区最大容量
    static final int MAX_SIZE = 6;
 
    /**
     * 生产者。
     * 
     * <p>生产者进行V原语操作</p>
     * <ul>
     * <li>获取缓冲区，如果缓冲区没有达到MAX_SIZE，则生产一个产品（n个也行）放入缓冲区，并唤醒所有线程</li>
     * <li>无论如何最后使自己休眠（这里是wait）</li>
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
                        System.out.println("生产者" + Thread.currentThread().getName() + "生产了产品：" + num + "，----此时缓冲区容量为" + list.size());
 
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
     * 消费者。
     * 
     * <p>消费者进行P原语操作</p>
     * <ul>
     * <li>获取缓冲区，如果缓冲区有数据，则从缓冲区取出一个产品（n个也行），并唤醒所有线程</li>
     * <li>无论如何最后使自己休眠（这里是wait）</li>
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
                        int num = list.poll();//poll是Queue的操作，删除队列头元素
                        System.out.println("消费者" + Thread.currentThread().getName() + "消费了产品：" + num + "，----此时缓冲区容量为" + list.size());
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
 
        //Thread构造函数需要一个Runnable对象即可构造一个新的线程，Runnable对象可以重复利用，不必new多个
        //一个消费者，一个生产者
        Consumer c = pc.new Consumer();
        Producer p = pc.new Producer();
 
        //生产者和消费者谁先start都一样
      
        
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
