package src;
public abstract class Organism implements Comparable<Organism>{

  static double mutationProb = .05;
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
  
  public int compareTo(Organism other)
  {
    return this.getEnergy()-other.getEnergy();
  }

}
