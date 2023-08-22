package model;
import java.util.HashSet;
import java.util.Set;

public class PowerSetGeneratorModel {
    public Set<Set<Integer>> generatePowerSet(Set<Integer> inputSet) {
        Set<Set<Integer>> powerSet = new HashSet<>();
        generatePowerSetHelper(inputSet, new HashSet<>(), powerSet);
        return powerSet;
    }

    private void generatePowerSetHelper(
            Set<Integer> inputSet, Set<Integer> currentSubset, Set<Set<Integer>> powerSet) {
        powerSet.add(new HashSet<>(currentSubset));

        for (int num : inputSet) {
            if (!currentSubset.contains(num)) {
                currentSubset.add(num);
                generatePowerSetHelper(inputSet, currentSubset, powerSet);
                currentSubset.remove(num);
            }
        }
    }
}