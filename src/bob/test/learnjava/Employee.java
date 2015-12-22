package bob.test.learnjava;

public class Employee {
	String name;
	int age;
	String description;

	public Employee(String name){
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	/*public int getAge(){
		return this.age;
	}
	*/
	
	public void setDescription(String des){
		this.description = des;
	}
	
	public void introduce(){
		System.out.println("My name is "+ this.name);
		System.out.println("My age is "+ this.age);
		System.out.println(this.description);
		System.out.println("Thank you!");
	}

}
