package Liang;
import java.util.*;
public class Main {
static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
 Queue m=new Queue();
 m.enque(1);
        m.enque(3);
        m.enque(2);
        m.enque(4);
        System.out.println(m.getSize());
        System.out.println(m.deque());
        System.out.println(m.deque());
        System.out.println(m.deque());
        System.out.println(m.deque());
        System.out.println(m.deque());
        System.out.println(m.deque());
        m.enque(99);
        System.out.println(m.deque());



    }
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

