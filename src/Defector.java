
public class Defector extends Organism {
  public Defector() {
    super();
    this.coopProb = 0;
    this.energy = 0;
    this.type = "Defector";
  }
  
  @Override
  public Defector reproduce() {
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
