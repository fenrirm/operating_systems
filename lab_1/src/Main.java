
import java.util.Scanner;

public class Main {
    public static void main(String [] args)  {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Cancellation cancellation = new Cancellation();
        //cancellation.start();
        Manager manager = new Manager();
        Result result = new Result();
        manager.start(input, result);
       /* Function g = new Function("g", 2);
        Function f = new Function("f", 2);*/
        //g.start();
        //f.start();


    }
}
