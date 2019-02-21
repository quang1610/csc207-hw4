package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Class to store a group of organisms and run simulations
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

	// createOrganismList
	// @param: counts, a list of the types to create and how many of each
	// @note: Returns an ArrayList of organisms containing a specified number of
	// each type of organism
	private ArrayList<Organism> createOrganismList(Pair<String, Integer>[] counts) throws IllegalArgumentException {
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

	// Update: runs energy updates and reproduction for the entire population
	// @param: none
	// @returns: none
	// @note: iterates the energy of each organism, and calls the reproduction
	// method on those with
	// sufficient energy, replacing the organism with the least energy with an
	// offspring
	public void update() {
		for (int i = 0; i < this.orgList.size(); i++) {

			// Iterate energy for all organisms
			this.orgList.get(i).update();

			// Distribute energy from cooperators to random other organisms
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

		// Reproduction by replacing least energy
		// Sort this list to make the organisms with more energy in the end.

		Collections.sort(this.orgList);

		int top = this.orgList.size() - 1;

		int bottom = 0;
		while (this.orgList.get(top).getEnergy() >= 10) {
			this.orgList.set(bottom, this.orgList.get(top).reproduce());
			top--;
			bottom++;
		}

		// Random reproduction (original version before adding bonus point)
		/*
		 * for (int i = 0; i < this.orgList.size(); i++) { if
		 * (this.orgList.get(i).getEnergy() >= 10) { int myInt =
		 * r.nextInt(this.orgList.size()); System.out.println(myInt);
		 * this.orgList.set(myInt, this.orgList.get(i).reproduce()); } }
		 */

	}

	// calculateCooperateMean: calculates the mean cooperation probability of all
	// organisms in the population
	// @param: none
	// @returns: double, the mean cooperation probability
	public double calculateCooperateMean() {
		double mean = 0;

		for (int i = 0; i < this.orgList.size(); i++) {
			mean += this.orgList.get(i).getCooperationProbability();
		}

		return mean / this.orgList.size();
	}

	// getPopulationCounts: returns a list of pairs indicating the number of each
	// type of organism
	// @param: none
	// @returns: an array of pairs containing the type and number of each organism
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
		this.counts = (Pair<String, Integer>[]) (new Pair[] { new Pair<String, Integer>("Cooperator", cooperators),
				new Pair<String, Integer>("Defector", defectors),
				new Pair<String, Integer>("PartialCooperator", partials) });
		return this.counts;
	}

	// toString: returns a string contianing the total number of each type of
	// organism
	public String toString() {
		Pair<String, Integer>[] vals = this.getPopulationCounts();
		return "Cooperators \t= " + vals[0].getRight() + "\nDefectors \t= " + vals[1].getRight() + "\nPartial \t= "
				+ vals[2].getRight();
	}

	// randomNoRepeats: returns an array of random values with no values repeated
	// @param: number: the number of elements to return in the array
	// upperBound: the upper bound for random numbers in the returned array
	// exclude: a value not to be included in the returned array
	// @returns: an int[] containing a non-repeating set of random integers, and not
	// containing exclude
	private int[] randomNoRepeats(int number, int upperBound, int exclude) throws Exception {
		//Check to make sure that the input parameters specify a possible array
		if (upperBound - number < 0) {
			throw new Exception(
					"It is impossible to generate a non-repeating random array with the given paramenters.");
		}
		int[] vals = new int[number];
		int count = 0;
		int temp;
		boolean found = false;
		while (count < number) {
			temp = r.nextInt(upperBound);
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
