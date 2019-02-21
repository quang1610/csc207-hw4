# csc207-hw4
Assignment 4 Artificial Life
William Henderson
Ben Mikek
Quang Nguyen



citation:
https://www.geeksforgeeks.org/collections-sort-java-examples/
https://docs.oracle.com/javase/8/docs/api/java/util/Random.html



Prediction / Summary of Results: Due to the small number of cooperators, defectors will win out and occupy all spaces. The results support this prediction, as the cooperator only survived to affect the cooperation probability in one of ten trials. The small number of original cooperators is likely a large factor in this outcome, as a single random reproduction may result in the removal of cooperators from the population pool entirely.

Total iterations: 100
Initial Values:
Cooperators: 1    Defectors: 9    Partial Cooperators: 0
--------------------------------
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.1
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
--------------------------------
Average cooperation probability over 10 runs: 0.01


Prediction / Summary of Results: Similarly to the last experiment, the single cooperator will have trouble making a substantial dent in the number of defectors. The results only somewhat support this prediction. Despite the small number of cooperators, most  of the overall average cooperation probability was higher in this experiment. We would attribute this to the lower chance of the single cooperator being eliminated during reproduction, as a random choice has a significantly reduced 1% chance of replacing the original cooperator.

Total iterations: 100
Initial Values:
Cooperators: 1    Defectors: 99    Partial Cooperators: 0
--------------------------------
Mean Cooperation Probability = 0.01
Mean Cooperation Probability = 0.025
Mean Cooperation Probability = 0.01
Mean Cooperation Probability = 0.005
Mean Cooperation Probability = 0.04
Mean Cooperation Probability = 0.025
Mean Cooperation Probability = 0.01
Mean Cooperation Probability = 0.035
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
--------------------------------
Average cooperation probability over 10 runs: 0.015999999999999997



Prediction / Summary of Results: Now that there are a majority cooperators, defectors should not be nearly as successful. The results did not bear out this prediction. In contrast, the cooperation probability remained only slightly higher than test 1, where there were 9 defectors. It would appear defectors are heavily selected for in this reality.

Total iterations: 100
Initial Values:
Cooperators: 9    Defectors: 1    Partial Cooperators: 0
--------------------------------
Mean Cooperation Probability = 0.05
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.1
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
--------------------------------
Average cooperation probability over 10 runs: 0.015000000000000003



Prediction / Summary of Results: In light of the results of the previous experiment, we predict that the cooperation probability will remain low despite the majority held by the cooperators. This prediction was confirmed by the results which again show that cooperators are not selected for in this environment. With such a substantial majority the loss of the cooperators to the defectors is substantial.

Total iterations: 100
Initial Values:
Cooperators: 99    Defectors: 1    Partial Cooperators: 0
--------------------------------
Mean Cooperation Probability = 0.045
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.015
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.005
Mean Cooperation Probability = 0.015
Mean Cooperation Probability = 0.05
Mean Cooperation Probability = 0.01
Mean Cooperation Probability = 0.005
Mean Cooperation Probability = 0.03
--------------------------------
Average cooperation probability over 10 runs: 0.0175



Prediction / Summary of Results: Whenever defectors are present, the balance seems to have little to do with their success. As a result, we predict that this division into thirds will not result in substantially more cooperation. This prediction was confirmed by the results of this experiment, where the cooperation probability again remained around 0.01.

Total iterations: 100
Initial Values:
Cooperators: 3    Defectors: 3    Partial Cooperators: 4
--------------------------------
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.1
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
--------------------------------
Average cooperation probability over 10 runs: 0.01



Prediction / Summary of Results: As found above, the increasing of the number of organisms seems to benefit the defectors, so we predict that the cooperation probability will be even lower in this experiment than the last. As expected, the cooperation probability was under 0.01, again demonstrating the effectiveness of the defectors.

Total iterations: 100
Initial Values:
Cooperators: 33    Defectors: 33    Partial Cooperators: 34
--------------------------------
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.005
Mean Cooperation Probability = 0.02
Mean Cooperation Probability = 0.015
Mean Cooperation Probability = 0.005
Mean Cooperation Probability = 0.01
Mean Cooperation Probability = 0.0
Mean Cooperation Probability = 0.01
Mean Cooperation Probability = 0.02
--------------------------------
Average cooperation probability over 10 runs: 0.0085

Overall, in our implementation of this experiment, the cooperators were not successful. Regardless of the number of defectors, as long as there was at least one, nearly every organism would become a defector by the end of the program. This is likely the result of these particular circumstances. If cooperators only gave energy to cooperators, they may well be more successful. AS it stands, however, the random selection of those who receive the energy output by the cooperators creates such a disincentive to bother cooperating that it has minimal positive affect on their ability to survive. In fact, it has a negative affect, as they receive no special bonus in return for cooperating.

