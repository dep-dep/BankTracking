package cs20viewcontroller;

import cs20models.CardPerson;
import cs20models.ExpenseList;
import cs20models.ExpensePerson;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 * Write methods in this class for displaying data in the DrawnView.
 *
 * You can use all the public instance variables you defined in AllModelsForView
 * and DrawnView as though they were part of this class! This is due to the
 * magic of subclassing (i.e. using the extends keyword).
 *
 * The methods for displaying data in the DrawnView are written as methods in
 * this class.
 *
 * Make sure to use these methods in the ViewUserActions class though, or else
 * they will be defined but never used!
 *
 * @author cheng
 */
public class ViewOutputs extends DrawnView {

//    public boolean bf = false;
    public void updateCardDetailsDisplay() {
        cardList.setListData(theCardList.toArray());
    }
    
    public void updateScreen() {
        updateCardDetailsDisplay();
        updateInvestDetailsDisplay();
    }

    public void checkTooSeeTrans(int cardSerial) {
        CardPerson aCard = theCardList.getCard(cardSerial);

        CardPerson aTrans = theTransList.getTrans(aCard.getCardSerial());
        DefaultListModel test = new DefaultListModel();

        int ser = aCard.getCardSerial();
//        System.out.println(aTrans.getTrasSerials() == 0);
//        System.out.println(aCard.getTrasSerials());
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();

        if (aTrans.getTrasSerials() == aCard.getTrasSerials()) {
            for (int i = 0; i < aTrans.getTransCount(); i++) {
                test.addElement(theTransList.getTrans(ser));
            }
            TransList.setListData(test.toArray());

        }

    }

//    public void updatetTransDetailsDisplay(int serial, int count, int cardCount) {
////        DefaultListModel listModel =  (DefaultListModel) TransList.getModel();
//            DefaultListModel test = new DefaultListModel();
//            
//        CardPerson aCard = theCardList.getCard(serial);
//        
////        
////        System.out.println("The card: " + theCardList.getCard(serial));
////        System.out.println("Serial: " + serial);
////        System.out.println("The Trans Serial: " + aCard.getTrasSerials());
////        
////        for (int i =0; i < 10; i++) {
////        System.out.println(aCard.getTrasSerials());
//        
////        }
////        System.out.println();
//        for (int i = 0; i < 10; i++) {
////        System.out.println(">>>>>>>>>   " +serial);
//        
//        }
////        System.out.println();
//        for (int i = 0; i < 10; i++) {
////        System.out.println(">>>>>>>>>   " +aCard.getTrasSerials());
//        
//        }
//        // setTrasSerials
//        boolean tf = false;
////        for (int i = 0; i < cardCount; i++) {
//            for (int j = 0; j < count; j++) {
//
////                System.out.println(aCard.getTrasSerials() == serial);
//                if (aCard.getTrasSerials() == aCard.getCardSerial()){
////                    System.out.println(aCard.getTrasSerials() + " " + aCard.getCardSerial());
//                 test.addElement(theTransList.getTrans(serial));
//                 tf = true;
//                } else {
////                   System.out.println(theTransList.getTrans(aCard.getCardSerial()));
////                System.out.println(aCard.getTrasSerials() + " " + aCard.getCardSerial());
//                }
//                    
////            }
//        }
////            System.out.println(tf);
//        if (aCard.getTrasSerials() == serial) {
////            TransList.setModel(test);
//          TransList.setListData(test.toArray());
////          TransList.remove(1);
//        } else {
////            int pp = listModel.getSize();
////            System.out.println(pp);
//
////        TransList.setListData(theTransList.toArray());
//        }
//    }
// REDUNDENT 
//    public void updateTranCardDetialsDisplay(int ser) {
//        
//        CardPerson UserTransList = theCardList.getTran(ser);
//        /*
//                    UserTransList.setCardTransName(null);
//            UserTransList.setCardDate(null);
//            UserTransList.setCardAmount(.00000);
//        
//        */
////        System.out.println(UserTransList.getCardTransName() != null && UserTransList.getCardDate() != null && UserTransList.getCardAmount() != .00000001 || UserTransList.getFirstTrans() == true);
//        if (UserTransList.getCardTransName() != null && UserTransList.getCardDate() != null && UserTransList.getCardAmount() != .00000001 ) {
//        String sss = UserTransList.getTranStr();
//        
//        String startingStr = "CARD NAME: " + UserTransList.getCardName() + "   " + "CARD DUE DATE: " + getSDate(UserTransList.getCardDueDate())
//                + "   " + "BANK NAME: " + UserTransList.getCardBankName()
//                + "\n_________________________________________________________________________________________\n"
//                + "                                                      Transactions\n\n";
//
//        cardInfoTextArea.setText(startingStr + sss);
//        } else {
//            return;
//        }
//        
//    }
// ALREADY FIXED ___^
    public void updateInvestDetailsDisplay() {
        expenseList.setListData(theExpenseList.toArray());
    }

