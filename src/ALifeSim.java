package src;

public class ALifeSim {

  public static void main(String[] args) {
    int iterations = Integer.parseInt(args[0]);
    Pair<String, Integer> coops =
        new Pair<String, Integer>("Cooperator", Integer.parseInt(args[1]));
    Pair<String, Integer> defect = new Pair<String, Integer>("Defector", Integer.parseInt(args[2]));
    Pair<String, Integer> partials =
        new Pair<String, Integer>("PartialCooperator", Integer.parseInt(args[3]));
    Pair<String, Integer>[] pairs =
        (Pair<String, Integer>[]) (new Pair[] {coops, defect, partials});
    
    Population p = new Population(pairs);
    
    for (int i = 0; i < iterations; i++) {
      p.update();
    }
    java.io.PrintWriter pen = new java.io.PrintWriter(System.out,true);
    pen.println("After "+iterations+" ticks:");
    pen.println(p.toString());
    pen.println();
    pen.println("Mean Cooperation Probability = "+p.calculateCooperateMean());
  }
}
