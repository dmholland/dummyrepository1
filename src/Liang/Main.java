package Liang;
import java.util.*;
public class Main {
static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        QueuewithIterator queue=new QueuewithIterator();
       queue.enqueue(46);
       queue.enqueue(7);
        queue.enqueue(34);queue.enqueue(34);queue.enqueue(34);queue.enqueue(34);queue.enqueue(34);
      while(queue.iterator().hasNext()){
        System.out.println(queue.dequeue());}


















    }//End of main method





































    //methods
        public static void Reverse(int num){
            int num1 = num;
            StackOfIntegers stack = new StackOfIntegers();
            while (num1 != 0) {
                if (num1 % 2 == 0) {
                    stack.push(2);
                    num1 = num1 / 2;
                    continue;
                }

                if (num1 % 3 == 0) {
                    stack.push(3);
                    num1 = num1 / 3;
                    continue;
                }


                if (num1 % 5 == 0) {
                    stack.push(5);
                    num1 = num1 / 5;
                    continue;
                } else {
                    stack.push(2);
                    num1 = num1 / 2;
                    continue;
                }


            }
            while (stack.getSize() != 0) {
                System.out.print(stack.pop() + " ");
            }
        }


    }

