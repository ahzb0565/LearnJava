package basic.javaModules;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Enumeration;

public class SystemTest {
    /*
     * java.lang.System
     * 常用于获取系统静态属性和输入输出
     * 这里是常用举例: property 操作/当前时间/System.out 重定向
     */
    public static void main(String[] args){
        SystemTest st = new SystemTest();
        st.testCurrentTime();
    }
    public void testSystemProperties(){
        /*
         * 关于SystemProperties, Java 有
         * setProperty(String key, String value)
         * setProperties(Properties props)
         * getProperty(String key)
         * getProperties()
         * 这里用例子找下有那些默认property
         */
        Properties props = System.getProperties();
        Enumeration prop_names = props.propertyNames();
        while(prop_names.hasMoreElements()){
            String prop_name = (String) prop_names.nextElement();
            String property = System.getProperty(prop_name);
            System.out.println(prop_name + "--" + property);
        }
        System.setProperty("Bob", "A good man!");
        System.out.println(System.getProperty("Bob"));
        System.clearProperty("Bob");
    }
    public void testStdout(){
        /*
         * System.out/err 是 standard output stream : PrintStream
         * System.in 是 standard input stream: InputStream
         * 而且他们都可以重定向，比如重定向到文件
         * 下面的例子就是重定向System.out的
         */
        try {
            PrintStream os = new PrintStream(new FileOutputStream("/tmp/output.txt"));
            System.setOut(os);
            System.out.println("This msg will be stored in /tmp/output.txt");
            BufferedReader fr = new BufferedReader(new FileReader("/tmp/output.txt"));
            System.out.println(fr.readLine());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void testCurrentTime(){
        /*
         * System.currentTimeMillis 来获取当前系统时间戳
         */
        long l = System.currentTimeMillis();
        System.out.println("Current time System: "+ l);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm：ss SSS");
        System.out.println("Format: " + df.format(new Date(l)));
    }
}
