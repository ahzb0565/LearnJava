package basic.javaModules;
import java.io.*;
import java.util.logging.Logger;

/*
 * 关于Java IO， 作为初学者，看得整个人都有点不好了
 * 但是看了网上大神的总结，还是找到最适合自己记忆的方法
 * 参考http://blog.csdn.net/yuebinghaoyuan/article/details/7388059
 * 本人最适合的还是节点流和处理流分类。
 * 1. 节点流直接与文件沟通，构造方法可直接指向文件路径
 * 	a. 包括字节中的
 * 	FileInputStream/PipeInputStream/ByteArrayInputStream
 * 	FileOutputStream/PipeOutputStream/ByteArrayOutputStream
 * 	b. 字符中的
 * 	FileReader/FileWriter/PipeReader/PipeWriter
 * 	CharArrayReader/CharArrayWriter
 * 2. 处理流主要是跟节点流协作，更好的操作字符， 构造方法节点流对象
 *  a. 包括字节中的
 *  DataInputStream/DataOutputStream/BufferedInputStream/BufferedOutputStream
 *  ObjectInputStream/ObjectOutputStream
 *  b. 包括字符中的
 *  InputStreamReader/InputStreamWriter/BufferedReader/BufferedWriter
 *  PrintWriter
 */

public class IOTest {

	public static void main(String[] args) {
		//IOBytesStream bs = new IOBytesStream();
		//bs.testFileInputOutPutStream();
		IOCharStream cs = new IOCharStream();
		cs.testFileReaderWriter();
	}

}

class IOFile{
	//java.io.File
	/*
	 * Java IO 一切都是对File的操作，先单独认识File module
	 */
	String TAG = IOFile.class.getName();
	Logger logger = Logger.getLogger(TAG);
	public void testFields(){
		/*
		 * File 有4个static常量，字节流字符流各两个
		 * pathSeparator/pathSecparatorChar/separator/separatorChar
		 * 当然，打印出来的都差不多
		 */
		System.out.println("字符流：");
		System.out.println("pathSeparator：" + File.pathSeparator);
		System.out.println("separator：" + File.separator);
		System.out.println("字节流：");
		System.out.println("pathSeparatorChar：" + File.pathSeparatorChar);
		System.out.println("separatorChar：" + File.separatorChar);
	}
	public void testConstructors() throws IOException{
		/*
		 * File 有四个构造方法，常用的就是File(String)
		 */
		//File(String path)
		File f1 = new File("/tmp/test.txt");
		//File(String parent, String child)
		File f2 = new File("/tmp/", "test.txt");
		//File(File parent, String child)
		File f3 = new File(f1, "test2.txt");
		//File(URI uri)
		File f4 = new File(f1.toURI());
		f4.delete();
		f3.delete();
		f2.delete();
		f1.delete();
	}
	public void testSample1(){
		/*
		 * 实例1:
		 * 创建文件,删除文件
		 */
		String filePath = "/tmp/test.txt";
		try{
			File f = new File(filePath);
			logger.info("Create File instance");
			logger.info(String.format( "File %s exists: %s", filePath, f.exists()));
			logger.info("Create file");
			if (!f.exists()){
				f.createNewFile();
			}
			logger.info(String.format( "File %s exists: %s", filePath, f.exists()));
			logger.info("Deleate file");
			f.delete();
			logger.info(String.format( "File %s exists: %s", filePath, f.exists()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void testSample2(){
		/*
		 * 常用File 方法, 比如：
		 * canRead/canWrite
		 * crateNewFile/createTempFile/mkdir/mkdirs
		 * delete/exists
		 * getName/getParent/getParentFile/getPath
		 * isFile/isDirecotry/isHidden
		 * list/listFiles
		 * setReadable/setWriteable/setReadOnly/setExecuteable
		 * toString/toURI
		 */
	}
}

class IOBytesStream{
	//java.io.InputStream/OutputStream
	static final String TAG = IOBytesStream.class.getName();
	static final Logger logger = Logger.getLogger(TAG);
	static final String FILEPATH = "/tmp/test.txt";
	static final String TMPFILE = "/tmp/test1.txt";
	public void testFileInputOutPutStream(){
		/*
		 * FileInputStream/FileOutputStream 是InputStream/OutputStream 继承类
		 * 字节（bytes） + 节点(构造方法可直接指向文件路径)
		 * 自带缓冲区，需要手动关闭
		 * 实例： 创建文件，写入数据，再读取这个文件
		 */
		String s = "test string";
		try {
			FileOutputStream fo = new FileOutputStream(this.FILEPATH);
			fo.write(s.getBytes());
			fo.close();
			FileInputStream fi = new FileInputStream(this.FILEPATH);
			int c = 0;
			while((c = fi.read()) != -1){
				System.out.println((char)c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testObjectInputOutputStream(){
		/*
		 * ObjectInputStream/ObjectOutputStream是以object为输入输出的类
		 * object 必须是实现Serializable接口
		 * ObjectInputStream/ObjectOutputStream 是处理流， 只有一个构造方法，必须是Input/OutputStream
		 * 优点： 可以通过toString 来存储object 信息
		 * 缺点： 存object 信息一般只需要存储data 就好
		 */
		Student[] students = {new Student("Bob",1), new Student("Jim", 2)};
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream(this.TMPFILE));
			for(Student s:students){
				oos.writeObject(s);
			}
			ois = new ObjectInputStream(new FileInputStream(this.TMPFILE));
			for(int i = 0; i< students.length; i++){
				System.out.println(ois.readObject());
			}
		}catch (IOException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				oos.close();
				ois.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public void testDataInputOutputStream(){
		/*
		 * 用于储存和读取data
		 * 处理流，构造方法就一个，InputStream/OutputStream
		 * 优点： readUTF/readInt/writeUTF/writeInt 很方便，且read 的时候不用担心到-1
		 */
		 DataInputStream dis = null;
		 DataOutputStream dos = null;
		 try {
			dos = new DataOutputStream(new FileOutputStream(this.FILEPATH));
			dos.writeUTF("Bob");
			dos.writeInt(1);
			dos.flush();//保存
			dos.close();
			dis = new DataInputStream(new FileInputStream(this.FILEPATH));
			System.out.println(dis.readUTF());
			System.out.println(dis.readInt());
			dis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void testBufferedInputOutputStream(){}
}

class IOCharStream{
	//java.io.writer/reader
	static final String TAG = IOBytesStream.class.getName();
	static final Logger logger = Logger.getLogger(TAG);
	static final String FILEPATH = "/tmp/test.txt";
	static final String TMPFILE = "/tmp/test1.txt";
	public void testFileReaderWriter(){
		/*
		 * Reader/Writer 的子类
		 * 字符（char） + 节点（构造方法可指向文件）
		 */
		String s = "Test String!";
		try {
			FileWriter fw = new FileWriter(this.FILEPATH);
			fw.write(s);
			fw.close();
			FileReader fr = new FileReader(this.FILEPATH);
			int i;
			while((i = fr.read()) != -1){
				System.out.println((char)i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void testBufferedReaderWriter(){}
	public void testPrintReaderWriter(){}
	public void testInputOutputStreamReader(){
		/*
		 * 这个比较神奇，可用于bytes/char 流转换的
		 * 字符（char） + 处理（构造方法为只想inputStream/OutputStream 流）
		 */
	}
}

class Student implements Serializable{
	private String name;
	private int age;
	public Student(String name, int age) {  
	      super();  
	      this.name = name;  
	      this.age = age;  
	   } 
	public String toString(){
		return String.format("Student [name: %s, age %d]",this.name, this.age);
	}
}
