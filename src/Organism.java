
public abstract class Organism {

  // Fields
  double coopProb;
  int energy;
  String type;

  // Constructor
  public Organism() {}

  // Methods
  public void update() {
    this.incrementEnergy();
  }

  public int getEnergy() {
    return this.energy;
  }

  public void incrementEnergy() {
    this.energy++;
  }

  public void decrementEnergy() {
    this.energy--;
  }

  public String getType() {
    return this.type;
  }

  public abstract Organism reproduce();

  public abstract double getCooperationProbability();

  public abstract boolean cooperates();

}
