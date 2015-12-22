package bob.test.learnjava;

public class Dog {
	String name;
	String breed;
	int age;
	String color;

	public static void main(String[] args){
		Dog dog_hui = new Dog("Hui");
		dog_hui.setAge(3);
		Dog dog_default = new Dog();
		dog_default.setAge(5);
		System.out.println("My name is :" + dog_hui.name);
		System.out.println("My age is: "+ dog_hui.age);
		System.out.println("My name is :" + dog_default.name);
		System.out.println("My age is: "+ dog_default.age);
		boolean result = dog_hui instanceof Dog;
		System.out.println("dog_hui is instance of Dog: "+ result);
	}
    public Dog(){
    	this.name = "default";
    }

    public Dog(String name){
    	this.name = name;
    }

    public void setAge(int age){
    	this.age = age;
    }

    public int getAge(){
    	return this.age;
    }

	void barking(){
	}

	void hungry(){
	}

	void sleeping(){
	}
}
