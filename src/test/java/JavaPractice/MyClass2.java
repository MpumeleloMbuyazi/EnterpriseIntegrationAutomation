package JavaPractice;

public class MyClass2 {




    public static void main(String[] args) {

        MyClass2 myClass2 = new MyClass2();
        myClass2.method();

    }


    public void method(){

        MyClass myClass = new MyClass();
        myClass.initialize();
        System.out.println(myClass.a);
    }
}
