package JavaPractice;

import static java.lang.System.out;

public class PolymorphismFullTime extends PolymorphismEmployee{

    @Override
    int salary() {
        return base + 20000;
    }

    static String designation(){

        return "FullTime";
    }

}
