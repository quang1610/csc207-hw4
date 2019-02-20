package src;

public class Cooperator extends Organism {
  
  public Cooperator() {
    super();
    this.coopProb = 1.0;
    this.energy = 0;
    this.type = "Cooperator";
  }
  
  @Override
  public Organism reproduce() {
      this.energy = 0;
      if (Population.r.nextDouble() < Organism.mutationProb) {
        if (Population.r.nextDouble() < .5) {
          return new Defector();
        } else {
          return new PartialCooperator();
        }
      }
      return new Cooperator();
    }
  
  @Override
  public double getCooperationProbability() {
    return this.coopProb;
  }
  
  @Override
  public boolean cooperates() {
    return true;
  }
}
