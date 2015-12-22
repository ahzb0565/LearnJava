package basic.javaModules;

public class TestException {
    public static void f() throws MyException{
        System.out.println("Throws MyException from f()");
        throw new MyException("Exception throws from f()");
    }
    public static void main(String[] args){
        try{
            f();
        }catch(MyException e){
            e.printStackTrace(); 
        }finally{
            System.out.println("Finally!");
        }
    }
}

class MyException extends Exception{
    public MyException(){}
    public MyException(String s){
        super(s);
        System.out.println("MyException init by MyException(msg)");
    }
}