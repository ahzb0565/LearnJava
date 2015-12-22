package bob.test.learnjava;

public class InstanceCounter {
	private static int numInstance = 0;
	private static void addInstance(){
		numInstance++;
	}
	protected static int getCount(){
		return numInstance;
	}
	public InstanceCounter(){
		InstanceCounter.addInstance();
	}
	
	public static void main(String[] args){
		System.out.println("Starting with" + 
				InstanceCounter.getCount());
		for (int i = 0; i<5; i++){
			new InstanceCounter();
		}
		System.out.println("Add " + InstanceCounter.getCount() + " Instance");
	}

}
