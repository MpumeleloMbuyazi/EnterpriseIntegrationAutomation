package JavaPractice;

import static java.lang.System.out;

public class InheritanceSubClass extends InheritanceSuperClass{

    String CommonStr = "Sub Common String";


    public InheritanceSubClass(String constructor){
        super(constructor);
        out.println("SubClass Constructor");
    }

    public void subClassMethod(){

        out.println("SubClass Method");
    }

    public void printCommonString(){

        out.println(CommonStr);
        out.println(super.CommonStr);
    }
}
