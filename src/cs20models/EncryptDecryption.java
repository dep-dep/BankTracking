/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs20models;

/**
 *
 * @author 105243003
 */
public class EncryptDecryption {
    
    public String Encrypt(String str) {
    String chipherString = str;
    String newStr = "";
    
    char[] chipherText = new char[chipherString.length()];
    for (int i = 0; i < chipherString.length(); i++) {
    chipherText[i] = chipherString.charAt(i);
    }
    
    for (int j = 0; j < chipherText.length; j ++) {
    chipherText[j] = (char) ((int)chipherText[j] + 13);
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
    
    for (int j = 0; j < decrptText.length; j ++) {
    decrptText[j] = (char) ((int)decrptText[j] - 13);
    oldStr += decrptText[j];
    }
    
    
    return oldStr;
    }
    
    
}