    //      bank name      Visa or debit    
    // cardBankFields      cardNameFields      CardDueDateFields
    public void showCardInfo(String bank, String name, int serial) {
        updateCardDetailsDisplay();

        CardPerson aCard = theCardList.getCard(serial);

        if (aCard != null) {
//            DefaultListModel listModel = (DefaultListModel) TransList.getModel();
//            listModel.removeAllElements();   
//            updatetTransDetailsDisplay();

            String cardN = aCard.getCardName();
            cardNameFields.setText(cardN);

            String cardB = aCard.getCardBankName();
            cardBankFields.setText(cardB);

            String cardDueDate = aCard.getCardDueDate();
            CardDueDateFields.setText(cardDueDate);

            String normalStr = "CARD NAME: " + cardN + "   " + "CARD DUE DATE: " + getSDate(cardDueDate) + "   " + "BANK NAME: " + cardB;

            cardInfoTextArea.setText(normalStr);

        } else {
            cardNameFields.setText("Card not found...");
            cardBankFields.setText("Bank not found...");
        }
        updateCardDetailsDisplay();

    }

    /*
            String bN = aExp.getExpensesBankName();
            String nE = aExp.getExpensesName();
            String dE = aExp.getExpensesDate();
            String dD = aExp.getExpensesDueDate();
            double expA = aExp.getExpensesAmount();

     */
    public void showExpInfo(String bankName, String expName, String expDate, String expDueDate, double amount) throws ParseException {

        String olddueDate = getSDate(expDueDate);
        // dd,MMM.yyyy
        String olddate = getSDate(expDate);
//        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");

        expenseInfoTextArea.setText("Expense Name: " + expName + "\nBank: " + bankName
                + "\nDate When Purchase: " + olddate + "\n\nAmount: $" + amount + "\n\nDue Date: " + olddueDate);

    }

    public String getSDate(String date) {
//        System.out.println(date);
        String changingDate = date;
        String dates = "";
        String[] ag;
        ag = changingDate.split("/");

//        System.out.println(ag.length);
        String finishingStr = "";
        /*
        if month != febuary then 
        
         */
        switch (ag[0]) {
            case "01":
                finishingStr += "January ";
                dates = "January";
                break;

            case "02":
                finishingStr += "February ";
                dates = "February";
                break;

            case "03":
                finishingStr += "March ";
                dates = "March";
                break;
            case "04":
                finishingStr += "April ";
                dates = "April";
                break;

            case "05":
                finishingStr += "May ";
                dates = "May";
                break;
            case "06":
                finishingStr += "June ";
                dates = "June";
                break;
            case "07":
                finishingStr += "July ";
                dates = "July";
                break;
            case "08":
                finishingStr += "August ";
                dates = "August";
                break;
            case "09":
                finishingStr += "September ";
                dates = "September";
                break;
            case "10":
                finishingStr += "October ";
                dates = "October";
                break;

            case "11":
                finishingStr += "November ";
                dates = "November";
                break;

            case "12":
                finishingStr += "December ";
                dates = "December";
                break;

        }
        switch (ag[1]) {

            case "01":
                finishingStr += "1st, ";
                break;
            case "02":
                finishingStr += "2nd, ";
                break;
            case "03":
                finishingStr += "3rd, ";
                break;
            case "04":
                finishingStr += "4th, ";
                break;
            case "05":
                finishingStr += "5th, ";
                break;
            case "06":
                finishingStr += "6th, ";
                break;
            case "07":
                finishingStr += "7th, ";
                break;
            case "08":
                finishingStr += "8th, ";
                break;
            case "09":
                finishingStr += "9th, ";
                break;
            case "10":
                finishingStr += "10th, ";
                break;
            case "11":
                finishingStr += "11th, ";
                break;
            case "12":
                finishingStr += "12th, ";
                break;
            case "13":
                finishingStr += "13th, ";
                break;
            case "14":
                finishingStr += "14th, ";
                break;
            case "15":
                finishingStr += "15th, ";
                break;
            case "16":
                finishingStr += "16th, ";
                break;
            case "17":
                finishingStr += "17th, ";
                break;
            case "18":
                finishingStr += "18th, ";
                break;
            case "19":
                finishingStr += "19th, ";
                break;
            case "20":
                finishingStr += "20th, ";
                break;
            case "21":
                finishingStr += "21st, ";
                break;
            case "22":
                finishingStr += "22nd, ";
                break;
            case "23":
                finishingStr += "23rd, ";
                break;
            case "24":
                finishingStr += "24th, ";
                break;
            case "25":
                finishingStr += "25th, ";
                break;
            case "26":
                finishingStr += "26th, ";
                break;
            case "27":
                finishingStr += "27th, ";
                break;
            case "28":
                if (!"February".equals(dates)) {
                    finishingStr += "28th, ";
                } else {
                    finishingStr += "[Date exceeds Calendar] ";
                }
                break;
            case "29":
                if (!"February".equals(dates)) {
                    finishingStr += "29th, ";
                } else {
                    finishingStr += "[Date exceeds Calendar] ";
                }
                break;
            case "30":
                if (!"February".equals(dates)) {
                    finishingStr += "30th, ";
                } else {
                    finishingStr += "[Date exceeds Calendar] ";
                }
                break;
            case "31":
                if (!"February".equals(dates) || !"April".equals(dates) || !"June".equals(dates) || !"September".equals(dates) || !"November".equals(dates)) {
                    finishingStr += "31st, ";
                } else {
                    finishingStr += "[Date exceeds Calendar] ";
                }
                break;
        }

        finishingStr += "" + ag[2];

        return finishingStr;
    }

