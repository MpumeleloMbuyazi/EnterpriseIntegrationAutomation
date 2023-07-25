package JavaPractice;

import static java.lang.System.out;

public class PolymorphismClass {

    public static void main(String[] args) {

        PolymorphismEmployee employee = new PolymorphismFullTime();
        out.println("FullTime Salary: " + employee.salary());

        employee = new PolymorphismContractor();
        out.println("Contractor Salary: " + employee.salary());

        //Calling static Methods by calling the class directly(Method Hiding)
        out.println(PolymorphismEmployee.designation());
        out.println(PolymorphismFullTime.designation());
        out.println(PolymorphismContractor.designation());

        PolymorphismOverloading  p = new PolymorphismOverloading();

        p.myMethod("testing",5);
        p.myMethod("test", 5);
    }
}
