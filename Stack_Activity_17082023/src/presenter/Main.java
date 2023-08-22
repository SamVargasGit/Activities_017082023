package presenter;
import view.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ExpressionEvaluatorView view = new ExpressionEvaluatorView() {
            @Override
            public void showResult(double result) {
                System.out.println("Result: " + result);
            }

            @Override
            public void showMessage(String errorMessage) {
                System.out.println(errorMessage);
            }
        };
        ExpressionEvaluatorPresenter presenter = new ExpressionEvaluatorPresenter(view);

        System.out.print("Enter a mathematical expression: ");
        String expression = scanner.nextLine();

        presenter.evaluateExpression(expression);

        scanner.close();
    }
}
