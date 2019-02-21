// The super class of all kind of organisms
public abstract class Organism implements Comparable<Organism> {

  // Static Fields
  // mutation probability
  static double mutationProb = .05;
  // Fields
  double coopProb;
  int energy;
  String type;

  // Constructor
  public Organism() {}

  // Methods
  /*
   * update: this method update this organism by giving it energy. We decide that once every
   * organism finishes their update, we then see if any organism want to reproduce. The organism
   * with higher energy would reproduce first.
   * 
   * @param: none
   * 
   * @returns: void
   */
  public void update() {
    this.incrementEnergy();
  }

  /*
   * getEnergy: return the current energy of this organism.
   * 
   * @param: none
   * 
   * @returns: int, this.energy - the current amount of energy.
   */
  public int getEnergy() {
    return this.energy;
  }

  /*
   * incrementEnergy: increase the current energy by 1.
   * 
   * @param: none
   * 
   * @returns: none
   */
  public void incrementEnergy() {
    this.energy++;
  }

  /*
   * incrementEnergy: decrease the current energy by 1.
   * 
   * @param: none
   * 
   * @returns: none
   */
  public void decrementEnergy() {
    this.energy--;
  }

  /*
   * getType: return the type of this organism as a string. It can be: "Cooperator", "Defector",
   * "PartialCooperator"
   * 
   * @param: none
   * 
   * @returns: String, this.type.
   */
  public String getType() {
    return this.type;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object) compare 2 organisms based on their energy
   * level
   * 
   * @param: Organism, other
   * 
   * @return: int, this.getEnergy() - other.getEnergy();
   */
  public int compareTo(Organism other) {
    return this.getEnergy() - other.getEnergy();
  }

  // To be implement in subClass

  /*
   * reproduce: handle reproduce of organism. Returning an offspring organism.
   * 
   * @param: none
   * 
   * @returns: to be implemented.
   */
  public abstract Organism reproduce();

  /*
   * getCooperationProbability: return this.coopProb, the cooperation probability of this organism.
   * 
   * @param: none
   * 
   * @returns: to be implemented.
   */
  public abstract double getCooperationProbability();

  /*
   * cooperates: return if true if this organism cooperates, false if it does not cooperate.
   * 
   * @param: none
   * 
   * @returns: to be implemented.
   */
  public abstract boolean cooperates();

}
