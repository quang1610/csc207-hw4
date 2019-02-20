package src;

public class ALifeSim {

  public static void main(String[] args) {
    int iterations = Integer.parseInt(args[0]);
    double probSum = 0;
    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
    pen.println("Total iterations: " + args[0]);
    pen.println("Initial Values:");
    pen.println("Cooperators: " + args[1] + "\tDefectors: "+args[2]+"\tPartial Cooperators: "+args[3]);
    pen.println("--------------------------------");
    for (int tests = 0; tests < 10; tests++) {
      Pair<String, Integer> coops =
          new Pair<String, Integer>("Cooperator", Integer.parseInt(args[1]));
      Pair<String, Integer> defect =
          new Pair<String, Integer>("Defector", Integer.parseInt(args[2]));
      Pair<String, Integer> partials =
          new Pair<String, Integer>("PartialCooperator", Integer.parseInt(args[3]));
      Pair<String, Integer>[] pairs =
          (Pair<String, Integer>[]) (new Pair[] {coops, defect, partials});

      Population p = new Population(pairs);

      for (int i = 0; i < iterations; i++) {
        p.update();
      }

      /*
      pen.println("After " + iterations + " ticks:");
      pen.println(p.toString());
      pen.println();*/
      pen.println("Mean Cooperation Probability = " + p.calculateCooperateMean());
      probSum+=p.calculateCooperateMean();
    }
    pen.println("--------------------------------");
    pen.println("Average cooperation probability over 10 runs: "+probSum/10.0);
  }
}
