package JavaPractice;

public class PolymorphismContractor extends PolymorphismEmployee{

    @Override
    int salary() {
        return base + 10000;
    }


    static String designation(){

        return "Contractor";
    }
}
