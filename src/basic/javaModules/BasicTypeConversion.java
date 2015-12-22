package basic.javaModules;

/*
 * Java 基本数据类型包括boolean/String/int/char/byte/long/float/double/short 等
 * 常用的数据类型妆欢是char/byte/string/int 等的转换
 * 强制类型转换一般在很有把握情况下用，比如String s = "123"; (int)s， 这里就不用实验了
 * array 和基本类型的转换一般是String和array的
 */

abstract class TypeConversion{
    abstract byte[] charToByte(char c);
    abstract byte[] stringToByte(String s);
    abstract byte[] intToByte(int i);
    
    abstract char byteToChar(byte[] b);
    abstract char[] stringToChar(String s);
    abstract char intTochar(int i);
    
    abstract String byteToString(byte[] b);
    abstract String charToString(char c);
    abstract String intToString(int i);
    
    abstract int byteToInt(byte b);
    abstract int StringToInt(String s);
    abstract int charToInt(char c);
}

public class BasicTypeConversion extends TypeConversion {
    public static void main(String[] args){
        BasicTypeConversion b = new BasicTypeConversion();
        int i = 97;
        System.out.println(Character.toChars(i));
    }

    @Override
    public byte[] charToByte(char c) {
        /* 
         * 第一种
         * char  = 16 bits, byte = 8 bits， 因此可以用位运算, 也是最快的
         * byte[] b = [2]
         * b[0] = (byte) (c & 0xff);
         * b[1] = (byte) ((c >> 8)& 0xff);
         * 
         * 第二种
         * 利用String.getBytes()来转换
         * String s = String.valueOf(c);
         * return s.getBytes();
         */
        String s = String.valueOf(c);
        return s.getBytes();
    }

    @Override
    public byte[] stringToByte(String s) {
        // 果断用getBytes
        return s.getBytes();
    }

    @Override
    public byte[] intToByte(int i) {
        /*
         * 第一种
         * int = 4 byte, 可以用位运算
         * byte[] b = new byte[4]
         * b[0] = (byte) (i & 0xff);// 最低位 
         * b[1] = (byte) ((i >> 8) & 0xff);// 次低位 
         * b[2] = (byte) ((i >> 16) & 0xff);// 次高位 
         * b[3] = (byte) (i >>> 24);// 最高位,无符号右移。
         * return b;
         * 
         * 第二种
         * 还是用利用string
         */
        String s = Integer.toString(i);
        return s.getBytes();
    }

    @Override
    public char byteToChar(byte[] b) {
        /*
         * 第一种
         * char = 2~4 byte， 可用位运算， 如
         * char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
         * 第二种
         * 用string
         */
        return 0;
    }

    @Override
    public char[] stringToChar(String s) {
        //果断用String 的toCharArray
        return s.toCharArray();
    }

    @Override
    char intTochar(int i) {
        /*
         * 由于ASCII 码也是int的，所以char c = 97 也是可以的，表示‘a’
         * 所以这里的转换不包括这种形式，只是把int转换成char
         * 第一种
         * int 为16bits，比char小，可以强制转换
         * return (char)(i+48)//因为0 的值是48, 而且 0<=i<=9
         * 第二种
         * 用String
         */
        String.valueOf(i).toCharArray();
        return 0;
    }

    @Override
    String byteToString(byte[] b) {
        // TODO Auto-generated method stub
        return String.valueOf(b);
    }

    @Override
    String charToString(char c) {
        return String.valueOf(c);
    }

    @Override
    String intToString(int i) {
        //return String.valueOf(i);
        //return i + ''
        return Integer.toString(i);
    }

    @Override
    int byteToInt(byte b) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    int StringToInt(String s) {
        // TODO Auto-generated method stub
        return Integer.parseInt(s);
    }

    @Override
    int charToInt(char c) {
        // TODO Auto-generated method stub
        return 0;
    }

}
