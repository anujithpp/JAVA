package src.LC3.five;

import java.util.Scanner;

public interface PaymentMethod {
    void pay(double amount);
    void cancel(double amount);
    void display();
}


class CreditCard implements PaymentMethod{
    private String cardNumber;
    private String cardexpDate;
    private String cvv;
    private double balance;
    CreditCard(String cnum,String ced,String cv,double bal){
        cardNumber=cnum;
        cardexpDate=ced;
        cvv=cv;
        balance=bal;
    }
    public void pay(double amt){
        System.out.println("Amount payed:"+amt);
        if(balance>amt){
            double totbal=balance-amt;
            System.out.println("Total balance :"+totbal);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    public void cancel(double amt){
        System.out.println("Amount to cancel:"+amt);
        double totbal=balance;
        System.out.println("Total balance:"+totbal);
    }
    public void display(){
        System.out.println("Credit Card number:"+cardNumber);
        System.out.println("Credit Card expiry date:"+cardexpDate);
        System.out.println("Credit Card CVV:"+cvv);

    }
}

class PayPal implements PaymentMethod {
    private String email;
    private String password;
    double balance;

    PayPal(String em, String pasw, double bal) {
        email = em;
        password = pasw;
        balance = bal;
    }

    public void pay(double amt) {
        System.out.println("Amount payed " + amt);
        if (balance > amt) {
            double totbal = balance - amt;
            System.out.println("Total balance :" + totbal);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void cancel(double amt) {
        System.out.println("Amount to cancel:" + amt);
        double totbal = balance;
        System.out.println("Total balance:" + totbal);
    }

    public void display() {
        System.out.println("PayPal email:" + email);
        System.out.println("PayPal password:" + password);

    }


public static void main(String[] args) {
    Scanner obj = new Scanner(System.in);
    String cnumb, cexp, cvv;
    double balance;
    System.out.print("Enter the Credit card number:");
    cnumb = obj.next();
    System.out.print("Enter the Credit card expiry date:");
    cexp = obj.next();
    System.out.print("Enter the Credit CVV:");
    cvv = obj.next();
    System.out.print("Enter your current balance:");
    balance = obj.nextDouble();
    PaymentMethod pm = new CreditCard(cnumb, cexp, cvv, balance);
    double amtp;
    System.out.print("Enter the amount to be payed:");
    amtp = obj.nextDouble();
    pm.display();
    pm.pay(amtp);
    pm.cancel(amtp);
    String email, password;
    double bal;
    System.out.print("Enter the email:");
    email = obj.next();
    System.out.print("Enter the password:");
    password = obj.next();
    System.out.print("Enter the balance:");
    bal = obj.nextDouble();
    double amtpp;
    System.out.print("Enter the amount to pay:");
    amtpp = obj.nextDouble();

    PaymentMethod pmt = new PayPal(email, password, bal);
    pmt.display();
    pmt.pay(amtpp);
    pmt.cancel(amtpp);
}
}