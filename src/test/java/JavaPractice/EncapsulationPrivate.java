package JavaPractice;

import static java.lang.System.out;

public class EncapsulationPrivate {

    private static String str = "My String";

    private String getStr(){

        return str;
    }

    public void setStr(String str){

        this.str = str;
    }

    public void printString(){

        out.println(str);
    }

    private void myMethod(){

        out.println("My Method");
    }
}
