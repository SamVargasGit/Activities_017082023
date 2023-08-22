package presenter;
import model.PowerSetGeneratorModel;
import view.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>();
        inputSet.add(1);
        inputSet.add(2);
        inputSet.add(3);
        inputSet.add(4);
        inputSet.add(5);

        PowerSetGeneratorModel model = new PowerSetGeneratorModel();
        PowerSetGeneratorView view = new ConsolePowerSetGeneratorView();
        PowerSetGeneratorPresenter presenter = new PowerSetGeneratorPresenter(view, model);

        presenter.generatePowerSet(inputSet);
    }
}
