package bob.test.learnjava;

public class Student {
	private int no;
	private String name;
	private String sex;
	private int age;
	public Student(int no, String name, String sex, int age){
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public Student(int no, String name, String sex){
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = 0;
	}
	public Student(int no, String name){
		this.no = no;
		this.name = name;
		this.sex = "Unkown";
		this.age = 0;
	}
	public Student(int no){
		this.no = no;
		this.name = "Unknown";
		this.sex = "Unknown";
		this.age = 0;
	}
	public int getNo(){
		return this.no;
	}
	public String getName(){
		return this.name;
	}
	public String getSex(){
		return this.sex;
	}
	public int getAge(){
		return this.age;
	}
}

class Undergraduate extends Student{
	private int telephone;

	public Undergraduate(int no) {
		super(no);
	}
	public Undergraduate(int no, String name) {
		super(no, name);
	}
	public Undergraduate(int no, String name, String sex) {
		super(no, name, sex);
	}
	public Undergraduate(int no, String name, String sex, int age) {
		super(no, name, sex, age);
	}
	public Undergraduate(int no, String name, String sex, int age, int telephone) {
		super(no, name, sex, age);
		this.telephone = telephone;
	}
	public int getNo(){
		return super.getNo();
	}
	public String getName(){
		return super.getName();
	}
	public String getSex(){
		return super.getSex();
	}
	public int getAge(){
		return super.getAge();
	}
	public int getTelephone(){
		return this.telephone;
	}
}
