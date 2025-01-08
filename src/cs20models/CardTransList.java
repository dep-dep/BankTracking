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
 */
public class CardTransList {

    CardPerson[] transList, transaction, temp;

    int transCount;

    public CardTransList() {
        transList = new CardPerson[1000000];
        temp = new CardPerson[1000000];
        transCount = 0;

    }

    public CardPerson[] toArray() {
        CardPerson[] unBufferedTransList = new CardPerson[transCount];
        for (int i = 0; i < transCount; i++) {
            unBufferedTransList[i] = transList[i];
        }
        return unBufferedTransList;
    }

    public void addTrans(CardPerson up) {
        if (transCount >= transList.length) {
            return;
        }
        transList[transCount] = up;
        transCount++;

    }

    public CardPerson getTrans(int ser) {
        for (int i = 0; i < transCount; i++) {
            CardPerson cc = transList[i];
            if (cc.getCardSerial() == ser) {
                return cc;
            }

        }
        return null;
    }

    public CardPerson[] getMutiTrans(int ser) {
        int count = 0;
        for (int i = 0; i < transCount; i++) {
            CardPerson cc = transList[i];
            if (cc.getCardSerial() == ser) {
                temp[count] = cc;
                count++;
            }
        }
        CardPerson[] pp = new CardPerson[count];
        System.arraycopy(temp, 0, pp, 0, count);
        return pp;
    }

//    public CardPerson getMutiTrans(int ser) {
//    
//    int count = 0;
//    for (int i = 0; i < transCount; i++) {
//    CardPerson cc = transList[i];
//    if (cc.getCardSerial() == ser) {
//    temp[count] = cc;
//    count++;
//    
//    }
//    
//    }
//    return temp[1];
//        
//    }
    public String getSaveString() {
        String saveStr = "";
        String encSaveStr = "";
        for (int i = 0; i < transCount; i++) {
            saveStr = saveStr + transList[i].getSaveString();
            saveStr = saveStr + "\n";
        }
        encSaveStr = Encrypt(saveStr);

        return encSaveStr;
    }

    public String saveToFile(String pathToFile) throws IOException {
//        FileWriter fw = new FileWriter(pathToFile);
//        PrintWriter pw = new PrintWriter(fw);
        String saveStr = this.getSaveString();
//        pw.print(saveStr);
//        System.out.println(saveStr);
        return saveStr;
//        pw.close();
//    FileWriter fw = new FileWriter(pathToFile);
//    PrintWriter pw = new PrintWriter(fw);
//    String saveStr = this.getSaveString();
//    pw.print(saveStr);
//    pw.close();

    }

    public void openFromFile(String pathToFile) throws IOException {
//        System.out.println("HELLO");
//        String decryptStr = "";
//        String line = "s";
//        File f = new File(pathToFile);
        transList = new CardPerson[1000000];
        transCount = 0;
//        Scanner sc = new Scanner(f);
        String line = pathToFile;
        String str = Decrypt(line);
//        line = sc.nextLine();
//        decryptStr = Decrypt(line);
        String[] outter = str.split("\n");
        String[] inside;
        /*

        this.transCount = 0;
        this.transSerials = 0;
 
        
         */
//        System.out.println(str);
        for (int i = 0; i < outter.length; i++) {
            inside = outter[i].split(" ");

            for (int j = inside.length - 1; j < inside.length; j++) {
//                 System.out.println(j);
                CardPerson cc = new CardPerson();
//                if (inside.length == 4) {
//                    System.out.println(inside[0]);
//                    System.out.println(inside[1]);
//                    System.out.println(inside[2]);
//                    System.out.println(inside[3]);
//                    System.out.println(inside[4]);
         
                cc.setCardName(inside[0].replace("'", " ").replace("!", " "));
                cc.setCardBankName(inside[1].replace("'", " ").replace("!", " "));
                cc.setCardDate(inside[2].replace("'", " ").replace("!", " "));
                cc.setCardInfo(inside[3].replace("'", " ").replace(")", "\n").replace("!", " "));
                cc.setCardDueDate(inside[4].replace("'", " ").replace("!", " "));

//                } else if (inside.length == 17) {
                cc.setCardName(inside[0].replace("'", " "));
                cc.setCardBankName(inside[1].replace("'", " "));
                cc.setCardDate(inside[2].replace("'", " "));
                cc.setCardInfo(inside[3].replace("'", " "));
                cc.setCardDueDate(inside[4].replace("'", " "));
                cc.setCardTransName(inside[5].replace("'", " "));
//                cc.setTranStr(line, line, cardCount, true, true);
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
//                System.out.println(cc.getCardName());

//                         }
                this.addTrans(cc);
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
