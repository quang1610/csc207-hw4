package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Population {
  static Random r = new Random();
  // Fields
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
        for (int j = 0; j < counts[i].getRight(); j++) {
          list.add(new Cooperator());
        }
      } else if (counts[i].getLeft().equals("Defector")) {
        for (int j = 0; j < counts[i].getRight(); j++) {
          list.add(new Defector());
        }
      } else if (counts[i].getLeft().equals("PartialCooperator")) {
        for (int j = 0; j < counts[i].getRight(); j++) {
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

      if (this.orgList.get(i).cooperates()) {

        this.orgList.get(i).decrementEnergy();

        // Give away energy to 8 other Organism
        int[] toBeIncremented = randomNoRepeats(8, this.orgList.size(), i);
        for (int j = 0; j < 8; j++) {
          // increase the energy of the selected Organism
          this.orgList.get(toBeIncremented[j]).incrementEnergy();
        }
      }
    }
    //Reproduction by replacing least energy
    // Sort this list to make the organisms with more energy in the end.

    Collections.sort(this.orgList);

    int top = this.orgList.size() - 1;

    int bottom = 0;
    while (this.orgList.get(top).getEnergy() >= 10) {
      this.orgList.set(bottom, this.orgList.get(top).reproduce());
      top--;
      bottom++;
    }

    //Random reproduction
    /*
    for (int i = 0; i < this.orgList.size(); i++) {
      if (this.orgList.get(i).getEnergy() >= 10) {
        int myInt = r.nextInt(this.orgList.size());
        System.out.println(myInt);
        this.orgList.set(myInt, this.orgList.get(i).reproduce());
      }
    }
    */

  }


  public double calculateCooperateMean() {
    double mean = 0;

    for (int i = 0; i < this.orgList.size(); i++) {
      mean += this.orgList.get(i).getCooperationProbability();
    }

    return mean / this.orgList.size();
  }

  public Pair<String, Integer>[] getPopulationCounts() {
    int cooperators = 0;
    int defectors = 0;
    int partials = 0;
    Organism current;
    for (int i = 0; i < this.orgList.size(); i++) {
      current = this.orgList.get(i);
      if (current instanceof Cooperator) {
        cooperators++;
      } else if (current instanceof Defector) {
        defectors++;
      } else if (current instanceof PartialCooperator) {
        partials++;
      }

    }
    this.counts =
        (Pair<String, Integer>[]) (new Pair[] {new Pair<String, Integer>("Cooperator", cooperators),
            new Pair<String, Integer>("Defector", defectors),
            new Pair<String, Integer>("PartialCooperator", partials)});
    return this.counts;
  }

  public String toString() {
    Pair<String, Integer>[] vals = this.getPopulationCounts();
    return "Cooperators \t= " + vals[0].getRight() + "\nDefectors \t= " + vals[1].getRight()
        + "\nPartial \t= " + vals[2].getRight();
  }

  // Needs to be improved
  private int[] randomNoRepeats(int number, int upperBound, int exclude) {
    int[] vals = new int[number];
    int count = 0;
    int temp;
    boolean found = false;
    // System.out.println(upperBound);
    while (count < number) {
      temp = r.nextInt(upperBound);
      // System.out.println(temp + " and " + count);
      if (temp == exclude) {
        found = true;
        continue;
      }
      found = false;
      for (int i = 0; i < count; i++) {
        if (vals[i] == temp) {
          found = true;
          break;
        }
      }
      if (found) {
        continue;
      } else {
        vals[count] = temp;
        count++;
      }
    }
    return vals;
  }

}
