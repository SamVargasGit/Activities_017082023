package presenter;
import model.PowerSetGeneratorModel;
import view.PowerSetGeneratorView;
import java.util.HashSet;
import java.util.Set;

public class PowerSetGeneratorPresenter {
    private PowerSetGeneratorView view;
    private PowerSetGeneratorModel model;

    public PowerSetGeneratorPresenter(PowerSetGeneratorView view, PowerSetGeneratorModel model) {
        this.view = view;
        this.model = model;
    }

    public void generatePowerSet(Set<Integer> inputSet) {
        Set<Set<Integer>> powerSet = model.generatePowerSet(inputSet);
        view.displayPowerSet(powerSet);
    }
}
