package bob.test.learnjava;
import java.io.*;

public class EmployeeTest {
	public static void main(String[] args){
		Employee e1 = new Employee("Bob");
		e1.setAge(1);
		String s1 = "I'm good at programing!";
		e1.setDescription(s1);
		Employee e2 = new Employee("Jim");
		e2.setAge(2);
		String s2 = "I'm good at singing!";
		e2.setDescription(s2);
		
		e1.introduce();
		e2.introduce();
	}
}
