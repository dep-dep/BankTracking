package cs20models;

/**
 * A class to model the problem or situation your program solves
 *
 * @author cheng
 */
public class CardPerson {

// Getters and setters                                                        When it's purchance, When it's purchance, 
    // Ex. Visa,    Toyota,         Connect First,  TD Bank,          04/06/2023,       , 06/24/2024,         
    //                                                                                                 , Places it all within one String For an easy encrypt and decrept     
    // ONLY FOR CARD PEROSNS!!!!!!!!!!!!!!!!!!!!!!!
    private String cardName, cardBankName, cardDate, cardInfo,
            cardDueDate, cardTransName 
            /*tranStr*/;

    private double cardAmount, paymentAmount;
    private int cardSerial, cardCount, transCount, transSerials;

    private boolean cardtf, cardTranstf, firstTrans, secoundGet, trans, transtf, paymenttf;

    public CardPerson() {

        this.cardName = "!";
        this.cardBankName = "!";
        this.cardDate = "!";
        this.cardInfo = "!";
        this.cardDueDate = "!";
        this.cardTransName = "!";
//        this.tranStr = "";
        this.cardAmount = 0.0;
        this.paymentAmount = 0.0;
        this.cardSerial = 0;
        this.cardtf = false;
        this.cardTranstf = false;
        this.firstTrans = false;
        this.secoundGet = false;
        this.trans = false;
        this.transtf = false;
        this.paymenttf = false;
//        cardCount = 0;
        this.transCount = 0;
        this.transSerials = 0;

    }

    public String getCardName() {
        return this.cardName;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public String getCardBankName() {
        return this.cardBankName;
    }

    public void setCardBankName(String str) {
        this.cardBankName = str;
    }

    public String getCardDate() {
        return this.cardDate;
    }

    public void setCardDate(String str) {
        this.cardDate = str;
    }

    public String getCardInfo() {
        return this.cardInfo;
    }

    public void setCardInfo(String str) {
        this.cardInfo = str;
    }

    public String getCardDueDate() {
        return this.cardDueDate;
    }

    public void setCardDueDate(String str) {
        this.cardDueDate = str;
    }

    public String getCardTransName() {
        return this.cardTransName;
    }

    public void setCardTransName(String str) {
        this.cardTransName = str;
    }

    public double getCardAmount() {
        return this.cardAmount;
    }

    public void setCardAmount(double i) {
        this.cardAmount = i;
    }
    public double getPaymentAmount() {
        return this.paymentAmount;
    }

    public void setPaymentAmount(double i) {
        this.paymentAmount = i;
    }

    public int getTransCount() {
        return this.transCount;
    }
    
    public void setTrasSerials(int i) {
        this.transSerials = i;
    }

    public int getTrasSerials() {
        return this.transSerials;
    }

    public void setTransCount(int i) {
        this.transCount = i;
    }

//    public String getTranStr() {
//        return this.tranStr;
//    }
//
//    public void setTranStr(String tName, String tDate, double amount, boolean tf, boolean getRid) {
//        if (tf == true) {
//            this.tranStr += "- Transaction Name: " + tName + " Amount: $" + amount + " Date: (" + tDate + ")\n";
//        }
//        if (tf == false) {
//            this.tranStr = "- Transaction Name: " + tName + " Amount: $" + amount + " Date: (" + tDate + ")\n";
//        }
//        if (getRid == true) {
//            this.tranStr = "";
//        }
//    }

    /*
    
        public String getTranStr(String tName, String tDate, double amount, boolean secoundTime) {
   //"+ " Amount: $"+ UserTransList.getCardAmount() + " Date: ("+UserTransList.getCardDueDate() + ")\n";

    if (secoundTime == true) {
        this.tranStr += this.tranStr = "- Transaction Name: " + tName + " Amount: $" + amount + " Date: (" + tDate + ")\n";
    return this.tranStr;
    }

    
    return null;
    }
    
     */
//      Specail;
    public int getCardSerial() {
        return this.cardSerial;

    }

    public void setCardSerial(int i) {
        this.cardSerial = i;

    }

    public boolean getCardTrueFalse() {
        return this.cardtf;
    }

    public void setCardTrueFalse(boolean tf) {
        this.cardtf = tf;
    }

    public boolean getCardTransTrueFalse() {
        return this.cardTranstf;
    }

    public void setCardTransTrueFalse(boolean tf) {
        this.cardTranstf = tf;
    }
    
    
    public boolean getPaymentTrueFalse() {
        return this.paymenttf;
    }

    public void setPaymentTrueFalse(boolean tf) {
        this.paymenttf = tf;
    }

    
    
    
    public void setTransTrueFalse(boolean tf) {
        this.transtf = tf;
    }

    public boolean getTransTrueFalse() {
        return this.transtf;
    }

    
    
    public boolean getFirstTrans() {
        return this.firstTrans;
    }

    public void setFirstTrans(boolean tf) {
        this.firstTrans = tf;
    }



    public void setSecoundGet(boolean tf) {
        this.secoundGet = tf;
    }

    public boolean getSecoundGet() {
        return this.secoundGet;
    }

    public void setTran(boolean tf) {
        this.trans = tf;
    }

    public boolean getTran() {
        return this.trans;
    }

    public String getSaveString() {
        
    String str = this.cardName.replace(" ", "'") + " " + this.cardBankName.replace(" ", "'") + " " + this.cardDate.replace(" ", "'") + " " + this.cardInfo.replace(" ", "'").replace("\n", ")") + " " + this.cardDueDate.replace(" ", "'") + " " + this.cardTransName.replace(" ", "'")
            + " " /*+ this.tranStr.replace(" ", "'") + " " */+ this.cardAmount + " " + this.paymentAmount + " " + this.cardSerial + " " + this.cardtf + " " + this.cardTranstf
            + " " + this.firstTrans + " " + this.secoundGet + " " + this.trans + " " + this.transtf + " " + this.paymenttf + " " /*+ this.cardCount
            + " " */+ this.transCount + " " + this.transSerials;
//    System.out.println(str);
    return str;
    }
    
    @Override
    public String toString() {
        if (this.cardtf == true) {
            return this.cardBankName + ": " + this.cardName + " (" + this.cardDueDate + ")";
        }

        if (this.cardTranstf == true) {
            // expensesDate  cardTransName  cardAmount
            return this.cardTransName + ", $" + this.cardAmount + " " + this.cardDate;
        }
        if (this.transtf == true) {
         return this.cardTransName + ", $" + this.cardAmount + " " + this.cardDate;
        }

        this.transtf = false;
        this.cardtf = false;
        this.cardTranstf = false;
        return "Dont have it included";
    }
    

    /*

            if (this.expensestf == true) {
            return this.expensesBankName + ": " + this.expensesName + " (" + this.expensesDueDate + ")";
        }
            this.expensestf = false;
     */
//    public String getSaveString(){
//      String str = this.name + " " + this.rank + " " + this.serial + " " + this.gender;
//    return str;
//    }
}
