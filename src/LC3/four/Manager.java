package src.LC3.four;

public class Manager extends Employee{
    public Manager(int eId, String eName, double sal) {
        super(eId, eName, sal);
    }

    @Override
    public double calculateSalary() {
        double allowance = 0.05;
        return super.getSalary()+ allowance *super.getSalary();
    }

    @Override
    public void displayInfo() {
        System.out.println("<<<<<<<<<< Employee Details >>>>>>>>>>");
        System.out.println("Position: Manager");
        System.out.println("Manager ID: "+ super.getEmpId());
        System.out.println("Manager Name: "+super.getEmpName());
        double totalSalary = calculateSalary();
        System.out.println("Total Salary: "+ totalSalary);
        System.out.println("********Slip Ends Here*********");
        System.out.println();

    }
}
