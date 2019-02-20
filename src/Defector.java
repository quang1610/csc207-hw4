package src;

public class Defector extends Organism {
  public Defector() {
    super();
    this.coopProb = 0;
    this.energy = 0;
    this.type = "Defector";
  }

  @Override
  public Organism reproduce() {
    this.energy = 0;
    if (Population.r.nextDouble() < Organism.mutationProb) {
      if (Population.r.nextDouble() < .5) {
        return new Cooperator();
      } else {
        return new PartialCooperator();
      }
    }
    return new Defector();
  }

  @Override
  public double getCooperationProbability() {
    return this.coopProb;
  }

  @Override
  public boolean cooperates() {
    return false;
  }
}
