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
    return new PartialCooperator();
  }

  @Override
  public double getCooperationProbability() {
    return this.coopProb;
  }

  @Override
  public boolean cooperates() {
    return Math.random() < this.coopProb;
  }

}
