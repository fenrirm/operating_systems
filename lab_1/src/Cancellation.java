import java.util.Scanner;

public class Cancellation extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Would you like to stop the program? If yes - press 1. If no - press 0");
                Scanner scanner = new Scanner(System.in);
                int answer = scanner.nextInt();
                if (answer == 1) {
                    System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
