package Liang;

public class Prime120 {
    public static void prime120(){
        StackOfIntegers stack= new StackOfIntegers();
        for(int i=120;i>=2;i--){
            if(i>109 ){
                while(i%11==0){   //checking to see if it is a multiple of 11
                    i--;
                }
            }
            if(i%7==0||i%5==0||i%3==0||i%2==0){
                continue;
            }
            else
                stack.push(i);

        }
        stack.push(7);stack.push(5);stack.push(3);stack.push(2);
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
