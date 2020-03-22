
///This is a queue that iterates with a linked list


package Liang;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
public class QueuewithIterator<Integer> implements Iterable<Integer>{
///////////////////////////////Class Elements////////////////////////////////////////////////
    private int size; // number of elements in the queue
    private Node first;
    private Node last;
/////////////////////////////////////////////////////////////////////////////////////////
     class Node {    //helper linked list class
        private Integer item;
        private Node next;

        Node(){
            this.item=null;
            this.next=null;
        }

         Node(Integer integer){
            this.item=integer;
            this.next=null;
        }
    }
    public QueuewithIterator(){                 //creates an empty Queue
        first=null;
        last=first;
        size=0;
    }

    public boolean isEmpty() {
        return !iterator().hasNext();
    }


    public int size() {
        return size;
    }

    public Integer peek() {   //Not sure how this works. If it throws an exception, but still returns stuff
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    public void enqueue(Integer num){
      if(isEmpty())
      {first=new Node(num); size++;last=first;}
      else
      {last.next=new Node(num); last=last.next; size++;}                         //puts a node at the end with num as its item
    }

    public Integer dequeue(){
       Integer nextItem= iterator().next();
       first=first.next;
       size--;
       return nextItem;
    }

    ////////////////////////////////
    //Finish Code                 //
    ////////////////////////////////

    public Iterator<Integer> iterator() {                                 //this returns an Iterator, but where is the constructor
        return new ListIterator();                                        //for the list iterator?
    }
    private class ListIterator implements Iterator<Integer> {

        private Node current=first;




        @Override
        public boolean hasNext() {                                //can iterate in a for loop with iterator

            return current!=null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            Integer item = current.item;
            current = current.next;                                   //next node is now current node
            return item;                                              //returns item

        }


    }
}
//End of Class

