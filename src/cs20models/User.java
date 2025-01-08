/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs20models;

/**
 *
 * @author Harde
 */
public class User {

    private String username, password, cardInfo, expenseInfo, transactionInfo;

    public User() {
        this.username = "";
        this.password = "";
        this.cardInfo = "";
        this.expenseInfo = "";
        this.transactionInfo = "";

    }

    public String getUserName() {
        return this.username;
    }

    public void setUserName(String str) {
        this.username = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getCardInfo() {
        return this.cardInfo;
    }

    public void setCardInfo(String str) {
        this.cardInfo = str;
    }

    public String getExpenseInfo() {
        return this.expenseInfo;
    }

    public void setExpenseInfo(String str) {
        this.expenseInfo = str;
    }

    public String getTransactionInfo() {
        return this.transactionInfo;
    }

    public void setTransactionInfo(String str) {
        this.transactionInfo = str;
    }
    public String getSaveString() {
        
    String str = "";
    
    
    return str;
    }
    
}
