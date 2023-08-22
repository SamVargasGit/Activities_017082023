package presenter;
import view.*;
import model.*;
    class ExpressionEvaluatorPresenter {
        private ExpressionEvaluatorView view;
        private MathEvaluator mathEvaluator;

        public ExpressionEvaluatorPresenter(ExpressionEvaluatorView view) {
            this.view = view;
            mathEvaluator = new MathEvaluator();
        }

        public void evaluateExpression(String expression) {
            try {
                double result = mathEvaluator.evaluateExpression(expression);
                view.showResult(result);
            } catch (Exception e) {
                view.showMessage("Error evaluating expression: " + e.getMessage());
            }
        }
}

