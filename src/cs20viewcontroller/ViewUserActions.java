/*
 * The controller classes (like the ViewUserActions class) provides actions
 * that the user can trigger through the view classes.  Those actions are 
 * written in this class as private inner classes (i.e. classes 
 * declared inside another class).
 *
 * You can use all the public instance variables you defined in AllModelsForView, 
 * DrawnView, and ViewOutputs as though they were part of this class! This is 
 * due to the magic of subclassing (i.e. using the extends keyword).
 */
package cs20viewcontroller;

import cs20models.CardPerson;
import cs20models.ExpenseList;
import cs20models.ExpensePerson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.DefaultListModel;

/**
 * ViewUserActions is a class that contains actions users can trigger.
 *
 * User actions are written as private inner classes that implements the
 * ActionListener interface. These actions must be "wired" into the DrawnView in
 * the ViewUserActions constructor, or else they won't be triggered by the user.
 *
 * Actions that the user can trigger are meant to manipulate some model classes
 * by sending messages to them to tell them to update their data members.
 *
 * Actions that the user can trigger can also be used to manipulate the GUI by
 * sending messages to the view classes (e.g. the DrawnView class) to tell them
 * to update themselves (e.g. to redraw themselves on the screen).
 *
 * @author cheng
 */
public class ViewUserActions extends ViewOutputs {

    /*
     * Step 1 of 2 for writing user actions.
     * -------------------------------------
     *
     * User actions are written as private inner classes that implement
     * ActionListener, and override the actionPerformed method.
     *
     * Use the following as a template for writting more user actions.
     */
    public boolean ttf = false;

    private class GetCardInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
                
//            TransList.setListData(new Vector());
            //   int serial, int transcount, int cardCount {
//            System.out.println(tempSerial + "      "+transCount + "   "+count);
//            updatetTransDetailsDisplay(tempSerial, transCount, count);
            Object cardObj = cardList.getSelectedValue();
            CardPerson aCard = (CardPerson) cardObj;
            String cardB = aCard.getCardBankName();
            String cardN = aCard.getCardName();
            int cardS = aCard.getCardSerial();
            tempSerial = cardS;
            CardPerson aTrans = theTransList.getTrans(cardS);
//            System.out.println();
//            TransList.removeAll();
//            if (theTransList != null) {
//            checkTooSeeTrans(cardS);
//            }
//             int serial, int count, int cardCount

            if (ttf == false) {
                showCardInfo(cardB, cardN, cardS);

                ttf = true;
            }

//            System.out.println("CardSerial From Transaction: " +  aTrans.getCardSerial());
//            System.out.println();
//            System.out.println("TransSerial From Transactions: " +aTrans.getTrasSerials());
//            System.out.println();
//            System.out.println("CardSerial From Card: " +  aCard.getCardSerial());
//            System.out.println();
//            System.out.println("TransSerial From Card: " +aCard.getTrasSerials());
//            System.out.println();
//            System.out.println("-------------------------------------------------------");
//            for (int i =0; i< 10; i ++) {
//            System.out.println(transCount);
//            }
//            System.out.println();
//            for (int i =0; i< 10; i ++) {
//            System.out.println(tempSerial);
//            }
//            System.out.println();
//            for (int i =0; i< 10; i ++) {
//            System.out.println(  aCard.getTrasSerials());
//            }
//            for (int i =0; i< 10; i ++) {
//            System.out.println( aCard.getTrasSerials() == tempSerial );
//            }
            DefaultListModel test = new DefaultListModel();
            CardPerson[] temp;
             
            if (aCard.getTrasSerials() == aTrans.getTrasSerials()) {

                temp = theTransList.getMutiTrans(tempSerial);
//    System.out.println(theTransList.getTrans(tempSerial) + " " + tempSerial);            
//            System.out.println("_______________________________________________");

                for (int i = 0; i < temp.length; i++) {
//        test.elementAt(temp[i]);
//System.out.println(temp[i]);
                    test.addElement(temp[i]);

                }
                TransList.setListData(test.toArray());

            
        }
            showCardInfo(cardB, cardN, cardS);

        }
    }

    private class UpdateCardTransInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // just
//            Object cardObj = cardList.getSelectedValue();
//            CardPerson aCard = (CardPerson) cardObj;
//            String cardB = aCard.getCardBankName();
//            String cardN = aCard.getCardName();
//            int cardS = aCard.getCardSerial();

