/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs20models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Harde
 */
public class CardList {

// Use to store every important code to be saved for the user and to be open from the users
    CardPerson[] cardList, transaction;

    String tranStr;

    int cardCount, transCount;

    public CardList() {
        cardList = new CardPerson[100000];
        this.transaction = new CardPerson[100000];
        cardCount = 0;
        transCount = 0;
        this.tranStr = "";

    }

    public CardPerson[] toArray() {
        CardPerson[] unBufferedCardList = new CardPerson[cardCount];

        for (int i = 0; i < cardCount; i++) {
            unBufferedCardList[i] = cardList[i];

        }

        return unBufferedCardList;
    }

    public void addCard(CardPerson up) {
        if (cardCount >= cardList.length) {
            return;
        }
        cardList[cardCount] = up;
        cardCount++;
        // tansaction[transCount] = the new transaction
    }

//    public void getCard(CardPerson cc) {
////        System.out.println("MINE COUNT  " + serial);
////        System.out.println("CARD PERSON COUNT " +cardCount);
//        
//        for (int i = 0; i < cardCount; i++) {
//
//    if (cardCount >= cardList.length) {
//    return;
//    }   
//    cardList[cardCount] =cc;
//    cardCount++;
//    
//}
//    }
    public CardPerson getCard(int ser) {
//        System.out.println("MINE COUNT  " + serial);
//        System.out.println("CARD PERSON COUNT " +cardCount);

//        for (int i = 0; i < cardCount; i++) {
//
//    if (cardCount >= cardList.length) {
//    return;
//    }   
//    cardList[cardCount] =cc;
//    cardCount++;
//    
        for (int i = 0; i < cardCount; i++) {
            CardPerson cc = cardList[i];

            if (cc.getCardSerial() == ser) {

                return cc;
            }

        }
        return null;

    }

    public String getSaveString() {
        String saveStr = "";
        String encSaveStr = "";
        for (int i = 0; i < cardCount; i++) {
            saveStr = saveStr + cardList[i].getSaveString();
            saveStr = saveStr + "\n";
        }
//        System.out.println(saveStr);
        encSaveStr = Encrypt(saveStr);

//        String saveStr = "";
//        for (int i = 0; i < powCount; i++) {
//            saveStr = saveStr + powList[i].getSaveString();
//            saveStr = saveStr + "\n";
//        }
//        return saveStr;
        return encSaveStr;
    }

    public String saveToFile(String pathToFile) throws IOException {
//        FileWriter fw = new FileWriter(pathToFile);
//        PrintWriter pw = new PrintWriter(fw);
        String saveStr = this.getSaveString();
//        System.out.println(saveStr);
        return saveStr;
//        pw.print(saveStr);
//        pw.close();
//    FileWriter fw = new FileWriter(pathToFile);
//    PrintWriter pw = new PrintWriter(fw);
//    String saveStr = this.getSaveString();
//    pw.print(saveStr);
//    pw.close();

    }

