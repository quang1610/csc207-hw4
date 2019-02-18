import java.util.ArrayList;

public class Population {

  Pair<String, Integer>[] counts;
  ArrayList<Organism> orgList;

  // Constructor
  public Population(Pair<String, Integer>[] counts) throws IllegalArgumentException {
    this.counts = counts;
    this.orgList = createOrganismList(counts);
  }

  private ArrayList<Organism> createOrganismList(Pair<String, Integer>[] counts)
      throws IllegalArgumentException {
    ArrayList<Organism> list = new ArrayList<Organism>();

    for (int i = 0; i < counts.length; i++) {
      if (counts[i].getLeft().equals("Cooperator")) {
        for (int j = 0; j < counts[j].getRight(); j++) {
          list.add(new Cooperator());
        }
      } else if (counts[i].getLeft().equals("Defector")) {
        for (int j = 0; j < counts[j].getRight(); j++) {
          list.add(new Defector());
        }
      } else if (counts[i].getLeft().equals("PartialCooperator")) {
        for (int j = 0; j < counts[j].getRight(); j++) {
          list.add(new PartialCooperator());
        }
      } else {
        throw new IllegalArgumentException();
      }
    }
    return list;
  }
  
  public void update() {
    for (int i = 0; i < this.orgList.size(); i++) {
      this.orgList.get(i).update();
      if(this.orgList.get(i).cooperates()) {
        //give energy to 8 others.
      }
    }
    for(int i = 0; i < this.orgList.size(); i++) {
      if(this.orgList.get(i).getEnergy() >= 10) {
        //reproduce
        //reduce the energy
        //update countss
      }
    }
    
    
  }
  
  public double calculateCooperateMean() {
    double mean = 0;
    
    for (int i = 0; i < this.orgList.size(); i++) {
      mean += this.orgList.get(i).getCooperationProbability();
    }
    
    return mean/this.orgList.size();
  }
  
  public Pair<String, Integer>[] getPopulationCounts() {
    return this.counts;
  }
}
