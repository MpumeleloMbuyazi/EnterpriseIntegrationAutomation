package JavaPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static java.lang.System.out;

public class ExceptionHandling {

//    static int myArray[] = {1, 2, 3};

//    public static void main(String[] args) {
//        out.println(myArray[2]);
//    }

    public static void main(String[] args) {
        File f = new File("c://eded.txt");
        try {
            FileReader fr = new FileReader(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
