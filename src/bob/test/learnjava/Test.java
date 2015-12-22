package bob.test.learnjava;

public class Test{
	public static void main(String[] args){
		int n = 3;
		int[][] s = Test.getSquare(n); 
		for(int[] i: s){
			for(int j: i){
				System.out.print(j);
			}
			System.out.println();
		}
		
	}
	public static int[][] getSquare(int n){
		int start = 1;
		int radius = 0;
		int[][] square= new int[2*n-1][2*n-1];
		for (int i = 0; i < 2*n -1; i++){
			for (int j = 0; j< 2*n -1; j++){
				int x = Math.abs(i - n + 1);
				int y = Math.abs(j - n + 1);
				radius = x > y? x:y;
				square[i][j] = start + radius;
			}
		}
		return square;
	}
}