    public String reverseSDate(String date) {
        String changingDate = date;
        String dates = "";
        String[] ag;
        ag = changingDate.split(" ");
        String finishingStr = "";
        for (int i = 0; i < ag.length; i++) {
            System.out.println(ag[i]);
        }

        switch (ag[0]) {
            case "January":
                finishingStr += "01/";
                break;
            case "February":
                finishingStr += "02/";
                break;
            case "March":
                finishingStr += "03/";
                break;
            case "April":
                finishingStr += "04/";
                break;
            case "May":
                finishingStr += "05/";
                break;
            case "June":
                finishingStr += "06/";
                break;
            case "July":
                finishingStr += "07/";
                break;
            case "Augest":
                finishingStr += "08/";
                break;
            case "September":
                finishingStr += "09/";
                break;
            case "October":
                finishingStr += "10/";
                break;
            case "November":
                finishingStr += "11/";
                break;
            case "December":
                finishingStr += "12/";
                break;
        }

        switch (ag[1]) {
            case "1st,":
                finishingStr += "01/";
                break;
            case "2nd,":
                finishingStr += "02/";
                break;
            case "3rd,":
                finishingStr += "03/";
                break;
            case "4th,":
                finishingStr += "04/";
                break;
            case "5th,":
                finishingStr += "05/";
                break;
            case "6th,":
                finishingStr += "06/";
                break;
            case "7th,":
                finishingStr += "07/";
                break;
            case "8th,":
                finishingStr += "08/";
                break;
            case "9th,":
                finishingStr += "09/";
                break;
            case "10th,":
                finishingStr += "10/";
                break;
            case "11th,":
                finishingStr += "11/";
                break;
            case "12th,":
                finishingStr += "12/";
                break;
            case "13th,":
                finishingStr += "13/";
                break;
            case "14th,":
                finishingStr += "14/";
                break;
            case "15th,":
                finishingStr += "15/";
                break;
            case "16th,":
                finishingStr += "16/";
                break;
            case "17th,":
                finishingStr += "17/";
                break;
            case "18th,":
                finishingStr += "18/";
                break;
            case "19th,":
                finishingStr += "19/";
                break;
            case "20th,":
                finishingStr += "20/";
                break;
            case "21st,":
                finishingStr += "21/";
                break;
            case "22nd,":
                finishingStr += "22/";
                break;
            case "23rd,":
                finishingStr += "23/";
                break;
            case "24th,":
                finishingStr += "24/";
                break;
            case "25th,":
                finishingStr += "25/";
                break;
            case "26th,":
                finishingStr += "26/";
                break;
            case "27th,":
                finishingStr += "27/";
                break;
            case "28th,":
                finishingStr += "28/";
                break;
            case "29th,":
                finishingStr += "29/";
                break;
            case "30th,":
                finishingStr += "30/";
                break;
            case "31st,":
                finishingStr += "31/";
                break;
        }

        finishingStr += "" + ag[2];

        return finishingStr;
    }

