package basic.javaModules;

public class StringOprate {
	/*
	 * String 本身就是个就是个封装类
	 * String s = ""// 这种是直接存放于堆栈
	 * String s = new String("")// 这个需要分配内存空间的
	 * 但是对于字符串的插入/删减/替换等操作时，String比较乏力
	 * 通常用StringBuffer/StringBuilder 来做
	 */
	public static void main(String[] args){
		StringOprate so = new StringOprate();
		so.testStringBuilderOrBuffer();
	}
	public void testString(){
		/*
		 * 常用string的方法有
		 * valueOf/toCharArray/getBytes/codePointAt/getChars
		 * startsWith/endsWith/indexOf/isEmpty
		 * replace/split/toLowerCase/toUpperCase/trim
		 * lenghth
		 * 等。 如果是静态使用是很够用的
		 */
		String s = "123  Good  好好学习   ";
		assert s.endsWith(" ");
		assert s.startsWith("12");
		assert s.trim().endsWith("学习");
		System.out.println(s.length());
		System.out.println(s.getBytes().length);
		System.out.println(s.toCharArray().length);
		assert s.indexOf("G") == 5;
		assert !s.isEmpty();
		System.out.println( s.toLowerCase());
		System.out.println(s.replace("Good", "Better"));
		System.out.println(s.split(" ")[4]);
	}
	public void testStringBuilderOrBuffer(){
		/*
		 * StringBuilder 和StringBuffer 继承ＡbstractStringBuilder
		 * StringBuffer/StringBuilder 主要区别是线程安全问题
		 * Buffer 线程安全，但是效率比不上builder
		 * 常用方法有
		 * length/capacity/setLength/charAt/setCharAt/getChars/
		 * reverse/append/insert/delete
		 */
		StringBuilder s = new StringBuilder();
		System.out.println("Capacity: "+ s.capacity());
		s.insert(0, "Hello, Nice to meet you!");
		System.out.println("Insert 0: "+ s);
		System.out.println("Length: "+ s.length());
		s.setCharAt(4, 'a');
		System.out.println("setCharAt 4: "+ s);
		System.out.println("Char at 4: "+ s.charAt(4));
		s.append("Good Bye!");
		System.out.println("Append: "+ s);
		s.reverse();
		System.out.println("Reverse: "+ s);
		s.setLength(5);
		System.out.println("String: "+ s);
		System.out.println("Length: "+ s.length());
	}
}
