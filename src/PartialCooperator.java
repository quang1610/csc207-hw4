// SubClass of Organism with cooperation probability = 0.5
public class PartialCooperator extends Organism {
  // Constructor
  public PartialCooperator() {
    super();
    this.coopProb = 0.5;
    this.energy = 0;
    this.type = "PartialCooperator";
  }

  // Methods
  @Override
  /*
   * reproduce: handle reproduce of organism. Returning an offspring organism.
   * 
   * @param: none
   * 
   * @returns: Organism, it has Organism.mutationProb chance of mutation, aka reproduce offspring of
   * different Organism species. Normally the offspring would be a PartialCooperator.
   */
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
  /*
   * getCooperationProbability: return this.coopProb, the cooperation probability of this organism.
   * 
   * @param: none
   * 
   * @returns: double, this.coopProb (0.5).
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
   * @returns: boolean, 50% of the time it is true, %50 of the time it is false.
   */
  public boolean cooperates() {
    return Population.r.nextDouble() < this.coopProb;
  }

}