    public String showPaymentCardInfo(CardPerson aCard, CardPerson[] aTran) {

        String finalStr = "";
        String tempStr = "";
        int whiteSpace = 0;
        int len = 0;
        double totalAmount = 0;

        finalStr = "NAME: " + aCard.getCardName() + "        Bank: " + aCard.getCardBankName()
                + "        Due Date: " + getSDate(aCard.getCardDueDate());
        tempStr = "\n";

        len = finalStr.length() - 13;
        whiteSpace = finalStr.length() - 13;
        for (int i = 0; i < len; i++) {
            tempStr += "_";
        }
        finalStr += tempStr;
        tempStr = "\n";
        finalStr += tempStr;
        tempStr = "";
        for (int i = 0; i < aTran.length; i++) {

            tempStr += "   -   " + aTran[i].getCardTransName() + " " + aTran[i].getCardDate() + " $" + aTran[i].getCardAmount() + ",\n";

        }
        finalStr += tempStr;
        tempStr = "\n             ";
        finalStr += tempStr;

        boolean firstTime = false;
        len = 0;
        tempStr = "";
        String sp = "";
        for (int i = 0; i < aTran.length; i++) {
            if (firstTime == false) {
                tempStr += aTran[i].getCardAmount() + "\n";
                totalAmount = aTran[i].getCardAmount();
                firstTime = true;
            } else if (firstTime == true) {
                tempStr += "           + " + aTran[i].getCardAmount() + "\n";
                totalAmount = totalAmount + aTran[i].getCardAmount();

            }
            sp = aTran[i].getCardAmount() + "";

            len += len + sp.length();
//            System.out.println(len);
        }
        finalStr += tempStr + "";
        tempStr = "           ";

        len = (len / aTran.length);
//        System.out.println(len);
        if (aTran.length < 3) {
            len = 4;
        }

        for (int i = 0; i < len; i++) {

            tempStr += "_";

        }
        tempStr += "\n";

        finalStr += tempStr;

        tempStr = "\n";
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(totalAmount);

        aCard.setPaymentAmount(totalAmount);

        tempStr = "Total:  " + moneyString;
        finalStr += tempStr;
        tempStr = "\n";
        for (int i = 0; i < whiteSpace; i++) {
            tempStr += "_";
        }
        finalStr += tempStr;
        tempStr = "\n";
        finalStr += tempStr;
        tempStr = "Payment:\n";
        finalStr += tempStr;
        tempStr = "Total Amount:           " + moneyString + "\n";
        finalStr += tempStr;

        PaymentTextArea.setText(finalStr);

        return finalStr;
    }
//    public int whiteSpace = 0;

    public String showPaymentExpInfo(ExpensePerson aExp) {

        String finalStr = "";
        String tempStr = "";
        int whiteSpace = 0;
        int len = 0;
        double totalAmount = 0;
        //                       aCard.getCardName()                aCard.getCardBankName()   aCard.getCardDueDate() 
        finalStr = "NAME: " + aExp.getExpensesName() + "        Bank: " + aExp.getExpensesBankName()
                + "        DATE: " + getSDate(aExp.getExpensesDate());
        tempStr = "\n";
        totalAmount = aExp.getExpensesAmount();
        len = finalStr.length() - 13;
        whiteSpace = finalStr.length() - 13;
        for (int i = 0; i < len; i++) {
            tempStr += "_";
        }
        finalStr += tempStr;
        tempStr = "\nDUE DATE: " + getSDate(aExp.getExpensesDueDate()) + "\n";
        for (int i = 0; i < len - 34; i++ ) {
        tempStr += "*";
        }

        finalStr += tempStr;
        tempStr = "";
//        for (int i = 0; i < aTran.length; i ++) {
//
//            tempStr += "   -   " + aTran[i].getCardTransName() + " " + aTran[i].getCardDate() + " $" + aTran[i].getCardAmount() + ",\n";
//            
//        }
        finalStr += tempStr;
        tempStr = "\n";
        finalStr += tempStr;
        aExp.setPaymentAmount(totalAmount);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(totalAmount);

        tempStr = "Amount: " + "    " + moneyString + ",        " + getSDate(aExp.getExpensesDueDate()) + "\n";

        finalStr += tempStr;
        tempStr = "";
        for (int i = 0; i < whiteSpace; i++) {
            tempStr += "_";
        }
        finalStr += tempStr;
        tempStr = "\n";

        finalStr += tempStr;
        tempStr = "Payment:\n";
        finalStr += tempStr;
        tempStr = "Amount owed:           " + moneyString + "\n";
        finalStr += tempStr;

        PaymentTextArea.setText(finalStr);

        return finalStr;
    }

