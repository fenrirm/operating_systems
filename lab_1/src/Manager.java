import java.util.ArrayList;
import java.util.Optional;

public class Manager extends Thread {
    private ArrayList<Double> results = new ArrayList<>();

    public void start(int input, Result result) {
        Function f = new Function("f", input);
        Function g = new Function("g", input);
        f.start();
        g.start();
        defineResult(f, g, result);
    }

    public void defineResult(Function f, Function g, Result result) {
        while (true) {
            /*if ((f.isCalculated && !f.isUsed)){
                System.out.println("if 1");
                //double r = f.result.get();
               if (Double.isNaN(f.result.get())) {
                    result.accept(Optional.empty(), "f failed");
                    stopFunctions(f, g);
                    return;
               }

                results.add(f.result.get());
                f.isUsed=true;
            }

            if (g.isCalculated && !g.isUsed) {
                System.out.println("if 2");
                //double r = g.result.get();
                if (Double.isNaN(g.result.get())) {
                    result.accept(Optional.empty(), "g failed");
                    stopFunctions(f, g);
                    return;
                }
                results.add(g.result.get());
                g.isUsed=true;
            }*/
            if (f.isCalculatedEnd && g.isCalculatedEnd) {
                System.out.println("in if");
                if ((f.isCalculated && !f.isUsed) && (g.isCalculated && !g.isUsed)) {
                    System.out.println("in if1");
                    System.out.println("f - " + f.isCalculatedEnd);
                    System.out.println("g - " + g.isCalculatedEnd);
                    //double r = f.result.get();
                  /*  if (Double.isNaN(f.result.get())) {
                        result.accept(Optional.empty(), "f failed");
                        stopFunctions(f, g);
                        return;
                    }
                    if (Double.isNaN(g.result.get())) {
                        result.accept(Optional.empty(), "g failed");
                        stopFunctions(f, g);
                        return;
                    }*/
                    results.add(f.result.get());
                    f.isUsed = true;
                    results.add(g.result.get());
                    g.isUsed = true;

                } else if ((!f.isCalculated && !f.isUsed) && (g.isCalculated && !g.isUsed)) {
                    result.accept(Optional.empty(), "F soft failed");
                    result.show();
                    break;
                } else if ((!g.isCalculated && !g.isUsed) && (f.isCalculated && !f.isUsed)) {
                    result.accept(Optional.empty(), "G soft failed");
                    result.show();
                    break;
                } else if ((!f.isCalculated && !f.isUsed) && (!g.isCalculated && !g.isUsed)) {
                    result.accept(Optional.empty(), " F and G soft failed");
                    result.show();
                    break;
                }
                if (g.isUsed && f.isUsed) {
                    calculateResult(result);
                    result.show();
                    break;
                }

            } else if (!f.isCalculated && f.isCalculatedEnd) {
                result.accept(Optional.empty(), "F hard failed");
                result.show();
                break;
            } else if (g.isCalculatedEnd && !g.isCalculated) {
                result.accept(Optional.empty(), "G hard failed");
                result.show();
                break;
            }

        }
    }


    public void calculateResult(Result result) {
        double endResult = 0;
        for (Double aDouble : results) {
            endResult = endResult + aDouble;
        }
        result.accept(Optional.of(endResult), "Success");

    }

    public void stopFunctions(Function f, Function g) {
        f.interrupt();
        g.interrupt();
    }

    public void stopF(Function f) {
        f.interrupt();
    }

    public void stopG(Function g) {
        g.interrupt();
    }


}


