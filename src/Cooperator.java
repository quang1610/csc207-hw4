package src;

public class Cooperator extends Organism {
  
  public Cooperator() {
    super();
    this.coopProb = 1.0;
    this.energy = 0;
    this.type = "Cooperator";
  }
  
  @Override
  public Cooperator reproduce() {
    Cooperator offSpring = new Cooperator();
    this.energy = 0;
    return offSpring;
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
