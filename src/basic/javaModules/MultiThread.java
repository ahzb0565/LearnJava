package basic.javaModules;
/*
 * Java 多线程一般大家都说是两种方法，其实都是用的Thread的两种构造方法
 * 1. Extends Thread and overwrite run()
 * 2. implements Runnable, 实现 run(), new Thread(Runnable r)
 * 关于线程同步，一般两种
 * 1. synchronized method
 * 2. lock等方法
 */
public class MultiThread {
	public static void main(String[] args){
		ThreadMethod t = new ThreadMethod();
		Thread mt1 = new MyThread(t);
		Thread mt2 = new Thread(new MyThreadRunnable(t));
		mt1.start();
		mt2.start();
	}
}

class ThreadMethod{
	private static boolean using = false;
	public synchronized void counter(String name){
		if (using){
			System.out.println(name+ ": is using, wait...");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name+ ": is usable, lock..");
		using = true;
		for(int i = 1; i< 10; i++){
			
			System.out.println(name+ " : "+ i);
			
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name+ ": finished! notify");
		using = false;
		notify();
	}
}

class MyThread extends Thread{
	//public void start(){}
	private ThreadMethod tm;
	public MyThread(ThreadMethod t){
		super("MyThread");
		this.tm = t;
	}
	public void run(){
		//ThreadMethod t = new ThreadMethod();
		tm.counter(this.getName());
	}
}

class MyThreadRunnable implements Runnable{
	private String name = "MyThreadRunnable";
	private ThreadMethod tm;
	public MyThreadRunnable(ThreadMethod t){
		this.tm = t;
	}
	public void run() {
		System.out.println("This is MyThreadRunnable obj implements Runnable");
		//ThreadMethod t = new ThreadMethod();
		tm.counter(this.name);
	}
	
}

