package ��ѧ�ҽ���;



public class PerThread extends Thread {

	private static int[] chopstick = { 1, 1, 1, 1, 1 };
	private int i;

	public PerThread(int i) {
		this.i = i;
	}

	@Override
	public void run() {

		synchronized (chopstick) {  //��ע�ʹ��У������У���ͬ����5��perֻ�õ������
		//{	 
		eat(this.getName());

		think(this.getName());
		}

	}

	private void think(String name) {
		chopstick[i] = 1;
		chopstick[(i + 1) % 5] = 1;
		System.out.println(i+"����ѧ��"+"����˼������...");
		
	}

	private void eat(String string) {

			while (true) {

				if (chopstick[i] != 0) {
					chopstick[i]--;
					System.out.println(i+"����ѧ��" + " ������ֵĿ���.");
					break;
				}

			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			while (true) {
				if (chopstick[(i + 1) % 5] != 0) {
					chopstick[(i + 1) % 5]--;
					System.out.println(i+"����ѧ��" 
							+ " ������ֵĿ���.");
					break;
				}

			}
		System.out.println(i+"����ѧ��" + " ���ڳԷ�...");
	}
	
	
	
    public void executePerThread() {

		
        for (int i = 0; i < 5; i++) {
			
        	Thread t = new PerThread(i);

            t.start();  
		}		
	}
}