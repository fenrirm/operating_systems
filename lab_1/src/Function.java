import os.lab1.compfuncs.basic.DoubleOps;

import java.util.Objects;
import java.util.Optional;

public class Function extends Thread {
    private String functionName;
    private int input;
    public Optional<Double> result;
    public volatile boolean isCalculated;
    public volatile boolean isCalculatedEnd;
    public volatile boolean isUsed;

    Function(String name, int input) {
        this.functionName = name;
        this.input = input;
        isCalculated = false;
        isUsed = false;
        isCalculatedEnd = false;
        System.out.println("constructor");
    }

    @Override
    public void run() {
        try {
            if (Objects.equals(functionName, "f")) {
                System.out.println("in f");
                result = DoubleOps.trialF(input);
                if (result.isPresent()) {
                    isCalculated = true;
                    System.out.println("f isCalculated is true");
                }
                isCalculatedEnd = true;
                System.out.println("f is known");
                //System.out.println(result);
            }
            if (Objects.equals(functionName, "g")) {
                System.out.println("in g");
                result = DoubleOps.trialG(input);
                if (result.isPresent()) {
                    isCalculated = true;
                    System.out.println("g isCalculated is true");
                }
                isCalculatedEnd = true;
                System.out.println("g is known");
                System.out.println("g - " + isCalculatedEnd);
                //System.out.println(result);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
