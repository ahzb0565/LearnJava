package bob.test.learnjava;

public class SortTest {
	public void sort(int[] l){
		System.out.println("Before sort:");
		this.printList(l);
		for(int i = 0; i< l.length; i++){
			for(int j = i+1; j< l.length; j++){
				if(l[i] > l[j]){
					int tmp = l[i];
					l[i] = l[j];
					l[j] = tmp;
				}
			}
		}
		System.out.println("\nAfter sort:");
		this.printList(l);
	}
	
	public void printList(int[] list){
		for (int i: list){
			System.out.print(i);
		}
	}
	
	public static void main(String[] args){
		int[] s = {5,3,7,1,8,2,0};
		new SortTest().sort(s);
	}
}
