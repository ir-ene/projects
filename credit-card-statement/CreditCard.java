import java.util.ArrayList;
public class CreditCard
{
    private int limit;
    private int balance;
    private String cardHolder;
    private String number;
    ArrayList<Transaction>transactions;
    public CreditCard (String cardHolder, String number, int limit){
        this.cardHolder = cardHolder;
        this.number = number;
        this.limit = limit;
        transactions = new ArrayList<>();
    }

    public void setTransaction(ArrayList<Transaction>transactions){
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction){
        String type = transaction.getType();
        if (type.equals("purchase")){
            if (balance+transaction.getAmount()<limit) balance += +transaction.getAmount();
            else transaction.setType("declined");
        }
        else if (type.equals("payment")) balance += - transaction.getAmount();
        transactions.add(transaction);
    }

    public ArrayList<Transaction>getTransaction(){
        return transactions;
    }

    public int getLimit(){
        return limit;   
    }

    public void setLimit(int limit){
        this.limit = limit;
    }

    public int getBalance(){
        return balance;   
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public String getCardHolder(){
        return cardHolder;   
    }

    public void setCardHolder(String cardHolder){
        this.cardHolder = cardHolder;
    }

    public String getNumber(){
        return number;   
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String toString(){
        return  number+" "+cardHolder+" "+balance+" "+limit;
    }
}
