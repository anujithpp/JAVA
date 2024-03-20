package src.LC3.four;

class Programmer extends Employee {
    public Programmer(int eId, String eName, double sal) {
        super(eId, eName, sal);
    }

    @Override
    public double calculateSalary() {
        double allowance = 0.06;
        return super.getSalary()+ allowance *super.getSalary();
    }

    double totalSalary = calculateSalary();

    @Override
    public void displayInfo() {
        System.out.println("<<<<<<<<<< Employee Details >>>>>>>>>>");
        System.out.println("Position: Programmer");
        System.out.println("Programmer Employee ID: "+ super.getEmpId());
        System.out.println("Programmer Name: "+super.getEmpName());
        System.out.println("Total Salary: "+ totalSalary);
        System.out.println("********Slip Ends Here*********");
        System.out.println();

    }
}