//            CardPerson UserTransList = theCardList.getCard(tempSerial);
//            System.out.println("Card Name : " + UserTransList.getCardName());
//            System.out.println("Card Bank :" + UserTransList.getCardBankName());
//            System.out.println("Card Due Date :" + UserTransList.getCardDueDate());
//            System.out.println("Card Trans Name : " + UserTransList.getCardTransName());
//            System.out.println("Card  Date : " + UserTransList.getCardDate());
//            System.out.println("Card AMount : " + UserTransList.getCardAmount());
//            updateTranCardDetialsDisplay(tempSerial);
//            Object powObj = powList.getSelectedValue();
//            CardPerson aPow = (CardPerson) powObj;
//            int serial = aPow.getSerial();
//
//            showPowInfo(serial);
        }
    }
    public int count = 0;

    public int cardCount = 0;

    public int transCount = 0;

    public int tempSerial = 0;

    private class AddNewCardInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            TransList.setListData(new Vector());
            CardPerson UserCardList = new CardPerson();

            UserCardList.setCardSerial(count);

            String cardName = cardNameFields.getText();
            UserCardList.setCardName(cardName);

            String cardBank = cardBankFields.getText();
            UserCardList.setCardBankName(cardBank);

            String cardDueDate = CardDueDateFields.getText();
            UserCardList.setCardDueDate(cardDueDate);

            UserCardList.setTrasSerials(count);

            for (int i = 0; i < 10; i++) {
//            System.out.println(count);
//            System.out.println(UserCardList.getTrasSerials());

            }

            /*
            add a count for the Trans serial by adding a public in varbale and using that;
            
            
             */
            UserCardList.setCardTrueFalse(true);

            theCardList.addCard(UserCardList);

            updateCardDetailsDisplay();

            count++;