    public String paymentCardUpdatesScreen(CardPerson aCard, String str) {
        double payAmount = Double.parseDouble(paymentAmount.getText());
        double overPaid = 0.0;
        String payDate = paymentDate.getText();
        String finalStr = "";
        String temp = "";
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(payAmount);
        double newTotal = aCard.getPaymentAmount();

        if (newTotal - payAmount > 0) {
            newTotal = newTotal - payAmount;
            //       Amount owed:
            temp = "Payment:                 - " + moneyString + "           " + getSDate(payDate) + "\n";
            finalStr += temp;
//               int whitespace = "Payment:           ".length();
            temp = "                                  ";
            for (int i = 0; i < 8; i++) {
                temp += "_";
            }
            finalStr += temp;
            temp = "\n";
            finalStr += temp;
            String moneyStr = formatter.format(newTotal);
            temp = "New Amount             " + moneyStr + "\n";
            finalStr += temp;

            aCard.setPaymentAmount(newTotal);

        } else if (newTotal - payAmount < 0) {
            int whiteSpace = 60;
            overPaid = payAmount - newTotal;
            String overPaidAmount = formatter.format(overPaid);
            String totalPaidAmount = formatter.format(newTotal);
            temp = "\n";
            finalStr += temp;
            temp = "";
//                   System.out.println(whiteSpace);
            for (int i = 0; i < whiteSpace; i++) {
                temp += "~";
            }
            finalStr += temp;
            temp = "\nYOU HAVE OVERPAID BY: " + overPaidAmount;
            finalStr += temp;
            temp = "\nALL YOU NEED TO PAY IS: " + totalPaidAmount + "\n";
            finalStr += temp;
            temp = "\nI ALREADY MODIFY THE AMOUNT OWED IN YOUR ACCOUNT TEXT,\nALL YOU NEED IS TO RETRY THE PAYMENT AGAIN.\n";
            finalStr += temp;
            temp = "";
            for (int i = 0; i < whiteSpace; i++) {
                temp += "~";
            }
            finalStr += temp;

            paymentAmount.setText(Double.toString(newTotal));

            /*
                       double total = 15;
                      double payment = 15.0;
                      double overpaid  = 0;

               } else if (total - payment < 0) {

             overpaid = payment - total;
    
             System.out.println("You overpayed by: " + overpaid);
         System.out.println("All you need is: " + total);
    
         } else if (total - payment == 0) {
         System.out.println("GREAT JOB YOU HAVE PAYED ALL OF YOUR TRANSACTION");
    
             }
                   
             */
        } else if (newTotal - payAmount == 0) {
            int whiteSpace = 75;
            temp = "\n";
            Format f = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = f.format(new Date());
            finalStr += temp;
            temp = "";
            for (int i = 0; i < 36; i++) {
                temp += "-";
            }// Congratulation
            temp += "CONGRATULATION";
            for (int i = 0; i < 36; i++) {
                temp += "-";
            }
            finalStr += temp;
            temp = "\nYOU HAVE COMPLETED ALL THE PAYMENT FOR THIS CARD\n" + "ON THE DATE:   " + getSDate(strDate) + "\n";
            finalStr += temp;
            temp = "";
            for (int i =0; i < whiteSpace + 25; i ++) {
            temp += "-";
            }
            finalStr += temp;

//                   temp = "Congrats on completing all your debts in " + aCard.getCardName() + " " + aCard.getCardDate();
        }

        return finalStr;
    }

