package src.LC3.four;

abstract class Employee {
    private final int empId;
    private final String empName;
    private final double salary;

    public Employee(int eId,String eName,double sal){
        empId = eId;
        empName = eName;
        salary = sal;
    }

    abstract double calculateSalary();
    abstract void displayInfo();

    public int getEmpId(){
        return empId;
    }
    public String getEmpName(){
        return empName;
    }
    public double getSalary(){
        return salary;
    }
}
