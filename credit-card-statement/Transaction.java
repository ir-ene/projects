public class Transaction
{
    private static int lastTx =1000;
    private int txNumber;
    private String date;
    private String merchant;
    private int amount;
    private String type;
    private CreditCard card;
    public Transaction (String date, CreditCard card, String type, int amount){
        this.date = date;
        this.card = card;
        this.type = type;
        this.amount = amount;
        this.merchant = "";
        this.txNumber = nextTx();
    }

    public Transaction (String date, CreditCard card, String type, int amount, String merchant){
        this.date = date;
        this.card = card;
        this.type = type;
        this.amount = amount;
        this.merchant = merchant;
        this.txNumber = nextTx();
    }

    private int nextTx(){
        return ++lastTx;   
    }

    public int getTxNumber(){
        return txNumber;   
    }

    public String getDate(){
        return date;   
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getMerchant(){
        return merchant;   
    }

    public void setMerchant(String merchant){
        this.merchant = merchant;
    }

    public int getAmount(){
        return amount;   
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public String getType(){
        return type;   
    }

    public void setType(String type){
        this.type = type;
    }

    public CreditCard getCard(){
        return card;   
    }

    public void setCard(CreditCard card){
        this.card = card;
    }

    public String toString(){
        return txNumber+" "+date+" "+card.getNumber()+" "+type+" "+amount+" "+merchant;
    }
}
