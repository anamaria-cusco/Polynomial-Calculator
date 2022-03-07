import controller.PolynomialCalculatorController;
import model.Operations;
import view.PolynomialCalculatorView;

public class MainClass {
    public static void main(String[] args) {
        Operations operations =new Operations();
        PolynomialCalculatorView polynomialCalculatorView=new PolynomialCalculatorView();
        new PolynomialCalculatorController(operations,polynomialCalculatorView);

    }
}
