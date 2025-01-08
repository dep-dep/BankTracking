/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs20models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author 105243003
 */// Expense
public class ExpenseList {

    ExpensePerson[] expenseList;
    int expenseCount;

    public ExpenseList() {
        expenseList = new ExpensePerson[100000];
        expenseCount = 0;
    }

    public ExpensePerson[] toArray() {
        ExpensePerson[] unBufferedCardList = new ExpensePerson[expenseCount];
        for (int i = 0; i < expenseCount; i++) {
            unBufferedCardList[i] = expenseList[i];

        }
        return unBufferedCardList;
    }

    public void addExpense(ExpensePerson up) {
        if (expenseCount >= expenseList.length) {
            return;
        }
        expenseList[expenseCount] = up;
        expenseCount++;
    }

    public void getExpense(ExpensePerson cc) {
        for (int i = 0; i < expenseCount; i++) {

            if (expenseCount >= expenseList.length) {
                return;
            }
            expenseList[expenseCount] = cc;
            expenseCount++;
        }

    }

    public String getSaveString() {
        String saveStr = "";
        String encSaveStr = "";
        for (int i = 0; i < expenseCount; i++) {
            saveStr = saveStr + expenseList[i].getSaveString();
            saveStr = saveStr + "\n";
        }
        encSaveStr = Encrypt(saveStr);
//encSaveStr = saveStr;

        return encSaveStr;
    }

    public String saveToFile(String pathToFile) throws IOException {
//        FileWriter fw = new FileWriter(pathToFile);
//        PrintWriter pw = new PrintWriter(fw);
        String saveStr = this.getSaveString();
        return saveStr;
//        pw.print(saveStr);
//        System.out.println(saveStr);
//        pw.close();

    }

    public void openFromFile(String pathToFile) throws IOException {
//        String decryptStr = "";
//        String line = "s";
//        File f = new File(pathToFile);
        expenseList = new ExpensePerson[100000];
        expenseCount = 0;
//        Scanner sc = new Scanner(f);
        String line = pathToFile;
        String str = Decrypt(line);
//        System.out.println(str);
//        line = sc.nextLine();
//        decryptStr = Decrypt(line);
        String[] outter = str.split("\n");
        String[] inside;
        /*
        this.expensesName = "";
        this.expensesBankName = "";

        this.expensesDate = "";
        this.expensesDueDate = "";
        this.expensesInfo = "";

        this.expensesAmount = 0.0;
        this.paymentAmount = 0.0;
        this.expensestf = false;
        this.paymenttf = false;
    
         */
//        System.out.println(str);
        for (int i = 0; i < outter.length; i++) {
            System.out.println(outter.length + "()()()()()");
            inside = outter[i].split(" ");
            for (int j = inside.length - 1; j < inside.length; j++) {
//                 System.out.println(j);.
                ExpensePerson ep = new ExpensePerson();
//                if (inside.length == 4) {
//                    System.out.println(inside[0]);
//                    System.out.println(inside[1]);
//                    System.out.println(inside[2]);
//                    System.out.println(inside[3]);
//                    System.out.println(inside[4]);
////                    
//                    ep.setCardName(inside[0].replace("'", " ").replace("!", " "));
//                    ep.setCardBankName(inside[1]   .replace("'", " ").replace("!", " "));
//                    ep.setCardDate(inside[2].replace("'", " ").replace("!", " "));
//                    ep.setCardInfo(inside[3].replace("'", " ").replace(")", "\n").replace("!", " "));
//                    ep.setCardDueDate(inside[4].replace("'", " ").replace("!", " "));
//                    System.out.println(inside.length + "()()()()()");
//                    System.out.println(inside[0] + "()()()()()");
//                    System.out.println(inside[1] + "()()()()()");
//                    System.out.println(inside[2] + "()()()()()");
//                    System.out.println(inside[3] + "()()()()()");
//                    System.out.println(inside[4] + "()()()()()");
//                    System.out.println(inside[5] + "()()()()()");
//                    System.out.println(inside[6] + "()()()()()");
//                    System.out.println(inside[7] + "()()()()()");
//                    System.out.println(inside[8] + "()()()()()");
//                    System.out.println(inside[9] + "()()()()()");

//                } else if (inside.length == 17) {

                    ep.setExpensesName(inside[0].replace("'", " "));
                    ep.setExpensesBankName(inside[1].replace("'", " "));
                    ep.setExpensesDate(inside[2].replace("'", " "));
                    ep.setExpensesDueDate(inside[3].replace("'", " "));
                    ep.setExpensesInfo(inside[4].replace("'", " ").replace(")", "\n").replace("!", " "));
                    ep.setExpensesAmount(Double.parseDouble(inside[5]));
                    ep.setPaymentAmount(Double.parseDouble(inside[6]));
                    ep.setExpensesTrueFalse(Boolean.parseBoolean(inside[7]));
                    ep.setPaymentTrueFalse(Boolean.parseBoolean(inside[8]));

//                }
                this.addExpense(ep);
            }
        }
//        File f = new File(pathToFile);
//        Scanner sc = new Scanner(f);
//        
//        powList = new CardPerson[10000];
//        
//        powCount = 0;
//        while (sc.hasNextLine()){
//        String line = sc.nextLine();
//        String[] fields = line.split(" ");
//        
//        CardPerson pp = new CardPerson();
//        pp.setName(fields[0]);
//        pp.setRank(fields[1]);
//        int serial = Integer.parseInt(fields[2]);
//        pp.setSerial(serial);
//        pp.setGender(fields[3]);
////        System.out.println(pp.getGender());
//        
//        this.addPow(pp);             
//        }

    }

    public String Encrypt(String str) {
        String chipherString = str;
        String newStr = "";

        char[] chipherText = new char[chipherString.length()];
        for (int i = 0; i < chipherString.length(); i++) {
            chipherText[i] = chipherString.charAt(i);
        }

        for (int j = 0; j < chipherText.length; j++) {
            chipherText[j] = (char) ((int) chipherText[j] + 13);
            newStr += chipherText[j];
        }

        return newStr;
    }

    public String Decrypt(String str) {
        String plainText = str;
        String oldStr = "";

        char[] decrptText = new char[plainText.length()];
        for (int i = 0; i < plainText.length(); i++) {
            decrptText[i] = plainText.charAt(i);
        }

        for (int j = 0; j < decrptText.length; j++) {
            decrptText[j] = (char) ((int) decrptText[j] - 13);
            oldStr += decrptText[j];
        }

        return oldStr;
    }
}
