package JavaPractice;

import static java.lang.System.out;

public class InheritanceSuperClass {

    String str = "SuperClass String";
    String CommonStr = "Super Common String";

    public InheritanceSuperClass(String constructor){

        out.println("SuperClass Constructor");
        out.println(constructor);
    }

    public void superClassMethod(){

        out.println("SuperClass Method");
    }

}
