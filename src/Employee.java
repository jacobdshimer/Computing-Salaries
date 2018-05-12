//Employee.java
//Author: Shimer, Jacob D.
//This is the employee class.  It is the super class

public class Employee {
    private String empName;
    private float monSalary;

    public Employee(String empName, float monSalary) {
        this.empName = empName;
        this.monSalary = monSalary;
    }

    // Getter to allow the subclasses to access the monthly salary to calculate
    // the annual salary
    public float getMonSalary() {
        return monSalary;
    }

    public float annualSalary() {
        return monSalary * 12;
    }

    @Override
    public String toString() {
        return "\n\tName: " + empName + "\n\tMonthly Salary:" + monSalary;
    }

    // This is purely to make displaying the program in a nicer manner
    public void display(){
        System.out.println("<<Employee>>" + this);
    }
}