//            System.out.println("In the add new card info: " + tempSerial);
        }
    }

    private class AddNewTransInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            for (int i = 0; i < 10; i++) {
//                System.out.println(tempSerial + " >>>>>>");
            }

            CardPerson aTrans = new CardPerson();
            CardPerson aCard = theCardList.getCard(tempSerial);

            if (aCard.getCardSerial() == tempSerial) {
                int precount = aTrans.getTransCount();
                if (aTrans.getTran() == false) {
                    aTrans.setTransCount(precount);
                    aTrans.setTran(true);

                }
                if (aTrans.getTran() == true) {
                    aTrans.setTransCount(precount + 1);

                }
                transCount++;
                String cardTrasName = cardTransFields.getText();
                aTrans.setCardTransName(cardTrasName);

                String cardDateOf = cardTransDateFields.getText();
                aTrans.setCardDate(getSDate(cardDateOf));

                String cardAmount = cardTransAmountFields.getText();

                aTrans.setCardAmount(Double.valueOf(cardAmount));

                aTrans.setTransTrueFalse(true);

                aTrans.setCardSerial(aCard.getCardSerial());

//            System.out.println(cardCount <= count);
                if (cardCount <= count) {

                    cardCount++;
                }

                aTrans.setTrasSerials(aCard.getTrasSerials());

                theTransList.addTrans(aTrans);

//            for (int l = 0; l < 10; l++) {
//            System.out.println(TransList.getTrasSerials() == tempSerial);
//            }
                CardPerson theTrans = theTransList.getTrans(aCard.getCardSerial());

                DefaultListModel test = new DefaultListModel();
                CardPerson[] temp;

                if (aCard.getTrasSerials() == theTrans.getTrasSerials()) {

                    temp = theTransList.getMutiTrans(tempSerial);
//    System.out.println(theTransList.getTrans(tempSerial) + " " + tempSerial);            
//            System.out.println("_______________________________________________");

                    for (int i = 0; i < temp.length; i++) {
//        test.elementAt(temp[i]);
//System.out.println(temp[i]);
                        test.addElement(temp[i]);

                    }
                    TransList.setListData(test.toArray());

                }

//                updatetTransDetailsDisplay(tempSerial, transCount, count);
//            System.out.println(tempSerial);
//            System.out.println(transCount);
//
            }

        }
    }
    // UserInvestmentList
    // expensestf

    private class AddNewExpensesInfo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            ExpensePerson UserInvestmentList = new ExpensePerson();

            // invest name
            String investName = expenseNameFields.getText();
            UserInvestmentList.setExpensesName(investName);

            // invest bank
            String investBank = expenseBankFields.getText();
            UserInvestmentList.setExpensesBankName(investBank);

            // investment due date  
            String investDueDate = expenseDueDateFields.getText();
            UserInvestmentList.setExpensesDueDate(investDueDate);

            // Amount         
            String investAmount = expenseAmountFields.getText();
            double i = Double.parseDouble(investAmount);
            UserInvestmentList.setExpensesAmount(i);

            //Investment date
            String investDate = expenseDateFields.getText();
            UserInvestmentList.setExpensesDate(investDate);

            UserInvestmentList.setExpensesTrueFalse(true);

            theExpenseList.addExpense(UserInvestmentList);

            updateInvestDetailsDisplay();

        }
    }
    public Object tempExpensListes = null;

    private class getExpensesInfoAction implements ActionListener {

        //expenseInfoTextArea
        @Override
        public void actionPerformed(ActionEvent ae) {
            Object expenseObj = expenseList.getSelectedValue();
            ExpensePerson aExp = (ExpensePerson) expenseObj;
            String bN = aExp.getExpensesBankName();
            String nE = aExp.getExpensesName();
            String dE = aExp.getExpensesDate();
            String dD = aExp.getExpensesDueDate();
            double expA = aExp.getExpensesAmount();

            tempExpensListes = aExp;

            try {
                showExpInfo(bN, nE, dE, dD, expA);
//            Object cardObj = cardList.getSelectedValue();
//            CardPerson aCard = (CardPerson) cardObj;
//            String cardB = aCard.getCardBankName();
//            String cardN = aCard.getCardName();
//            int cardS = aCard.getCardSerial();
//            tempSerial = cardS;
//
////            System.out.println("HI HOW are yo " + aCard.getCardSerial());
//            showCardInfo(cardB, cardN, cardS);
            } catch (ParseException ex) {
                Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    // Later if their is anytime
    private class updateExpenseInfo implements ActionListener {

        //expenseInfoTextArea
        @Override
        public void actionPerformed(ActionEvent ae) {

            ExpensePerson aExp = (ExpensePerson) tempExpensListes;
            String expBank = aExp.getExpensesBankName();
            String expName = aExp.getExpensesName();
            String expDate = aExp.getExpensesDate();
            String expDueDate = aExp.getExpensesDueDate();
            double expAmount = aExp.getExpensesAmount();

            aExp.setExpensesBankName(expBank);
            aExp.setExpensesName(expName);
            aExp.setExpensesDate(expDate);
            aExp.setExpensesDueDate(expDueDate);
            aExp.setExpensesAmount(expAmount);

            updateInvestDetailsDisplay();
            try {
                showExpInfo(expBank, expName, expDate, expDueDate, expAmount);
            } catch (ParseException ex) {
                Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println(aExp.getExpensesBankName());
            System.out.println(aExp.getExpensesName());
            System.out.println(aExp.getExpensesDate());
            System.out.println(aExp.getExpensesDueDate());
            System.out.println(aExp.getExpensesAmount() + "");

        }
    }

    public int tempTrans = 0;

    private class getTransInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

//            Object cardObj = cardList.getSelectedValue();
//            CardPerson aCard = (CardPerson) cardObj;
//            String cardB = aCard.getCardBankName();
//            String cardN = aCard.getCardName();
//            int cardS = aCard.getCardSerial();
//            tempSerial = cardS;
//            CardPerson aTrans = theTransList.getTrans(cardS);
            Object TransObj = TransList.getSelectedValue();
            CardPerson aTrans = (CardPerson) TransObj;

            tempTrans = aTrans.getTrasSerials();

            String transN = aTrans.getCardTransName();
            String transD = aTrans.getCardDate();
            double transA = aTrans.getCardAmount();
//            System.out.println(transN);
//            System.out.println(transD);
//            System.out.println("" + transA);
            String oldDate = reverseSDate(transD);

            cardTransFields.setText(transN);
            cardTransDateFields.setText(oldDate);
            cardTransAmountFields.setText(Double.toString(transA));

            /*
            cardTransFields
            cardTransDateFields
            cardTransAmountFields
            
             */
        }
    }

    private class updateTransInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            CardPerson aTrans = theTransList.getTrans(tempTrans);

            String cardTrasName = cardTransFields.getText();
            aTrans.setCardTransName(cardTrasName);

            String cardDateOf = cardTransDateFields.getText();
            aTrans.setCardDate(getSDate(cardDateOf));

            String cardAmount = cardTransAmountFields.getText();

            aTrans.setCardAmount(Double.valueOf(cardAmount));

            CardPerson aCard = theCardList.getCard(tempSerial);

            CardPerson theTrans = theTransList.getTrans(aCard.getCardSerial());

            DefaultListModel test = new DefaultListModel();
            CardPerson[] temp;

            if (aCard.getTrasSerials() == theTrans.getTrasSerials()) {

                temp = theTransList.getMutiTrans(tempSerial);
//    System.out.println(theTransList.getTrans(tempSerial) + " " + tempSerial);            
//            System.out.println("_______________________________________________");

                for (int i = 0; i < temp.length; i++) {
//        test.elementAt(temp[i]);
//System.out.println(temp[i]);
                    test.addElement(temp[i]);

                }
                TransList.setListData(test.toArray());

            }

        }
    }

    public String cardExpense = "";

    private class getCardsPaymentInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            paymentList.setListData(theCardList.toArray());
            cardExpense = "Card";
        }
    }

    private class getExpensesPaymentInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            paymentList.setListData(theExpenseList.toArray());
            cardExpense = "Expense";

        }
    }

    public String paymentStr = "";
    public CardPerson aCards = null;
    public ExpensePerson aExps = null;

    private class getCardOrExpensePaymentInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String str = "";

            if (cardExpense.equals("Card")) {
                Object cardObj = paymentList.getSelectedValue();
                CardPerson aCard = (CardPerson) cardObj;
                aCards = aCard;

                if (aCard.getPaymentTrueFalse() == false) {

//            String cardB = aCard.getCardBankName();
//            String cardN = aCard.getCardName();
                    int cardS = aCard.getCardSerial();
                    tempSerial = cardS;
                    CardPerson aTrans = theTransList.getTrans(cardS);

                    CardPerson[] trans;

                    if (aCard.getTrasSerials() == aTrans.getTrasSerials()) {

                        trans = theTransList.getMutiTrans(tempSerial);

                        str = showPaymentCardInfo(aCard, trans);

                    }
                } else if (aCard.getPaymentTrueFalse() == true) {
                    PaymentTextArea.setText(aCard.getCardInfo());
                }
            } else if (cardExpense.equals("Expense")) {
                Object expenseObj = paymentList.getSelectedValue();
                ExpensePerson aExp = (ExpensePerson) expenseObj;
                aExps = aExp;
                if (aExp.getPaymentTrueFalse() == false) {
                    str = showPaymentExpInfo(aExp);
                } else if (aExp.getPaymentTrueFalse() == true) {
                    PaymentTextArea.setText(aExp.getExpensesInfo());
                }

            }

            paymentStr = str;

