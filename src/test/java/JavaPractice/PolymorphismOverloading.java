package JavaPractice;

import static java.lang.System.out;

public class PolymorphismOverloading {

    public void myMethod(String str){
        out.println(str);

    }

    public void myMethod(String str, int i){
        out.println(str + i);

    }


}
