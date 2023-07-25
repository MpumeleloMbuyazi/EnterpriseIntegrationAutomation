package JavaPractice;

import java.util.Locale;

import static java.lang.System.out;
import static javafx.scene.input.KeyCode.M;

public class MyClass {

    int a = 3;
    String s = "Hello World";

    //Constructor
    public MyClass(){
    }

    public static void main(String[] args) {
        MyClass myClasss = new MyClass();


        myClasss.stringCheck();
        out.println(myClasss.initialize());
        out.println(myClasss.s);

    }

    public void stringCheck(){

//        s = s.concat("!!");
//        out.println(s);
//        s = s.toUpperCase();

        s = s.substring(6);
        out.println(s);

    }



    public int initialize(){

        a=8;
        return a;
    }
}
