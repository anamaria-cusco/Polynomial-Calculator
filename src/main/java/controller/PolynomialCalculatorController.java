package controller;

import model.Polynomial;
import model.Operations;
import view.ErrorView;
import view.PolynomialCalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomialCalculatorController {

    Operations operations;
    PolynomialCalculatorView polynomialCalculatorView;

    public PolynomialCalculatorController(Operations operations, PolynomialCalculatorView polynomialCalculatorView) {
        this.operations = operations;
        this.polynomialCalculatorView = polynomialCalculatorView;
        polynomialCalculatorView.addResetListener(new ResetListener());
        polynomialCalculatorView.addAdditionListener(new AdditionListener());
        polynomialCalculatorView.addSubtractionListener(new SubtractionListener());
        polynomialCalculatorView.addMultiplicationListener(new MultiplicationListener());
        polynomialCalculatorView.addDivisionListener(new DivisionListener());
        polynomialCalculatorView.addIntegrationListener(new IntegrationListener());
        polynomialCalculatorView.addDerivativeListener(new DerivativeListener());
    }

    class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            polynomialCalculatorView.getPolynomial1TextField().setText("");
            polynomialCalculatorView.getPolynomial2TextField().setText("");
            polynomialCalculatorView.getResultTextField().setText("");
        }
    }

    class AdditionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();
            try {
                if (polynomialCalculatorView.getPolynomial1().isEmpty() || polynomialCalculatorView.getPolynomial2().isEmpty()) {
                    new ErrorView("Trebuie sa introduceti 2 polinoame pentru a efectua operatia!");
                } else {

                    if (!polynomial1.constructMonomialsList(polynomialCalculatorView.getPolynomial1()))
                        new ErrorView("Primul polinom este introdus gresit! Introduceti din nou acest polinom!");
                    else if (!polynomial2.constructMonomialsList(polynomialCalculatorView.getPolynomial2()))
                        new ErrorView("Al doilea polinom este introdus gresit! Introduceti din nou acest polinom!");

                    else {
                        Polynomial result = operations.add(polynomial1, polynomial2);
                        if (result.toString().isEmpty())
                            polynomialCalculatorView.getResultTextField().setText("0");
                        else
                            polynomialCalculatorView.getResultTextField().setText(result.toString());
                    }
                }

            } catch (Exception ex) {
                new ErrorView("Formatul unui polinom introdus este gresit!");
            }
        }

    }

    class SubtractionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();
            try {
                if (polynomialCalculatorView.getPolynomial1().isEmpty() || polynomialCalculatorView.getPolynomial2().isEmpty()) {
                    new ErrorView("Trebuie sa introduceti 2 polinoame pentru a efectua operatia!");
                } else {

                    if (!polynomial1.constructMonomialsList(polynomialCalculatorView.getPolynomial1()))
                        new ErrorView("Primul polinom este introdus gresit! Introduceti din nou acest polinom!");
                    else if (!polynomial2.constructMonomialsList(polynomialCalculatorView.getPolynomial2()))
                        new ErrorView("Al doilea polinom este introdus gresit! Introduceti din nou acest polinom!");

                    else {

                        Polynomial result = operations.subtract(polynomial1, polynomial2);
                        if (result.toString().isEmpty())
                            polynomialCalculatorView.getResultTextField().setText("0");
                        else
                            polynomialCalculatorView.getResultTextField().setText(result.toString());
                    }
                }
            } catch (Exception ex) {
                new ErrorView("Formatul unui polinom introdus este gresit!");
            }
        }
    }

    class MultiplicationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();
            try {
                if (polynomialCalculatorView.getPolynomial1().isEmpty() || polynomialCalculatorView.getPolynomial2().isEmpty()) {
                    new ErrorView("Trebuie sa introduceti 2 polinoame pentru a efectua operatia!");
                } else {

                    if (!polynomial1.constructMonomialsList(polynomialCalculatorView.getPolynomial1()))
                        new ErrorView("Primul polinom este introdus gresit! Introduceti din nou acest polinom!");
                    else if (!polynomial2.constructMonomialsList(polynomialCalculatorView.getPolynomial2()))
                        new ErrorView("Al doilea polinom este introdus gresit! Introduceti din nou acest polinom!");

                    else {

                        Polynomial result = operations.multiply(polynomial1, polynomial2);
                        if (result.toString().isEmpty())
                            polynomialCalculatorView.getResultTextField().setText("0");
                        else
                            polynomialCalculatorView.getResultTextField().setText(result.toString());
                    }
                }
            } catch (Exception ex) {
                new ErrorView("Formatul unui polinom introdus este gresit!");
            }
        }
    }

    class DivisionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();
            try {
                if(polynomialCalculatorView.getPolynomial2().equals("0"))
                    new ErrorView("Nu este permisa impartirea cu 0!");

                else if (polynomialCalculatorView.getPolynomial1().isEmpty() || polynomialCalculatorView.getPolynomial2().isEmpty()) {
                    new ErrorView("Trebuie sa introduceti 2 polinoame pentru a efectua operatia!");
                } else {

                    if (!polynomial1.constructMonomialsList(polynomialCalculatorView.getPolynomial1()))
                        new ErrorView("Primul polinom este introdus gresit! Introduceti din nou acest polinom!");
                    else if (!polynomial2.constructMonomialsList(polynomialCalculatorView.getPolynomial2()))
                        new ErrorView("Al doilea polinom este introdus gresit! Introduceti din nou acest polinom!");

                    else {

                        String result = operations.divide(polynomial1, polynomial2);
                        if (result.isEmpty())
                            polynomialCalculatorView.getResultTextField().setText("0");
                        else
                            polynomialCalculatorView.getResultTextField().setText(result);
                    }
                }
            } catch (Exception ex) {
                new ErrorView("Formatul unui polinom introdus este gresit!");
            }
        }
    }

    class IntegrationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial = new Polynomial();
            if (polynomialCalculatorView.getPolynomial1().isEmpty() && polynomialCalculatorView.getPolynomial2().isEmpty())
                new ErrorView("Trebuie sa introduceti un polinom pentru a efectua operatia!");
            try {
                if (!polynomialCalculatorView.getPolynomial1().isEmpty()) {
                    if (!polynomial.constructMonomialsList(polynomialCalculatorView.getPolynomial1())) {
                        polynomialCalculatorView.getPolynomial2TextField().setText("");
                        new ErrorView("Primul polinom este introdus gresit! Introduceti din nou acest polinom!");
                    } else {

                        polynomialCalculatorView.getPolynomial2TextField().setText("");
                        Polynomial result = operations.integrate(polynomial);
                       polynomialCalculatorView.getResultTextField().setText(result.displayRealCoefficients());
                    }
                }

                if (!polynomialCalculatorView.getPolynomial2().isEmpty()) {
                    if (!polynomial.constructMonomialsList(polynomialCalculatorView.getPolynomial2())) {
                        polynomialCalculatorView.getPolynomial1TextField().setText("");
                        new ErrorView("Al doilea polinom este introdus gresit! Introduceti din nou acest polinom!");
                    } else {

                        polynomialCalculatorView.getPolynomial1TextField().setText("");
                        Polynomial result = operations.integrate(polynomial);
                        polynomialCalculatorView.getResultTextField().setText(result.displayRealCoefficients());
                    }
                }
            } catch (Exception ex) {
                new ErrorView("Formatul unui polinom introdus este gresit!");
            }
        }
    }

    class DerivativeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial polynomial = new Polynomial();
            if (polynomialCalculatorView.getPolynomial1().isEmpty() && polynomialCalculatorView.getPolynomial2().isEmpty())
                new ErrorView("Trebuie sa introduceti un polinom pentru a efectua operatia!");
            try {
                if (!polynomialCalculatorView.getPolynomial1().isEmpty()) {
                    polynomialCalculatorView.getPolynomial2TextField().setText("");
                    if (!polynomial.constructMonomialsList(polynomialCalculatorView.getPolynomial1())) {
                        new ErrorView("Primul polinom este introdus gresit! Introduceti din nou acest polinom!");
                    } else {

                        Polynomial result = operations.derive(polynomial);
                        if (result.toString().isEmpty())
                            polynomialCalculatorView.getResultTextField().setText("0");
                        else
                            polynomialCalculatorView.getResultTextField().setText(result.toString());
                    }
                }

                if (!polynomialCalculatorView.getPolynomial2().isEmpty()) {
                    polynomialCalculatorView.getPolynomial1TextField().setText("");
                    if (!polynomial.constructMonomialsList(polynomialCalculatorView.getPolynomial2())) {
                        new ErrorView("Al doilea polinom este introdus gresit! Introduceti din nou acest polinom!");
                    } else {
                        Polynomial result = operations.derive(polynomial);
                        if (result.toString().isEmpty())
                            polynomialCalculatorView.getResultTextField().setText("0");
                        else
                            polynomialCalculatorView.getResultTextField().setText(result.toString());
                    }
                }
            } catch (Exception ex) {
                new ErrorView("Formatul unui polinom introdus este gresit!");
            }
        }
    }
}



