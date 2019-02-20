package src;

public class PartialCooperator extends Organism {
  
  public PartialCooperator() {
    super();
    this.coopProb = 0.5;
    this.energy = 0;
    this.type = "PartialCooperator";
  }
  
  @Override
  public Organism reproduce() {
    this.energy = 0;
    if (Population.r.nextDouble() < Organism.mutationProb) {
      if (Population.r.nextDouble() < .5) {
        return new Cooperator();
      } else {
        return new Defector();
      }
    }
    return new PartialCooperator();
  }
  @Override
  public double getCooperationProbability() {
    return this.coopProb;
  }

  @Override
  public boolean cooperates() {
    return Population.r.nextDouble() < this.coopProb;
  }

}