    public String paymentExpsUpdatesScreen(ExpensePerson aExp, String str) {

        double payAmount = Double.parseDouble(paymentAmount.getText());
        double overPaid = 0.0;
        String payDate = paymentDate.getText();
        String finalStr = "";
        String temp = "";
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(payAmount);
        double newTotal = aExp.getPaymentAmount();

        if (newTotal - payAmount > 0) {
            newTotal = newTotal - payAmount;
            //       Amount owed:
            temp = "Payment:                 - " + moneyString + "           " + getSDate(payDate) + "\n";
            finalStr += temp;
//               int whitespace = "Payment:           ".length();
            temp = "                                  ";
            for (int i = 0; i < 8; i++) {
                temp += "_";
            }
            finalStr += temp;
            temp = "\n";
            finalStr += temp;
            String moneyStr = formatter.format(newTotal);
            temp = "New Amount             " + moneyStr + "\n";
            finalStr += temp;

            aExp.setPaymentAmount(newTotal);

        } else if (newTotal - payAmount < 0) {
            int whiteSpace = 60;
            overPaid = payAmount - newTotal;
            String overPaidAmount = formatter.format(overPaid);
            String totalPaidAmount = formatter.format(newTotal);
            temp = "\n";
            finalStr += temp;
            temp = "";
//                   System.out.println(whiteSpace);
            for (int i = 0; i < whiteSpace; i++) {
                temp += "~";
            }
            finalStr += temp;
            temp = "\nYOU HAVE OVERPAID BY: " + overPaidAmount;
            finalStr += temp;
            temp = "\nALL YOU NEED TO PAY IS: " + totalPaidAmount + "\n";
            finalStr += temp;
            temp = "\nI ALREADY MODIFY THE AMOUNT OWED IN YOUR ACCOUNT TEXT,\nALL YOU NEED IS TO RETRY THE PAYMENT AGAIN.\n";
            finalStr += temp;
            temp = "";
            for (int i = 0; i < whiteSpace; i++) {
                temp += "~";
            }
            finalStr += temp;

            paymentAmount.setText(Double.toString(newTotal));
        } else if (newTotal - payAmount == 0) {
            int whiteSpace = 75;
            temp = "\n";
            Format f = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = f.format(new Date());
            finalStr += temp;
            temp = "";
            for (int i = 0; i < 36; i++) {
                temp += "-";
            }// Congratulation
            temp += "CONGRATULATION";
            for (int i = 0; i < 36; i++) {
                temp += "-";
            }
            finalStr += temp;
            temp = "\nYOU HAVE COMPLETED ALL THE PAYMENT FOR THIS EXPENSE,\n" + "ON THE DATE:   " + getSDate(strDate) + "\n";
            finalStr += temp;
            temp = "";
            for (int i =0; i < whiteSpace + 25; i ++) {
            temp += "-";
            }
            finalStr += temp;

//                   temp = "Congrats on completing all your debts in " + aCard.getCardName() + " " + aCard.getCardDate();
        }

        return finalStr;
    }

    public void clearCardDisplay() {
//        updatePowListDisplay();
//
//        nameField.setText("");
//        RankField.setText("");
//        serialField.setText("");

    }

    public String showSaveDialog() {
        JFileChooser jfc = new JFileChooser();
        int status = jfc.showSaveDialog(this);
        if (status == JFileChooser.APPROVE_OPTION) {
            File theFile = jfc.getSelectedFile();
            String thePath = theFile.getAbsolutePath();
            return thePath;
        }
        
        return null;
    }

    public String showOpenDialog() {

        JFileChooser jfc = new JFileChooser();
        int status = jfc.showOpenDialog(this);    //showSaveDialog(this);
        if (status == JFileChooser.APPROVE_OPTION) {
            File theFile = jfc.getSelectedFile();
            String thePath = theFile.getAbsolutePath();
            return thePath;

        }

        return null;

    }
    public String[] openFiles(String pathToFile) throws IOException {
        File f = new File(pathToFile);
        Scanner kbReader = new Scanner(f);
        String str = kbReader.nextLine();
        String[] paths = str.split(" ");
//        for (int i = 0; i < paths.length; i ++) {
//        System.out.println(i);
//            System.out.println(paths[i]);
//        
//        }
        
    return paths;
    }
//    
//    public void openFromFile(String pathToFile) throws IOException {
//
//        String decryptStr = "";
//        String line = "";
//        File f = new File(pathToFile);
//        Scanner sc = new Scanner(f);
//        cardList = new CardPerson[100000];
//        cardCount = 0;
}
