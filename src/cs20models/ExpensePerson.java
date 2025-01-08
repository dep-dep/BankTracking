  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs20models;

/**
 *
 * @author 105243003
 */
public class ExpensePerson {

    private String expensesName, expensesBankName, expensesDate, expensesInfo, expensesDueDate;
    
    /*
    cardPaymentDate
    expensesPaymentDate
    
     */

    private double expensesAmount, paymentAmount;

    
    /*
    cardPayment
    expensesPayment
     */
    private boolean expensestf, paymenttf;

    public ExpensePerson() {

        this.expensesName = "!";
        this.expensesBankName = "!";

        this.expensesDate = "!";
        this.expensesDueDate = "!";
        this.expensesInfo = "!";

        this.expensesAmount = 0.0;
        this.paymentAmount = 0.0;
        this.expensestf = false;
        this.paymenttf = false;
    }

    /*
        this.cardPaymentDate = "";
        this.expensesPaymentDate = "";
        this.cardPayment = 0.0;
        this.expensesPayment = 0.0;
     */

    public String getExpensesName() {
        return this.expensesName;
    }

    public void setExpensesName(String str) {
        this.expensesName = str;
    }

    public String getExpensesBankName() {
        return this.expensesBankName;
    }

    public void setExpensesBankName(String str) {
        this.expensesBankName = str;
    }

    public String getExpensesDate() {
        return this.expensesDate;
    }

    public void setExpensesDate(String str) {
        this.expensesDate = str;
    }

    public String getExpensesInfo() {
        return this.expensesInfo;
    }

    public void setExpensesInfo(String str) {
        this.expensesInfo = str;
    }

    public String getExpensesDueDate() {
        return this.expensesDueDate;
    }

    public void setExpensesDueDate(String str) {
        this.expensesDueDate = str;
    }

    public double getExpensesAmount() {
        return this.expensesAmount;
    }

    public void setExpensesAmount(double i) {
        this.expensesAmount = i;
    }
    
    public double getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(double i) {
        this.paymentAmount = i;
    }


    public boolean getExpensesTrueFalse() {
        return this.expensestf;
    }

    public void setExpensesTrueFalse(boolean tf) {
        this.expensestf = tf;
    }

    public boolean getPaymentTrueFalse() {
        return this.paymenttf;
    }

    public void setPaymentTrueFalse(boolean tf) {
        this.paymenttf = tf;
    }
    /*

        this.expensesDueDate = "";
        this.expensesInfo = "";

        this.expensesAmount = 0.0;
        this.paymentAmount = 0.0;
        this.expensestf = false;
        this.paymenttf = false;
    
    */
    public String getSaveString() {
     String str = this.expensesName.replace(" ", "'") + " " + this.expensesBankName.replace(" ", "'") + " " + this.expensesDate.replace(" ", "'")
             + " " + this.expensesDueDate.replace(" ", "'") + " " + this.expensesInfo.replace(" ", "'").replace("\n", ")")/*.replace("\n", ")")*/ + " " + this.expensesAmount 
             + " " + this.paymentAmount + " " + this.expensestf + " " + this.paymenttf;    
        System.out.println(str);
    return str;
    }
/*
        public String getCardPaymentDate() {
        return this.cardPaymentDate;
    }

    public void setCardPaymentDate(String str) {
        this.cardPaymentDate = str;
    }

    //investmentPaymentDate
    public String getExpensesPaymentDate() {
        return this.expensesPaymentDate;
    }

    public void setExpensesPaymentDate(String str) {
        this.expensesPaymentDate = str;
    }
        public double getCardPayment() {
        return this.cardPayment;
    }

    public void setCardPayment(double i) {
        this.cardPayment = i;
    }

    public double getExpensesPayment() {
        return this.expensesPayment;
    }

    public void setEnvestmentPayment(double i) {
        this.expensesPayment = i;
    }
    
    */
    @Override
    public String toString() {
    
                if (this.expensestf == true) {
            return this.expensesBankName + ": " + this.expensesName + " (" + this.expensesDueDate + ")";
        }
            this.expensestf = false;
            return "Don't have it included";
    }
    
 
}
