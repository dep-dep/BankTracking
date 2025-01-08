/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs20models;

import java.io.IOException;

/**
 *
 * @author Harde
 */
public class UserLists {
    User[] userList;
    
    String userStr;
    
    int userCount;
    
    public UserLists() {
    
    userList = new User[100000];
    userCount = 0;
    
    }
    public User[] toArray() {
    User[] unbufferedUserList = new User[userCount];
    
    for (int i = 0; i < userCount; i++) {
    unbufferedUserList[i] = userList[i];
    }
        return unbufferedUserList;
    }
    
    public void addUser(User uu) {
    if (userCount >= userList.length) {
    return;
    }
    userList[userCount] = uu;
    userCount++;
    }

    public User getUser(String usr, String pass) {
    for (int i =0; i < userCount; i++) {
    User uu = userList[i];
    
    if (uu.getUserName().equals(usr) && uu.getPassword().equals(pass)) {
    return uu;
    
    }
    
    }
    return null;
    }

    public String getSaveString() {
    String saveStr = "";
    String encSaveStr = "";
    for (int i =0; i < userCount; i++) {
    saveStr = saveStr + userList[i].getSaveString();
    saveStr = saveStr + "\n";
    }
    encSaveStr = Encrypt(saveStr);
    
    
    return encSaveStr;
    }
    
    public String saveToFile(String pathToFile) throws IOException{
    String saveStr = this.getSaveString();
    
    return saveStr;
    }

    public void openFromFile(String pathToFile) throws IOException {
    
    }
    
//    public void openFromFile(String pathToFile) throws IOException {
//
// 
//        
//
//        cardList = new CardPerson[100000];
//        cardCount = 0;
//        
//        String line = pathToFile;
//        String str = Decrypt(line);
//        
//
//
//        String[] outter = str.split("\n");
//        String[] inside;
//
//
//        for (int i = 0; i < outter.length; i++) {
//
//            inside = outter[i].split(" ");
//
//            for (int j = inside.length - 1; j < inside.length; j++) {
//                CardPerson cc = new CardPerson();
//
//               
//                    cc.setCardName(inside[0].replace("'", " ").replace("!", " "));
//                    cc.setCardBankName(inside[1].replace("'", " ").replace("!", " "));
//                    cc.setCardDate(inside[2].replace("'", " ").replace("!", " "));
//                    cc.setCardInfo(inside[3].replace("'", " ").replace(")", "\n").replace("!", " "));
//                    cc.setCardDueDate(inside[4].replace("'", " ").replace("!", " "));
//
//
//
//                    cc.setCardName(inside[0].replace("'", " ").replace("!", " "));
//                    cc.setCardBankName(inside[1].replace("'", " ").replace("!", " "));
//                    cc.setCardDate(inside[2].replace("'", " ").replace("!", " "));
//                    cc.setCardInfo(inside[3].replace("'", " ").replace(")", "\n").replace("!", " "));
//                    cc.setCardDueDate(inside[4].replace("'", " ").replace("!", " "));
//
//                    cc.setCardTransName(inside[5].replace("'", " ").replace("!", " "));
//                    // its saying that the indext is bigger thean whats expected;
//
//                    cc.setCardAmount(Double.parseDouble(inside[6]));
//                    cc.setPaymentAmount(Double.parseDouble(inside[7]));
//                    cc.setCardSerial(Integer.parseInt(inside[8]));
//                    cc.setCardTrueFalse(Boolean.parseBoolean(inside[9]));
//                    cc.setCardTransTrueFalse(Boolean.parseBoolean(inside[10]));
//                    cc.setFirstTrans(Boolean.parseBoolean(inside[11]));
//                    cc.setSecoundGet(Boolean.parseBoolean(inside[12]));
//                    cc.setTran(Boolean.parseBoolean(inside[13]));
//                    cc.setTransTrueFalse(Boolean.parseBoolean(inside[14]));
//                    cc.setPaymentTrueFalse(Boolean.parseBoolean(inside[15]));
//                    cc.setTransCount(Integer.parseInt(inside[16]));
//                    cc.setTrasSerials(Integer.parseInt(inside[17]));
//                this.addCard(cc);
//            }
//        }
//
//    
//    }
//
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
