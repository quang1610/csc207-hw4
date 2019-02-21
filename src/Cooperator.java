// SubClass of Organism with cooperation probability = 1
public class Cooperator extends Organism {
  // Constructor
  public Cooperator() {
    super();
    this.coopProb = 1.0;
    this.energy = 0;
    this.type = "Cooperator";
  }

  // Methods
  @Override
  /*
   * reproduce: handle reproduce of organism. Returning an offspring organism.
   * 
   * @param: none
   * 
   * @returns: Organism, it has Organism.mutationProb chance of mutation, aka reproduce offspring of
   * different Organism species. Normally the offspring would be a Cooperator.
   */
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
  /*
   * getCooperationProbability: return this.coopProb, the cooperation probability of this organism.
   * 
   * @param: none
   * 
   * @returns: double, this.coopProb (1.0).
   */
  public double getCooperationProbability() {
    return this.coopProb;
  }

  @Override
  /*
   * cooperates: return if true if this organism cooperates, false if it does not cooperate.
   * 
   * @param: none
   * 
   * @returns: boolean, true.
   */
  public boolean cooperates() {
    return true;
  }
}
