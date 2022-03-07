package model;

import java.util.ListIterator;

public class Operations {

    public Operations() {
    }

    public Polynomial add(Polynomial polynomial1, Polynomial polynomial2) {
        //Declaram polinomul result unde vom stoca rezultatul operatiei de adunare
        Polynomial result = new Polynomial();

        // maxSize - retine maximul gradelor celor 2 polinoame
        int maxSize = Math.max(polynomial1.getMonomialsList().size(), polynomial2.getMonomialsList().size());
        ListIterator<Monomial> it1 = polynomial1.getMonomialsList().listIterator(polynomial1.getMonomialsList().size());
        ListIterator<Monomial> it2 = polynomial2.getMonomialsList().listIterator(polynomial2.getMonomialsList().size());
        int index = maxSize - 1;

        //parcurgem listele de termeni ai polinoamelor de la gradul cel mai mare la cel mai mic (invers)
        while (it1.hasPrevious() || it2.hasPrevious()) {

            //daca polinomul 1 este de grad mai mare decat cel al 2-lea ii adaugam termenii in rezultat atata timp cat gradul sau este mai mare
            while (it1.previousIndex() > it2.previousIndex()) {
                result.getMonomialsList().add(index, new Monomial(it1.previous().getCoefficient(), index));
                index--;
            }
            //daca polinomul 2 este de grad mai mare decat primul ii adaugam termenii in rezultat atata timp cat gradul sau este mai mare
            while (it2.previousIndex() > it1.previousIndex()) {

                result.getMonomialsList().add(index, new Monomial(it2.previous().getCoefficient(), index));
                index--;
            }
            //cand polinoamele au ajuns de acelasi grad, adunam coeficientii corespunzatori din fiecare polinom si ii adaugam la rezultat
            result.getMonomialsList().add(index, new Monomial(it1.previous().getCoefficient() + it2.previous().getCoefficient(), index));
            index--;

        }
        return result;
    }

