package Liang;
import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Queue  {
    int[] elements;
    int size;


    Queue() {
        this.elements = new int[8];
    }

    public void enque(int v) {
        this.elements[size]=v;
        size++;

        if(this.size==this.elements.length){   // double the arraysize
            int[] temp=new int[this.elements.length];
            System.arraycopy(this.elements,0,temp,0,this.elements.length);
            this.elements=new int[2*this.elements.length];
            System.arraycopy(temp,0,this.elements,0,temp.length);
        }

    }

    public int deque() throws Exception {
        int j;
        if(empty()) {throw new EmptyList("Sequence contains no elements");}

             j= this.elements[0];

            int[] temp = new int[this.elements.length];
            System.arraycopy(this.elements, 1, temp, 0, this.size--);
            this.elements = new int[this.elements.length];
            System.arraycopy(temp, 0, this.elements, 0, temp.length);



        return j;
    }

    public boolean empty(){
              // List<Integer> l=Arrays.stream(this.elements).boxed().collect(Collectors.toList());
       // for (Integer m:l) if(!(m==null)) {return false;}
          //  return true;
        if(this.size==0)return true;
        return false;
    }

    public int getSize(){
        return this.size;
    }

}


