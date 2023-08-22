package view;
import java.util.Set;

public class ConsolePowerSetGeneratorView implements PowerSetGeneratorView {
    @Override
    public void displayPowerSet(Set<Set<Integer>> powerSet) {
        for (Set<Integer> subset : powerSet) {
            System.out.print("{ ");
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println("}");
        }
    }
}
