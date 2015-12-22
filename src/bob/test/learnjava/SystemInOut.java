package bob.test.learnjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInOut {
	public static void main(String[] args){
		String s = "";
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);
		System.out.println("Press ctrl + z to exit");
		try{
			s = in.readLine();
			while (s != null){
				System.out.println("Read: "+ s);
				s = in.readLine();
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
