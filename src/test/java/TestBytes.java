
public class TestBytes extends Thread{
	
	private Test test;
	
	public TestBytes(Test test){
		this.test = test;
	}
	
	public void run(){
		test.print(currentThread().toString());
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		TestBytes t1 = new TestBytes(test);
		TestBytes t2 = new TestBytes(test);
		t1.start();
		t2.start();
	}

	
}

class Test{
	
	String string = "";
	
	public void print(String str){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread()+":String =" + str);
	}
}
