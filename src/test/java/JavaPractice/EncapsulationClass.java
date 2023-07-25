package JavaPractice;

import static java.lang.System.out;

public class EncapsulationClass {

    public static void main(String[] args) {
       EncapsulationPrivate encapsulationPrivate = new EncapsulationPrivate();

       encapsulationPrivate.setStr("String has been updated");
       encapsulationPrivate.printString();

       //out.println(encapsulationPrivate.getStr());
    }
}
