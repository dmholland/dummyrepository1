package Liang;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;
public class Game_ATM {
    private Account[] accountID;
    private boolean exit;

    Game_ATM(){
       this.accountID=new Account[10];
       this.exit=false;
    };

    public void createAccounts(){
        for(int i=0; i<10;i++){
            Account a=new Account(i,100);
            this.accountID[i]=a;
        }
        System.out.println("Ten accounts created.");
    }

    public void ATM() {

        Scanner scanner = new Scanner(System.in);

        int id;
        while (true) {
            do {
                System.out.print("Please enter an Id: ");
                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.printf("\"%s\" is not a valid number.\n", input);
                }
                id = scanner.nextInt();
            } while (id > 9 || id < 0);
            System.out.printf("You have entered ID: %d.\n", id);
            while (true) {   //infinite loop
                this.Accountprobe(id);
                if (this.exit == true) {
                    break;
                }
            }                  //end of infinite loop
        }
    }

   public void Accountprobe(int id){
        this.exit=false;
       System.out.println("Main menu");
       System.out.println("1: check balance");
       System.out.println("2: withdraw");
       System.out.println("3: deposit");
       System.out.println("4: exit");

       Scanner scanner = new Scanner(System.in);
       int choice;
       do {
           System.out.println("Enter a choice: ");
           while(!scanner.hasNext()) {
               String followup = scanner.next();
               System.out.println("Please enter a valid choice");
           }

           choice=scanner.nextInt();

       }while(choice<=0 || choice>=5);
       choiceMethod(choice,id);

   }
// Take choices and ID and does calculation on the account
 public void choiceMethod(int choice, int id){
     Scanner scanner = new Scanner(System.in);

        switch(choice){

            case 1:
                System.out.println("The balance is "+this.accountID[id].getBalance()); break;

            case 2: double withDraw;
                    if(this.accountID[id].getBalance()==0){  //if the account has no money
                        System.out.println("Account is empty");
                        break;
                    }
                do {
                    System.out.println("Enter amount to withdraw (less than " + this.accountID[id].getBalance() + "): ");
                    while (!scanner.hasNextDouble()) {    //checking for valid entry
                        String followup = scanner.next();
                        System.out.println("This is not a valid entry");
                    }
                    withDraw = scanner.nextDouble();
                }while(withDraw>this.accountID[id].getBalance() ||withDraw<0);

                this.accountID[id].withdraw(withDraw);   //Withdrawing  from account and returning balance
                System.out.println("Account balance is is "+this.accountID[id].getBalance());break;



            case 3:double deposit;
                if(this.accountID[id].getBalance()==0){  //if the account has no money
                    System.out.println("Account is empty");
                    break;
                }
                do {
                    System.out.println("Enter amount to deposit greater than 0 ");
                    while (!scanner.hasNextDouble()) {    //checking for valid entry
                        String followup = scanner.next();
                        System.out.println("This is not a valid entry");
                    }
                    deposit = scanner.nextDouble();
                }while(deposit<=0);

                this.accountID[id].deposit(deposit);   //Withdrawing  from account and returning balance
                System.out.println("Account balance is is "+this.accountID[id].getBalance());break;



            case 4:System.out.println("Have a nice day "); this.exit=true;break;  //exits program

        }
 }


}
