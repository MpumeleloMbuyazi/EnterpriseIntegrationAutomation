package JavaPractice;

import static java.lang.System.in;
import static java.lang.System.out;

public class Structures {

    enum alph{

        A,
        B
    }

    public static void main(String[] args) {
        Structures struc = new Structures();
        struc.switchCheck();
    }

    public void ifElse(){

        boolean flag = false;

        if (flag){
            out.println("true");
        }else {
            out.println("false");
        }
    }

    public void forLoop(){

        for (int i = 0; i<5; i++){
            out.println(i);
            if (i == 2){
                break;
            }
        }
    }

    public void forEachLoop(){
        String[] myArray = {"a","b","c"};

        for (String str : myArray){
            out.println(str);
            if (str.equalsIgnoreCase("b")){
                break;
            }
        }

    }

    public void whileLoop(){

        int i = 100;
        while (i > 0){
            out.println(i);
            i--;
            if (i == 50){
                break;
            }
        }

    }

    public void switchCheck(){

        String str = "z";

        alph nowalph = alph.B;

        switch (nowalph){
            case A:
                out.println("test");
                break;
            case B:
                out.println("testing");
                break;
            default:
                out.println("tester");
        }


    }

}
