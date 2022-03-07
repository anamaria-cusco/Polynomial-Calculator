package model;

import utils.ArrayListAnySize;

import java.util.*;

public class Polynomial {
    private final List<Monomial> monomialsList;


    public Polynomial() {
        Monomial monomial = new Monomial(0, 0);
        ArrayListAnySize<Monomial> arrayListAnySize = new ArrayListAnySize<>();
        arrayListAnySize.setReferenceElem(monomial);
        monomialsList = arrayListAnySize; //lista de monoame este o instanta a clasei ArrayListAnySize
    }


    /**
     * @param inputPolynomial -input-ul utilizatorului (polinomul introdus de acesta)
     * @return true -daca expresia introdusa este valida, altfel se arunca o exceptie
     */
    public boolean constructMonomialsList(String inputPolynomial) throws Exception {


        inputPolynomial = inputPolynomial.replaceAll("\\s+", "");
        inputPolynomial = inputPolynomial.replaceAll("-", "+-"); //inlocuiesc toate -, cu +-

        int coefficient;
        int grade;

        List<String> terms = new ArrayList<>(Arrays.asList(inputPolynomial.split("\\+"))); //fac impartire dupa +
        terms.removeAll(Arrays.asList("",null));

        for (String it : terms) {

                if (it.matches("[+-]?\\d+")) { //cazul 1: constanta
                    coefficient = Integer.parseInt(it);
                    grade = 0;

                } else if (it.matches("[+-]?\\d*x")) { //cazul 2: termeni de gradul 1: x, 2x, 3x
                    it = it.replace("x", "");
                    grade = 1;
                    if (it.isEmpty())
                        coefficient = 1;
                    else
                        coefficient = Integer.parseInt(it);


                } else if (it.matches("[+-]?\\d*x\\^\\d+")) { //cazul 3: termeni de grad >1: x^3, 3x^2, 2x^9

                    String[] expr = it.split("x\\^");
                    grade = Integer.parseInt(expr[1]);
                    if (expr[0].equals("-"))
                        coefficient = -1;
                    else if (expr[0].isEmpty())
                        coefficient = 1;
                    else
                        coefficient = Integer.parseInt(expr[0]);

                }
              else {
                   throw new Exception(it);
                }

                Monomial monomial = new Monomial(coefficient, grade);
                monomialsList.add(grade, monomial);
            }

        return true;
    }

    @Override
    public String toString() {
        String str="";
        // parcurgem lista termenilor de la sfarsit (vrem sa afisam gradele descrescator)
        ListIterator<Monomial> it = monomialsList.listIterator(this.monomialsList.size());
        while (it.hasPrevious()) {
            Monomial prev=it.previous();
            // pentru fiecare termen apelam metoda printIntegerCoefficient din clasa Monomial
            str+=prev.printIntegerCoefficient();

        }
        return str;
    }

    public String displayRealCoefficients(){
        String str="";
        // parcurgem lista termenilor de la sfarsit (vrem sa afisam gradele descrescator)
        ListIterator<Monomial> it = monomialsList.listIterator(this.monomialsList.size());
        while (it.hasPrevious()) {
            Monomial prev=it.previous();
            // pentru fiecare termen apelam metoda printCoefficient din clasa Monomial
            str+=prev.printCoefficient();

        }
        return str;
    }


    public List<Monomial> getMonomialsList() {
        return monomialsList;
    }


}
