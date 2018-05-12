//Salesman.java
//Author: Shimer, Jacob D.
//This is the salesman class.  It inherits and extends the employee

class Salesman extends Employee {
    private float sales;

    public Salesman(String empName, float monSalary, float sales) {
        super(empName,monSalary);
        this.sales = sales;
    }

    // This is to calculate the annual salary of salesmen.  If their sales times .02%
    // is greater then $20000, it just adds the $20000 to their salary.  Else it'll
    // add the .02% to the salary.
    public float annualSalary() {
        if (sales * .02 > 20000) {
            return (getMonSalary() * 12) + 20000;
        } else {
            return (float)((getMonSalary() * 12) + (sales * .02));
        }
    }

    public String toString() {
        return super.toString() + "\n\tAmount in Sales:" + sales;
    }

    // This is purely to make displaying the program in a nicer manner
    public void display(){
        System.out.println("<<Salesman>>" + this);
    }
}
