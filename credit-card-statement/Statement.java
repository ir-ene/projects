import java.util.ArrayList;
//3119181 Irene Chan
/**
 * ACS-1903
 * As3 q2 
 */
public class Statement{
    public static void main (String args[]){
        // create cards and transactions and add to lists
        CreditCard cc1 = new CreditCard("Harry", "777", 100000);
        CreditCard cc2 = new CreditCard("Ron", "080", 100);
        CreditCard cc3 = new CreditCard("Hermione", "100", 1000);
        ArrayList<CreditCard> cards = new ArrayList<>();
        cards.add(cc1); cards.add(cc2); cards.add(cc3); 

        ArrayList<Transaction> txns = new ArrayList<>();
        txns.add(new Transaction("Sep 1, 2018", cc1, "purchase", 1000, "Broomstix"));
        txns.add(new Transaction("Sep 1, 2018", cc1, "purchase", 100, "Flourish and Blotts"));        
        txns.add(new Transaction("Sep 1, 2018", cc3, "purchase", 100, "Flourish and Blotts")); 
        txns.add(new Transaction("Sep 1, 2018", cc2, "purchase",40, "Second-Hand Bookshop"));  
        txns.add(new Transaction("Sep 2, 2018", cc1, "purchase",100, "Ollivanders"));
        txns.add(new Transaction("Sep 2, 2018", cc2, "purchase",50, "Ollivanders"));
        txns.add(new Transaction("Sep 2, 2018", cc3, "purchase",80, "Ollivanders"));
        txns.add(new Transaction("Sep 3, 2018", cc3, "payment", 180));
        txns.add(new Transaction("Sep 3, 2018", cc2, "purchase",8, "HoneyDukes Express"));
        txns.add(new Transaction("Sep 3, 2018", cc1,"purchase",100, "HoneyDukes Express"));
        txns.add(new Transaction("Sep 4, 2018", cc1,"purchase",20, "Three Broomsticks"));
        txns.add(new Transaction("Sep 4, 2018", cc3,"purchase",20, "Three Broomsticks"));
        txns.add(new Transaction("Sep 4, 2018", cc2,"purchase",10, "Three Broomsticks"));
        txns.add(new Transaction("Sep 4, 2018", cc3,"purchase",10, "Three Broomsticks"));      
        // association on credit card
        for (Transaction t : txns){
            CreditCard c = t.getCard();
            c.addTransaction(t);
        }

        System.out.println("Credit Cards:");
        for (CreditCard c : cards){
            System.out.println(c);
        }

        System.out.println("\nTransactions:");
        for (Transaction t : txns){
            System.out.println(t);
        }

        System.out.println("\nStatement per holder:");
        for (CreditCard cc : cards){         
            System.out.println("Card number: "+cc.getNumber()+", Card holder: "+cc.getCardHolder());
            for (Transaction t : cc.getTransaction()){
                System.out.println(t.getTxNumber()+" "+t.getDate()+" "+t.getType()+" "+t.getAmount()+" "+t.getMerchant());
            }
            System.out.println("Balance: $"+cc.getBalance()+"\n");
        }
    }
}

