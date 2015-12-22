package bob.test.learnjava;
import java.lang.*;

public class ElementaryDataTypeTest {
	/*
	 * 基本数据类型转换的例子
	 */
    public static char[] stringToChar(String s){
    	return s.toCharArray();
    }
    
    public static String charToString(char[] c){
    	return c.toString();
    }
    public static String intToString(int i){
    	//return String.valueOf(i);
    	//return i + ''
    	return Integer.toString(i);
    }
    public static int stringToInt(String s){
    	//return Integer.parseInt(s);
    	//同样可用于Double/Float/Long
    	return Integer.valueOf(s);
    }
    public static boolean intToBoolean(int i){
    	//Boolean 的valueOf只支持string和int，所以需要先转换为string
    	//return Boolean.valueOf("" + i);
    	return Boolean.valueOf(String.valueOf(i));
    }
    public static String booleanToString(boolean b){
    	return String.valueOf(b);
    }
}
