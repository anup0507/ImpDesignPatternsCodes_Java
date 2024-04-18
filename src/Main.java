import com.example.anup.designpatterns.Builder.Student;
import com.example.anup.designpatterns.Singleton.printSpololer;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Hello, World!");
        printSpololer printSpololer1 = printSpololer.getInstance();
        printSpololer1.addToQueue("First message");
        printSpololer1.addToQueue("Second message");
        System.out.println(printSpololer1.processnextJob());
        System.out.println(printSpololer1.processnextJob());
        System.out.println(printSpololer1.processnextJob());
        */

        Student student = Student.CreateBuilder()
                .setAge(20)
                .setFName("Anup")
                .setLName("Kumar")
                .setGender("Male")
                .setPsp(90)
                .setWeight(70)
                .build();






    }
}