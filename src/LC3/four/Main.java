package src.LC3.four;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many Employee details you want to print: ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++){
            System.out.println("Enter M for Manager and P for programmer");
            String choice = sc.next();

            if (choice.equals("m")){
                System.out.println("Enter Manger ID: ");
                int mId = sc.nextInt();
                System.out.println("Enter Manger Name: ");
                String mName = sc.next();
                System.out.println("Enter Manger Base Salary: ");
                double mSalary = sc.nextDouble();

                Manager mgr = new Manager(mId,mName,mSalary);
                mgr.displayInfo();
            }
            else if (choice.equals("M")){
                System.out.println("Enter Manger ID: ");
                int mId = sc.nextInt();
                System.out.println("Enter Manger Name: ");
                String mName = sc.next();
                System.out.println("Enter Manger Base Salary: ");
                double mSalary = sc.nextDouble();

                Manager mgr = new Manager(mId,mName,mSalary);
                mgr.displayInfo();
            }
            if (choice.equals("p")){
                System.out.println("Enter Programmer ID: ");
                int pID = sc.nextInt();
                System.out.println("Enter Programmer Name: ");
                String pName = sc.next();
                System.out.println("Enter Programmer Base Salary: ");
                double pSalary = sc.nextDouble();

                Programmer prg = new Programmer(pID,pName,pSalary);
                prg.displayInfo();
            }
            else if (choice.equals("P")){
                System.out.println("Enter Programmer ID: ");
                int pID = sc.nextInt();
                System.out.println("Enter Programmer Name: ");
                String pName = sc.next();
                System.out.println("Enter programmer Base Salary: ");
                double pSalary = sc.nextDouble();

                Programmer prg = new Programmer(pID,pName,pSalary);
                prg.displayInfo();
            }
        }
    }
}