//            paymentList.setListData(theExpenseList.toArray());
//            cardExpense = "Expense";
        }
    }

    private class getSetPaymentInfoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (cardExpense.equals("Card")) {
                if (aCards.getPaymentTrueFalse() == false) {
                    aCards.setPaymentTrueFalse(true);
                    String allpayment = paymentCardUpdatesScreen(aCards, paymentStr);
                    paymentStr += allpayment;
                    PaymentTextArea.setText(paymentStr);

                } else if (aCards.getPaymentTrueFalse() == true) {
                    String allpayment = paymentCardUpdatesScreen(aCards, paymentStr);
                    String lastStr = aCards.getCardInfo();
                    lastStr += allpayment;
                    PaymentTextArea.setText(lastStr);
                    paymentStr = lastStr;
                }

                //paymentAmount
                //paymentDate
                aCards.setCardInfo(paymentStr);
            } else if (cardExpense.equals("Expense")) {
                if (aExps.getPaymentTrueFalse() == false) {
                    aExps.setPaymentTrueFalse(true);
                    String allpayment = paymentExpsUpdatesScreen(aExps, paymentStr);
                    paymentStr += allpayment;
                    PaymentTextArea.setText(paymentStr);
                } else if (aExps.getPaymentTrueFalse() == true) {
                    String allpayment = paymentExpsUpdatesScreen(aExps, paymentStr);
                    String lastStr = aExps.getExpensesInfo();
                    lastStr += allpayment;
                    PaymentTextArea.setText(lastStr);
                    paymentStr = lastStr;
                }
                aExps.setExpensesInfo(paymentStr);
            }
        }
    }

    private class OpenFileAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String pathToFile = showOpenDialog();
                if (pathToFile == null) {
                }
                
                String[] path = openFiles(pathToFile);
                String str = path[0];
                
                theCardList.openFromFile(str);
                
                str = path[1];
                
                theTransList.openFromFile(str);
                
                str = path[2];
                
                theExpenseList.openFromFile(str);