    public Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2) {
        //Declaram polinomul result unde vom stoca rezultatul operatiei de scadere
        Polynomial result = new Polynomial();

        // maxSize - retine maximul gradelor celor 2 polinoame
        int maxSize = Math.max(polynomial1.getMonomialsList().size(), polynomial2.getMonomialsList().size());
        ListIterator<Monomial> it1 = polynomial1.getMonomialsList().listIterator(polynomial1.getMonomialsList().size());
        ListIterator<Monomial> it2 = polynomial2.getMonomialsList().listIterator(polynomial2.getMonomialsList().size());
        int index = maxSize - 1;

        //parcurgem listele de termeni ai polinoamelor de la gradul cel mai mare la cel mai mic (invers)
        while (it1.hasPrevious() || it2.hasPrevious()) {

            //daca polinomul 1 este de grad mai mare decat cel al 2-lea ii adaugam termenii in rezultat atata timp cat gradul sau este mai mare
            while (it1.previousIndex() > it2.previousIndex()) {
                result.getMonomialsList().add(index, new Monomial(it1.previous().getCoefficient(), index));
                index--;
            }
            //daca polinomul 2 este de grad mai mare decat primul ii adaugam termenii in rezultat atata timp cat gradul sau este mai mare, dar cu semne contrare
            while (it2.previousIndex() > it1.previousIndex()) {
                result.getMonomialsList().add(index, new Monomial((-1) * it2.previous().getCoefficient(), index));
                index--;
            }

            //cand polinoamele au ajuns de acelasi grad, scadem coeficientii corespunzatori din fiecare polinom si ii adaugam la rezultat
            result.getMonomialsList().add(index, new Monomial(it1.previous().getCoefficient() - it2.previous().getCoefficient(), index));
            index--;

        }
        return result;
    }

    public Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial result = new Polynomial();

        int sumOfGrades;
        double productOfCoefficients;
        int idx1;
        int idx2;
        double coefficient;
        ListIterator<Monomial> it1 = polynomial1.getMonomialsList().listIterator(polynomial1.getMonomialsList().size());
        ListIterator<Monomial> it2;
        while (it1.hasPrevious()) {
            idx1 = it1.previousIndex();
            //luam pe rand termenii primului polinom si ii inmultim cu toti termenii celui de-al doilea
            coefficient = it1.previous().getCoefficient();
            it2 = polynomial2.getMonomialsList().listIterator(polynomial2.getMonomialsList().size());
            while (it2.hasPrevious()) {
                idx2 = it2.previousIndex();
                sumOfGrades = idx1 + idx2;
                productOfCoefficients = coefficient * it2.previous().getCoefficient();

                //daca la un anumita pozitie din lista nu avem niciun termen adaugat, il adaugam, altfel adunam la termenul existent noul termen
                if (result.getMonomialsList().size() == 0)
                    result.getMonomialsList().add(sumOfGrades, new Monomial(productOfCoefficients, sumOfGrades));
                else
                    result.getMonomialsList().set(sumOfGrades, new Monomial(result.getMonomialsList().get(sumOfGrades).getCoefficient() + productOfCoefficients, sumOfGrades));
            }
        }

        return result;
    }


    //metoda urmareste algoritmul Polynomial Long Division
    public String divide(Polynomial polynomial1, Polynomial polynomial2) {
        Polynomial quotient =new Polynomial();
        Polynomial remainder;
        Polynomial divisor;
        int sizeDivident;
        int sizeDivisor;

        //alegem polinomul cu gradul cel mai mare
        if(polynomial1.getMonomialsList().size()>=polynomial2.getMonomialsList().size()){
            divisor=polynomial2;
            remainder=polynomial1;
            sizeDivident=polynomial1.getMonomialsList().size();
            sizeDivisor=polynomial2.getMonomialsList().size();
        }
        else{
            divisor=polynomial1;
            remainder=polynomial2;
            sizeDivident=polynomial2.getMonomialsList().size();
            sizeDivisor=polynomial1.getMonomialsList().size();
        }

        while (remainder.getMonomialsList() != null && remainder.getMonomialsList().size() >= divisor.getMonomialsList().size()) {

            double coefficient = remainder.getMonomialsList().get(sizeDivident - 1).getCoefficient() / divisor.getMonomialsList().get(sizeDivisor - 1).getCoefficient();
            int grade = remainder.getMonomialsList().get(sizeDivident - 1).getGrade() - divisor.getMonomialsList().get(sizeDivisor - 1).getGrade();
            Polynomial term = new Polynomial();
            term.getMonomialsList().add(grade, new Monomial(coefficient, grade));
            remainder = subtract(remainder, multiply(term, divisor));
            quotient.getMonomialsList().add(grade, new Monomial(coefficient, grade));
        /*    System.out.println("Term:" + term.getMonomialsList());
            System.out.println("Divisor Multiplied with quotient:" + multiply(term, divisor).getMonomialsList());
            System.out.println("Quotient:" + quotient.getMonomialsList());
            System.out.println("Remainder:" + remainder.getMonomialsList());*/
            while (remainder.getMonomialsList().get(sizeDivident - 1).getCoefficient() == 0) {
                remainder.getMonomialsList().remove(sizeDivident - 1);
                sizeDivident--;
                if (sizeDivident == 0) break;

            }

        }
        return "Q:" + quotient.displayRealCoefficients() + " --> " + "R:" + remainder.displayRealCoefficients();
    }


    public Polynomial integrate(Polynomial polynomial) {
        Polynomial result = new Polynomial();

        // parcurgem lista de termeni si pt fiecare calculam noul coeficient si grad
        ListIterator<Monomial> it = polynomial.getMonomialsList().listIterator(polynomial.getMonomialsList().size());
        int index = polynomial.getMonomialsList().size() - 1;
        while (it.hasPrevious()) {
            result.getMonomialsList().add(index + 1, new Monomial(it.previous().getCoefficient() / (index + 1), index + 1));
            index--;

        }
        return result;
    }


    public Polynomial derive(Polynomial polynomial) {
        Polynomial result = new Polynomial();

        // parcurgem lista de termeni si pt fiecare calculam noul coeficient si grad
        ListIterator<Monomial> it = polynomial.getMonomialsList().listIterator(polynomial.getMonomialsList().size());
        int index = polynomial.getMonomialsList().size() - 1;
        while (it.hasPrevious()) {
            result.getMonomialsList().add(index - 1, new Monomial(index * it.previous().getCoefficient(), index - 1));
            index--;

        }
        return result;
    }

}
