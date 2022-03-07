package utils;
import java.util.ArrayList;


public class ArrayListAnySize<E> extends ArrayList<E>{
   private E referenceElem;

    public E getReferenceElem() {
        return referenceElem;
    }

    public void setReferenceElem(E referenceElem) {
        this.referenceElem = referenceElem;
    }

    public void add(int index, E element){

        if(index >=0 && index <= size()){
            if(size()!=0)
            super.remove(index);
            super.add(index, element);
            return;
        }

        int insertZeros = index - size();
        for(int i = 0; i < insertZeros; i++){ //elem to insert in between the elements of the array
            super.add(referenceElem);
        }
        super.add(element);
    }
}