    public void openFromFile(String pathToFile) throws IOException {

 
        
//        File f = new File(pathToFile);
//        Scanner sc = new Scanner(f);
        cardList = new CardPerson[100000];
        cardCount = 0;
        
        String line = pathToFile;
        String str = Decrypt(line);
        
//        line = sc.nextLine();
        
        
        
//        decryptStr = Decrypt(line);

        String[] outter = str.split("\n");
        String[] inside;

//        System.out.println(decryptStr);
//        System.out.println(outter.length);

//        System.out.println(str);
        for (int i = 0; i < outter.length; i++) {
//            System.out.println(i);
            inside = outter[i].split(" ");
//            System.out.println("-------------");
//            System.out.println(inside[5]);
//            System.out.println("-------------");

//             System.out.println(decryptStr);
            for (int j = inside.length - 1; j < inside.length; j++) {
                CardPerson cc = new CardPerson();
//                System.out.println("Hello" + j);
//                if (inside.length == 4) {
//                    System.out.println(inside[0]);
//                    System.out.println(inside[1]);
//                    System.out.println(inside[2]);
//                    System.out.println(inside[3]);
//                    System.out.println(inside[4]);
//                    
                    cc.setCardName(inside[0].replace("'", " ").replace("!", " "));
                    cc.setCardBankName(inside[1].replace("'", " ").replace("!", " "));
                    cc.setCardDate(inside[2].replace("'", " ").replace("!", " "));
                    cc.setCardInfo(inside[3].replace("'", " ").replace(")", "\n").replace("!", " "));
                    cc.setCardDueDate(inside[4].replace("'", " ").replace("!", " "));

//                } else if (inside.length == 17) {

                    cc.setCardName(inside[0].replace("'", " ").replace("!", " "));
                    cc.setCardBankName(inside[1].replace("'", " ").replace("!", " "));
                    cc.setCardDate(inside[2].replace("'", " ").replace("!", " "));
                    cc.setCardInfo(inside[3].replace("'", " ").replace(")", "\n").replace("!", " "));
                    cc.setCardDueDate(inside[4].replace("'", " ").replace("!", " "));

                    cc.setCardTransName(inside[5].replace("'", " ").replace("!", " "));
                    // its saying that the indext is bigger thean whats expected;

                    cc.setCardAmount(Double.parseDouble(inside[6]));
                    cc.setPaymentAmount(Double.parseDouble(inside[7]));
                    cc.setCardSerial(Integer.parseInt(inside[8]));
                    cc.setCardTrueFalse(Boolean.parseBoolean(inside[9]));
                    cc.setCardTransTrueFalse(Boolean.parseBoolean(inside[10]));
                    cc.setFirstTrans(Boolean.parseBoolean(inside[11]));
                    cc.setSecoundGet(Boolean.parseBoolean(inside[12]));
                    cc.setTran(Boolean.parseBoolean(inside[13]));
                    cc.setTransTrueFalse(Boolean.parseBoolean(inside[14]));
                    cc.setPaymentTrueFalse(Boolean.parseBoolean(inside[15]));
                    cc.setTransCount(Integer.parseInt(inside[16]));
                    cc.setTrasSerials(Integer.parseInt(inside[17]));
//                }
                this.addCard(cc);
            }
        }

        /*

        this.transCount = 0;
        this.transSerials = 0;
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
        
         */
        // orignal
//               String decryptStr = "";
//        String line = "";
//        File f = new File(pathToFile);
//        Scanner sc = new Scanner(f);
//        cardList = new CardPerson[1000000000];
//        cardCount = 0;
//
//        line = sc.nextLine();
//        decryptStr = Decrypt(line);
//        String[] outter = decryptStr.split("\n");
//        String[] inside;
//        for (int i = 0; i < outter.length; i++) {
//            inside = outter[i].split(" ");
//
//            CardPerson cc = new CardPerson();
//            cc.setCardName(inside[0].replace("'", " "));
//            cc.setCardBankName(inside[1].replace("'", " "));
//            cc.setCardDate(inside[2].replace("'", " "));
//            cc.setCardInfo(inside[3].replace("'", " ").replace(")", "\n"));
//            cc.setCardDueDate(inside[4].replace("'", " "));
//            cc.setCardTransName(inside[5].replace("'", " "));
////                cc.setTranStr(line, line, cardCount, true, true);
//            cc.setCardAmount(Double.parseDouble(inside[6]));
//            cc.setPaymentAmount(Double.parseDouble(inside[7]));
//            cc.setCardSerial(Integer.parseInt(inside[8]));
//            cc.setCardTrueFalse(Boolean.parseBoolean(inside[9]));
//            cc.setCardTransTrueFalse(Boolean.parseBoolean(inside[10]));
//            cc.setFirstTrans(Boolean.parseBoolean(inside[11]));
//            cc.setSecoundGet(Boolean.parseBoolean(inside[12]));
//            cc.setTran(Boolean.parseBoolean(inside[13]));
//            cc.setTransTrueFalse(Boolean.parseBoolean(inside[14]));
//            cc.setPaymentTrueFalse(Boolean.parseBoolean(inside[15]));
//            cc.setTransCount(Integer.parseInt(inside[16]));
//            cc.setTrasSerials(Integer.parseInt(inside[17]));
//            this.addCard(cc);
//
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
