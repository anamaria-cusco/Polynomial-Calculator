package model;


public class Monomial{
    private int grade; //gradul monomului
    private double coefficient; //coeficientul monomului



    Monomial(double coefficient,int grade){
        this.coefficient=coefficient;
        this.grade=grade;
    }


    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    //afisarea monomului cu coeficient intreg
    public String printIntegerCoefficient() {
       String str="";

           if(coefficient>1) str+="+"+(int)this.getCoefficient();
           if(coefficient<-1) str+="-"+ Math.abs((int)this.getCoefficient());
           if(coefficient==-1 && grade!=0) str+="-";
           if(coefficient==1 && grade!=0) str+="+";
           if(coefficient==1 && grade==0) str+="+1";
           if(coefficient==-1 && grade==0) str+="-1";

           if(coefficient!=0) {
               if (grade > 1) str += "x^" + this.getGrade();
               if (grade == 1) str += "x";
           }
           return str;
       }

    // afisarea monomului cu coeficient real
    public String printCoefficient() {
        String str="";
        if(coefficient>0 ) str+="+" +String.format("%.2f",this.coefficient);
        if(coefficient<0 ) str+="-"+ String.format("%.2f",Math.abs(this.coefficient));

        if(coefficient!=0) {
            if (grade > 1) str += "x^" + this.getGrade();
            if (grade == 1) str += "x";
        }
        return str;
    }

    @Override
    public String toString() {
        return "Monomial{" +
                "grade=" + grade +
                " coefficient=" + coefficient +
                '}';
    }
}






