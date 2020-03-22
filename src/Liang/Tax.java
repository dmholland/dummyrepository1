package Liang;

    /*********************************************************************************
     * (Financial application: compute tax) Rewrite Listing 3.5, ComputeTax.java,     *
     * using arrays. For each filing status, there are six tax rates. Each rate is    *
     * applied to a certain amount of taxable income. For example, from the taxable   *
     * income of $400,000 for a single filer, $8,350 is taxed at 10%, (33,950 - 8,350)*
     * at 15%, (82,250 - 33,950) at 25%, (171,550 - 82,550) at 28%, (372,550 - 82,250)*
     * at 33%, and (400,000 - 372,950) at 36%. The six rates are the same for all     *
     * filing statuses, which can be represented in the following array:              *
     *                                                                                *
     * double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};                         *
     *                                                                                *
     * The brackets for each rate for all the filing statuses can be represented in a *
     * two dimensional array as follows:                                              *
     * int[][] brackets = {                                                           *
     * 	 {8350, 33950, 82250, 171550, 372950},  // Single filer                       *
     * 	 {16700, 67900, 137050, 20885, 372950}, // Married jointly                    *
     * 	                                        // -or qualifying widow(er)           *
     * 	 {8350, 33950, 68525, 104425, 186475},  // Married separately                 *
     * 	 {11950, 45500, 117450, 190200, 372950} // Head of household                  *
     *  };                                                                            *
     *                                                                                *
     * Suppose the taxable income is $400,000 for single filers. The tax can be       *
     * computed as follows:                                                           *
     *                                                                                *
     * tax = brackets[0][0] * rates[0] +                                              *
     * 	 (brackets[0][1] – brackets[0][0]) * rates[1] +                               *
     * 	 (brackets[0][2] – brackets[0][1]) * rates[2] +                               *
     * 	 (brackets[0][3] – brackets[0][2]) * rates[3] +                               *
     * 	 (brackets[0][4] – brackets[0][3]) * rates[4] +                               *
     * 	 (400000 – brackets[0][4]) * rates[5]                                         *
     *********************************************************************************/
import java.util.Scanner;

public class Tax {
    int filingStatus;
    int [][] brackets;
    double [] rates;
    double taxableIncome;


    Tax(){

    }

    Tax(int filingStatus, int[][] brackets,double [] rates,double taxableIncome){
        this.filingStatus=filingStatus;
        this.brackets=brackets;
        this.rates=rates;
        this.taxableIncome=taxableIncome;
    }



    public static void  doTaxes(){
            // Create a Scanner
            Scanner input = new Scanner(System.in);

            // Tax rates
            double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};

            // The brackets for each rate for all the filing statuses


            // Prompt the user to enter filing status
            System.out.print("(0-single filer, 1-married jointly or " +
                    "qualifying widow(er), 2-married separately, 3-head of " +
                    "household) Enter the filing status: ");
            int status = setStatus();

            // Prompt the user to enter taxable income
            System.out.print("Enter the taxable income: ");
            double taxableIncome = getTaxableIncome();


            // Display the result


            int[][]brackets=getBrackets();

            Tax m=new Tax(status,brackets,rates,taxableIncome);
        System.out.printf("Tax is $%6.2f\n",
                m.getTax());
        }//End of do taxes


        /** computeTax computes and returns the total
         tax for the filing status brackets */
        public  double getTax() {
            double tax = 0, incomeTaxed = 0;
            for (int i = 4; i >= 0; i--) {
                if (this.taxableIncome > this.brackets[this.filingStatus][i])
                    tax += (incomeTaxed = this.taxableIncome - this.brackets[this.filingStatus][i]) * this.rates[i + 1];  //calculates by bracket and rate
                this.taxableIncome -= incomeTaxed;
            }
            return tax += this.brackets[this.filingStatus][0] * this.rates[0];
        }

        /** getStatus returns a valid status */
        public static int setStatus(){
            Scanner input = new Scanner(System.in);
            int status;
            do {
                status = input.nextInt();
                if (status < 0 || status > 3)
                    System.out.println("Error: invalid status");
            } while (status < 0 || status > 3);
            return status;
        }

    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public  static int[][] getBrackets() {
        int[][] brackets = {
                {8350, 33950, 82250, 171550, 372950},  // Single filer
                {16700, 67900, 137050, 20885, 372950}, // Married jointly
                // -or qualifying widow(er)
                {8350, 33950, 68525, 104425, 186475},  // Married separately
                {11950, 45500, 117450, 190200, 372950} // Head of household
        };
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public static double getTaxableIncome() {    //Gets income
            double income;
            do {
                System.out.println("Please enter yor income");
                Scanner input = new Scanner(System.in);
while(!input.hasNextDouble()){
    String followup= input.next();
    System.out.println("This is not a valid number");
}
income=input.nextDouble();
            }while(income<0);
               return income;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }
}                                 //End of File