//                
//                theCardList.openFromFile(paths[0]);
//                theTransList.openFromFile(paths[1]);
//                theExpenseList.openFromFile(paths[2]);

// theCardList  theTransList  theExpenseList
            } catch (IOException ex) {
                Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
            }

//            try {
//                String pathToFile = showOpenDialog();
//                if (pathToFile == null) {
//                    return;
//                }
//            "C:\Users\Harde\Downloads"
//            thePowList.saveToFile(pathToFile);
//                thePowList.openFromFile(pathToFile);
//            } catch (IOException ex) {
//                Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
//            }   
        }
    }

    private class SaveToFileAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String pathToFile = showSaveDialog();
                if (pathToFile == null) {
                    return;
                }
                String saveStr = "";
                String aCardString = theCardList.saveToFile(pathToFile);
                String aTransString = theTransList.saveToFile(pathToFile);
                String aExpenseString = theExpenseList.saveToFile(pathToFile);
                saveStr = aCardString + " " + aTransString + " " + aExpenseString;
                
                        FileWriter fw = new FileWriter(pathToFile);
                        PrintWriter pw = new PrintWriter(fw);

                        pw.print(saveStr);
                        pw.close();


            } catch (IOException ex) {
                Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);

            }

            // updateScreen();
            
            
            
            
            // theCardList  theTransList  theExpenseList
//            try {
//                String pathToFile = showSaveDialog();
//                if (pathToFile == null) {
//                    return;
//                }
//
//                //"C:\Users\Harde\Downloads"
//                thePowList.saveToFile(pathToFile);
//            } catch (IOException ex) {
//                Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    private class refreshScreenAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
     updateScreen();
        }
    }
    /*
     * ViewUserActions constructor used for wiring user actions to GUI elements
     */
    public ViewUserActions() {
        /*
         * Step 2 of 2 for writing user actions.
         * -------------------------------------
         *
         * Once a private inner class has been written for a user action, you
         * can wire it to a GUI element (i.e. one of GUI elements you drew in
         * the DrawnView class and which you gave a memorable public variable
         * name!).
         *
         * Use the following as a template for wiring more user actions.
         */
        this.getCardInfo.addActionListener(new GetCardInfoAction());
        this.addCardButton.addActionListener(new AddNewCardInfo());
        this.addExpense.addActionListener(new AddNewExpensesInfo());
        this.addCardTran.addActionListener(new AddNewTransInfo());
        this.getExpenseDetail.addActionListener(new getExpensesInfoAction());
        this.paymentCardInfoButton.addActionListener(new getCardsPaymentInfoAction());
        this.paymentExpenseInfoButton.addActionListener(new getExpensesPaymentInfoAction());
        this.getTransButton.addActionListener(new getTransInfoAction());
        this.updateCardTran.addActionListener(new updateTransInfoAction());
        this.paymentShowInfo.addActionListener(new getCardOrExpensePaymentInfoAction());
        this.setPayment.addActionListener(new getSetPaymentInfoAction());
        this.openButton.addActionListener(new OpenFileAction());
        this.saveButton.addActionListener(new SaveToFileAction());
        this.refreshScreen.addActionListener(new refreshScreenAction());
        //saveButton
        //openButton
//        this.updateCardTran.addActionListener(new UpdateCardTransInfoAction());

//        this.paymentCardInfoButton.addActionListener(new getCardsPaymentInfoAction());
//        this.paymentExpenseInfoButton.addActionListener(new getExpensesPaymentInfoAction());
//        this.getPowButton.addActionListener(new GetPowInfoAction());
//        this.setPowInfoButton.addActionListener(new SetPowInfoAction());
//        this.clearButton.addActionListener(new ClearPowDisplayAction());
//        this.saveButton.addActionListener(new SaveToFileAction());
//        this.openButton.addActionListener(new OpenFileAction());
    }
}
