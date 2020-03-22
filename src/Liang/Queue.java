package Liang;


public class Queue {
    int[] elements;
    int size;
    int capacity;


    Queue() {
        this(8);   //The default constructor call itself. I only put an 8 in it and it referred to the below constructor
    }

    Queue(int capacity) {
        this.capacity=(capacity);
        elements=new int[capacity];
    }

    public void enque(int v) {
        this.elements[size]=v;
        size++;

        if(this.size==this.elements.length){   // double the arraysize
            int[] temp=new int[this.elements.length*2];
            System.arraycopy(this.elements,0,temp,0,this.elements.length);
            this.elements=temp;

        }

    }

    public int deque()  {


             int j= this.elements[0];
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


